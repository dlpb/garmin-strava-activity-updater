package uk.dlpb.model;

import java.util.Arrays;
import java.util.List;

public class Params {
    private String garminActivitiesFilePath;
    private String stravaActivitiesFilePath;
    private String garminToken;
    private String stravaFilterGear;
    private List<String> garminGearToRemove;
    private List<String> garminGearToAdd;

    public Params(String[] params) {
        if(params.length != 6){
            System.out.println("Garmin Strava Activity Gear Sync App expects exactly 6 params. The order is");
            System.out.println("");
            System.out.println("java -jar GarminStravaActivitySyncApp.jar <garminActivitiesFilePath> <stravaActivitiesFilePath> <garminToken> <stravaFilterGear> <GarminGearToRemove> <GarminGearToAdd>");
            System.out.println("");
            System.out.println("where the parameters have the following meaning / format:");
            System.out.println("    garminActivitiesFilePath - the path to the Garmin activities json file, as extracted from 'https://connect.garmin.com/modern/proxy/activitylist-service/activities/search/activities?limit=1000&start=0'");
            System.out.println("    stravaActivitiesFilePath - the path to the Strava activities CSV file, as extracted from an account data export file");
            System.out.println("    garminToken - The web cookie token used by the Garmin Connect web app");
            System.out.println("    stravaFilterGear - The name of the Strava Gear to filter Strava Activities By");
            System.out.println("    garminGearToRemove - A comma separated list of IDs of Gear in Garmin to remove from all matched activites");
            System.out.println("    garminGearToAdd - A comma separated list of IDs of Gear in Garmin to add to all matched activities");

            throw new IllegalArgumentException("Invalid number of arguments supplied");
        }
        garminActivitiesFilePath = params[0];
        stravaActivitiesFilePath = params[1];
        garminToken = params[2];
        stravaFilterGear = params[3];
        garminGearToRemove = Arrays.asList(params[4].split(","));
        garminGearToAdd = Arrays.asList(params[5]);

        System.out.println("Created parameters of:");
        System.out.println("    garminActivitiesFilePath - " + garminActivitiesFilePath);
        System.out.println("    stravaActivitiesFilePath - " + stravaActivitiesFilePath);
        System.out.println("    garminToken - " + garminToken);
        System.out.println("    stravaFilterGear - " + stravaFilterGear);
        System.out.println("    garminGearToRemove - " + garminGearToRemove);
        System.out.println("    garminGearToAdd - " + garminGearToAdd);

    }

    public String getGarminActivitiesFilePath() {
        return garminActivitiesFilePath;
    }

    public String getStravaActivitiesFilePath() {
        return stravaActivitiesFilePath;
    }

    public String getGarminToken() {
        return garminToken;
    }

    public String getStravaFilterGear() {
        return stravaFilterGear;
    }

    public List<String> getGarminGearToRemove() {
        return garminGearToRemove;
    }

    public List<String> getGarminGearToAdd() {
        return garminGearToAdd;
    }
}
