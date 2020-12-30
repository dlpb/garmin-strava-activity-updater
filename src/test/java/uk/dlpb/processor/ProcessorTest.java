package uk.dlpb.processor;

import org.junit.jupiter.api.Test;
import uk.dlpb.model.GarminActivity;
import uk.dlpb.model.StravaActivity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessorTest {

    @Test
    public void processorShouldFilterOnlyCertainActivitiesWithSpecifiedGear(){
        ActivityProcessor processor = new ActivityProcessor();

        List<StravaActivity> activities = new ArrayList<>();
        StravaActivity activity1 = new StravaActivity();
        activity1.setActivity_Gear("Bike");
        StravaActivity activity2 = new StravaActivity();
        activity2.setActivity_Gear("Shoes");
        activities.add(activity1);
        activities.add(activity2);

        Stream<StravaActivity> filteredActivitiesStream = processor.filterActivities(activities.stream(), "Bike");

        List<StravaActivity> filteredActivities = filteredActivitiesStream.collect(Collectors.toList());
        assertEquals(filteredActivities.size(), 1);
    }
    @Test
    public void processorShouldFindTheMatchingGarminActivityForAStravaActivity(){
        ActivityProcessor processor = new ActivityProcessor();

        List<StravaActivity> stravaActivities = new ArrayList<>();
        StravaActivity stravaActivity1 = new StravaActivity();
        stravaActivity1.setActivity_Date(LocalDateTime.of(2020,12,24,10,00,00));
        stravaActivity1.setActivity_Gear("Bike");
        StravaActivity stravaActivity2 = new StravaActivity();
        stravaActivity2.setActivity_Date(LocalDateTime.of(2020,12,24,11,00,00));
        stravaActivity2.setActivity_Gear("Shoes");
        stravaActivities.add(stravaActivity1);
        stravaActivities.add(stravaActivity2);

        List<GarminActivity> garminActivities = new ArrayList<>();
        GarminActivity garminActivity1 = new GarminActivity();
        garminActivity1.setActivityName("Activity 1");
        garminActivity1.setStartTimeGMT(LocalDateTime.of(2020,12,24,10,00,00));
        GarminActivity garminActivity2 = new GarminActivity();
        garminActivity2.setActivityName("Activity 2");
        garminActivity2.setStartTimeGMT(LocalDateTime.of(2020,12,24,11,00,00));
        garminActivities.add(garminActivity1);
        garminActivities.add(garminActivity2);

        Optional<GarminActivity> matchedActivityForStravaActivity1 = processor.findMatchedGarminActivity(stravaActivity1, garminActivities);
        Optional<GarminActivity> matchedActivityForStravaActivity2 = processor.findMatchedGarminActivity(stravaActivity2, garminActivities);
        assertEquals(matchedActivityForStravaActivity1.get().getActivityName(), "Activity 1");
        assertEquals(matchedActivityForStravaActivity2.get().getActivityName(), "Activity 2");
    }

    @Test
    public void processorShouldFindTheMatchingGarminActivityForAStravaActivityWhereStartTimeIsSlightlyOut(){
        ActivityProcessor processor = new ActivityProcessor();

        List<StravaActivity> stravaActivities = new ArrayList<>();
        StravaActivity stravaActivity1 = new StravaActivity();
        stravaActivity1.setActivity_Date(LocalDateTime.of(2018,4,17,16,21,26));
        stravaActivity1.setActivity_Gear("Bike");
        StravaActivity stravaActivity2 = new StravaActivity();
        stravaActivity2.setActivity_Date(LocalDateTime.of(2018,4,17,17,19,12));
        stravaActivity2.setActivity_Gear("Shoes");
        stravaActivities.add(stravaActivity1);
        stravaActivities.add(stravaActivity2);

        List<GarminActivity> garminActivities = new ArrayList<>();
        GarminActivity garminActivity1 = new GarminActivity();
        garminActivity1.setActivityName("Activity 1");
        garminActivity1.setStartTimeGMT(LocalDateTime.of(2018,4,17,16,21,26));
        GarminActivity garminActivity2 = new GarminActivity();
        garminActivity2.setActivityName("Activity 2");
        garminActivity2.setStartTimeGMT(LocalDateTime.of(2018,4,17,17,19,0));
        garminActivities.add(garminActivity1);
        garminActivities.add(garminActivity2);

        Optional<GarminActivity> matchedActivityForStravaActivity1 = processor.findMatchedGarminActivity(stravaActivity1, garminActivities);
        Optional<GarminActivity> matchedActivityForStravaActivity2 = processor.findMatchedGarminActivity(stravaActivity2, garminActivities);
        assertEquals(matchedActivityForStravaActivity1.get().getActivityName(), "Activity 1");
        assertEquals(matchedActivityForStravaActivity2.get().getActivityName(), "Activity 2");
    }

    @Test
    public void processorShouldThrowAnExceptionIfThereIsNoMatchingActivity(){
        ActivityProcessor processor = new ActivityProcessor();

        List<StravaActivity> stravaActivities = new ArrayList<>();
        StravaActivity stravaActivity1 = new StravaActivity();
        stravaActivity1.setActivity_Date(LocalDateTime.of(2020,12,24,10,00,00));
        stravaActivity1.setActivity_Gear("Bike");
        StravaActivity stravaActivity2 = new StravaActivity();
        stravaActivity2.setActivity_Date(LocalDateTime.of(2020,12,24,11,00,00));
        stravaActivity2.setActivity_Gear("Shoes");
        stravaActivities.add(stravaActivity1);
        stravaActivities.add(stravaActivity2);

        List<GarminActivity> garminActivities = new ArrayList<>();


        Optional<GarminActivity> matchedActivityForStravaActivity1 = processor.findMatchedGarminActivity(stravaActivity1, garminActivities);

        assertTrue(matchedActivityForStravaActivity1.isEmpty());
    }
}
