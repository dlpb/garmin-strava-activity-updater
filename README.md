# garmin-strava-activity-updater
Synchronise Gear usage across Garmin and Strava

## What is this app?
This app is a simple java app that will take two lists of data; one a data export from Strava, and the other a data 
export from Garmin.

It is designed to update the gear associated with Garmin activities, based on the data in the Strava feed. 

This app exists because of my forgetfulness.

You need to provide a list of activities for both services, the gear to filter Strava activities by, the gear to remove
 from Garmin and the gear to add to Garmin. Exact parameter details are below.
 
# How to obtain lists of Activities
## Garmin
Save the result of this URL: https://connect.garmin.com/modern/proxy/activitylist-service/activities/search/activities?limit=1000&start=0

The query parameters can be modified to get more or less activites.

## Strava
Request an account data export, and copy the resultant `activities.csv` file.

 
# How to obtain Gear IDs
## Garmin
Use the [Manage Gear](https://connect.garmin.com/modern/gear) part of the Garmin Connect web app, and from the URL for each piece of 
gear, extract the ID. 

## Strava
This will be the name of the gear, as associated with each activity.
 
# How are activities matched?
There are two steps to matching activites. It isn't perfect, just quick and dirty.

All activities are matched only by date. Distance could be used, but isn't currently.

For each Strava activity:
1. Is there a Garmin activity with the exact (to the second) start `LocalDateTime` as the Strava activity?
   - If yes, then it's a match.
2. Is there a Garmin activity that starts within a jitter period (+/- 60 seconds) of the Strava Activities' `LocalDateTime` start time?
   - If yes, then it's a match
3. A match could not be found.
   - It is possible to increase the success rate by increasing the Jitter period, but this could also lead to false 
   positives if several short activities happened at the same sort of time.
   
# How are Garmin Activities updated?
Garmin activities are updated using the Garmin Connect API, in the same way that the Web App would update the activity.

A retry mechanism exists to allow each request to be retried, up to 3 times.

The app requires the Garmin Cookie, referred to in this app as the Garmin Token. This can be obtained by inspecting a 
request made by the Garmin Connect web app, and copying the cookie field. It is unique to a User and a Session, and will 
expire after some time. 
> Requests may fail in this app if the cookie has expired.

# App Parameters

Garmin Strava Activity Gear Sync App expects exactly 6 params. The order is"

```java -jar GarminStravaActivitySyncApp.jar <garminActivitiesFilePath> <stravaActivitiesFilePath> <garminToken> <stravaFilterGear> <GarminGearToRemove> <GarminGearToAdd>"```

where the parameters have the following meaning / format:"
- `garminActivitiesFilePath` - the path to the Garmin activities json file, as extracted from https://connect.garmin.com/modern/proxy/activitylist-service/activities/search/activities?limit=1000&start=0
- `stravaActivitiesFilePath` - the path to the Strava activities CSV file, as extracted from an account data export file"
- `garminToken` - The web cookie token used by the Garmin Connect web app"
- `stravaFilterGear` - The name of the Strava Gear to filter Strava Activities By"
- `garminGearToRemove` - A comma separated list of IDs of Gear in Garmin to remove from all matched activites"
- `garminGearToAdd` - A comma separated list of IDs of Gear in Garmin to add to all matched activities"
