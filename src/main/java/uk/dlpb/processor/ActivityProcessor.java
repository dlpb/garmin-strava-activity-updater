package uk.dlpb.processor;

import uk.dlpb.model.GarminActivity;
import uk.dlpb.model.StravaActivity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Stream;

public class ActivityProcessor {

    public void process(
            Stream<StravaActivity> stravaActivityStream,
            Stream<GarminActivity> garminActivityStream,
            String stravaGearName,
            String garminToken,
            List<String> garminGearToRemove,
            List<String> garminGearToAdd) {
        filterActivities(stravaActivityStream, stravaGearName)
                .map(a -> findMatchedGarminActivity(a, garminActivityStream))
                .forEach(a -> {
                    updateGarminActivity(a, garminToken, garminGearToRemove, garminGearToAdd);
                });
    }

    private String makeUnlinkUrl(String garminGearId, String garminActivityId){
        return "https://connect.garmin.com/modern/proxy/gear-service/gear/unlink/"+garminGearId+"/activity/" + garminActivityId;
    }

    private String makeLinkUrl(String garminGearId, String garminActivityId){
        return "https://connect.garmin.com/modern/proxy/gear-service/gear/link/"+garminGearId+"/activity/" + garminActivityId;
    }

    private void removeGear(String garminActivityId, String garminToken, List<String> garminGearToRemove){
        garminGearToRemove.forEach(g -> makeHttpRequest(makeUnlinkUrl(g, garminActivityId), garminToken));
    }

    private void addGear(String garminActivityId, String garminToken, List<String> garminGearToAdd) {
        garminGearToAdd.forEach(g -> makeHttpRequest(makeLinkUrl(g, garminActivityId), garminToken));
    }

    private void makeHttpRequest(String url, String garminToken) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header( "User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0" )
                .header( "Accept","*/*" )
                .header( "Accept-Language","en-GB,en;q=0.5")
                .header( "NK","NT" )
                .header( "X-app-ver","4.37.4.1" )
                .header( "X-lang","en-US" )
                .header( "X-HTTP-Method-Override","PUT" )
                .header( "X-Requested-With","XMLHttpRequest" )
                .header( "Origin","https://connect.garmin.com" )
                .header( "Referer","https://connect.garmin.com/modern/activity/5997342560" )
                .header( "Cookie", garminToken )
                .header( "DNT","1" )
                .header( "Sec-GPC","1" )
                .header( "TE","Trailers")
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
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

    public GarminActivity findMatchedGarminActivity(StravaActivity stravaActivity, Stream<GarminActivity> garminActivities) {
        return garminActivities.filter(a -> a.getStartTimeGMT().isEqual(stravaActivity.getActivity_Date())).findFirst().orElseThrow(() -> new IllegalArgumentException("No matching activity found for Strava Activity " + stravaActivity.getActivity_ID() + " - " + stravaActivity.getActivity_Name() + " - on - " + stravaActivity.getActivity_Date()));
    }
}
