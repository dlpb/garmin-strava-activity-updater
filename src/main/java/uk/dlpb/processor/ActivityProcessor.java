package uk.dlpb.processor;

import uk.dlpb.model.GarminActivity;
import uk.dlpb.model.StravaActivity;

import java.util.stream.Stream;

public class ActivityProcessor {
    public Stream<StravaActivity> filterActivities(Stream<StravaActivity> activities, String gear){
        return activities.filter(a -> a.getActivity_Gear().equals(gear));
    }

    public GarminActivity findMatchedGarminActivity(StravaActivity stravaActivity, Stream<GarminActivity> garminActivities) {
        return garminActivities.filter(a -> a.getStartTimeGMT().isEqual(stravaActivity.getActivity_Date())).findFirst().orElseThrow(() -> new IllegalArgumentException("No matching activity found for Strava Activity " + stravaActivity.getActivity_ID() + " - " + stravaActivity.getActivity_Name() + " - on - " + stravaActivity.getActivity_Date()));
    }
}
