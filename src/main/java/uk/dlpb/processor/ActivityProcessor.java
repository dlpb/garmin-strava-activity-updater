package uk.dlpb.processor;

import uk.dlpb.model.GarminActivity;
import uk.dlpb.model.StravaActivity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.SECONDS;

public class ActivityProcessor {

    public void process(
            Stream<StravaActivity> stravaActivityStream,
            Stream<GarminActivity> garminActivityStream,
            String stravaGearName,
            String garminToken,
            List<String> garminGearToRemove,
            List<String> garminGearToAdd) {

        List<GarminActivity> garminActivities = garminActivityStream.collect(Collectors.toList());
        long updatedActivities = filterActivities(stravaActivityStream, stravaGearName)
                .map(a -> findMatchedGarminActivity(a, garminActivities))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(a -> {
                    System.out.println("Processing Garmin Activity " + a.getActivityName() + " (" + a.getActivityId() + ")");
                    updateGarminActivity(a, garminToken, garminGearToRemove, garminGearToAdd);
                    return 1;
                }).count();

        System.out.println("Updated " + updatedActivities + " activities");
    }

    private String makeUnlinkUrl(String garminGearId, String garminActivityId){
        return "https://connect.garmin.com/modern/proxy/gear-service/gear/unlink/"+garminGearId+"/activity/" + garminActivityId;
    }

    private String makeLinkUrl(String garminGearId, String garminActivityId){
        return "https://connect.garmin.com/modern/proxy/gear-service/gear/link/"+garminGearId+"/activity/" + garminActivityId;
    }

    private void removeGear(String garminActivityId, String garminToken, List<String> garminGearToRemove){
        garminGearToRemove.forEach(g -> {
            System.out.println("    Removing gear " + g + " from activity " + garminActivityId );
            System.out.print("        ");
            makeHttpRequest(makeUnlinkUrl(g, garminActivityId), garminToken);
        });
    }

    private void addGear(String garminActivityId, String garminToken, List<String> garminGearToAdd) {
        garminGearToAdd.forEach(g -> {
            System.out.println("    Adding gear " + g + " from activity " + garminActivityId );
            System.out.print("        ");
            makeHttpRequest(makeLinkUrl(g, garminActivityId), garminToken);
        });
    }

    private void makeHttpRequest(String url, String garminToken) {
       makeOrRetryHttpRequest(url, garminToken, 1, 3);
    }

    private void makeOrRetryHttpRequest(String url, String garminToken, int currentAttempt, int maxAttempts) {
        System.out.println("            Attempt " + currentAttempt + " of " + maxAttempts + " - make HTTP Request to " + url + "");
        if(currentAttempt > maxAttempts)
            throw new CompletionException("Underlying HTTP Connection could not be complated in the maximum number of attempts: " + maxAttempts, new TimeoutException());
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0")
                    .header("Accept", "*/*")
                    .header("Accept-Language", "en-GB,en;q=0.5")
                    .header("NK", "NT")
                    .header("X-app-ver", "4.37.4.1")
                    .header("X-lang", "en-US")
                    .header("X-HTTP-Method-Override", "PUT")
                    .header("X-Requested-With", "XMLHttpRequest")
                    .header("Origin", "https://connect.garmin.com")
                    .header("Referer", "https://connect.garmin.com/modern/activity/5997342560")
                    .header("Cookie", garminToken)
                    .header("DNT", "1")
                    .header("Sec-GPC", "1")
                    .header("TE", "Trailers")
                    .PUT(HttpRequest.BodyPublishers.noBody())
                    .build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .orTimeout(60, TimeUnit.SECONDS)
                    .join();
        } catch (Exception e) {
            System.out.println("            Exception occurred on attempt " + currentAttempt + " of " + maxAttempts);
            System.err.println(e);
            makeOrRetryHttpRequest(url, garminToken, currentAttempt + 1, maxAttempts);
        }
    }

    public void updateGarminActivity(
            GarminActivity activity,
            String garminToken,
            List<String> gearToRemove,
            List<String> gearToAdd
    ) {
       removeGear(activity.getActivityId(), garminToken, gearToRemove);
       addGear(activity.getActivityId(), garminToken, gearToAdd);
    }

    public Stream<StravaActivity> filterActivities(Stream<StravaActivity> activities, String gear){
        return activities.filter(a -> a.getActivity_Gear().equals(gear));
    }

    public Optional<GarminActivity> findMatchedGarminActivity(StravaActivity stravaActivity, List<GarminActivity> garminActivities) {
        System.out.println("***********************************************************************************************************************************");
        System.out.println("Matching Strava Activity " + stravaActivity.getActivity_Name() + " (" + stravaActivity.getActivity_ID() + ") to Garmin activity ..." );
        Optional<GarminActivity> maybeExactlyMatchingActivity = garminActivities.stream().filter(a -> a.getStartTimeGMT().isEqual(stravaActivity.getActivity_Date())).findFirst();
        if(maybeExactlyMatchingActivity.isPresent()) {
            System.out.println("  Exact match found - " + maybeExactlyMatchingActivity.get().getStartTimeGMT());
            return maybeExactlyMatchingActivity;
        }
       else {
            //find a more loosely matching activity within 30 seconds of this one
            int jitter = 60;
            LocalDateTime activityStartTime = stravaActivity.getActivity_Date();
            LocalDateTime maxAfterActivity = activityStartTime.plus(jitter, SECONDS);
            LocalDateTime maxBeforeActivity = activityStartTime.minus(jitter, SECONDS);
            Optional<GarminActivity> maybeFuzzyMatchingActivity = garminActivities.stream().filter(a -> (a.getStartTimeGMT().isEqual(maxBeforeActivity) || a.getStartTimeGMT().isAfter(maxBeforeActivity)) &&
                    (a.getStartTimeGMT().isBefore(maxAfterActivity) || a.getStartTimeGMT().isEqual(maxAfterActivity))).findFirst();

            if(maybeFuzzyMatchingActivity.isPresent()) {
                System.out.println("  Fuzzy Match found - " + maybeFuzzyMatchingActivity.get().getStartTimeGMT());
                return maybeFuzzyMatchingActivity;
            }
            else {
                System.out.println("No matching activity found for Strava Activity " + stravaActivity.getActivity_ID() + " - " + stravaActivity.getActivity_Name() + " - on - " + stravaActivity.getActivity_Date() + " found starting within +/- " + jitter + " seconds");
            }
        }
        return Optional.empty();
    }
}
