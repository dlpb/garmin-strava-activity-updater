package uk.dlpb.model;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StravaActivityTest {

    @Test
    public void shouldCreateActivityFromCsvLine() throws IOException {
        String line = "Activity ID,Activity Date,Activity Name,Activity Type,Activity Description,Elapsed Time,Distance,Relative Effort,Commute,Activity Gear,Filename,Athlete Weight,Bike Weight,Elapsed Time,Moving Time,Distance,Max Speed,Average Speed,Elevation Gain,Elevation Loss,Elevation Low,Elevation High,Max Grade,Average Grade,Average Positive Grade,Average Negative Grade,Max Cadence,Average Cadence,Max Heart Rate,Average Heart Rate,Max Watts,Average Watts,Calories,Max Temperature,Average Temperature,Relative Effort,Total Work,Number of Runs,Uphill Time,Downhill Time,Other Time,Perceived Exertion,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.type,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.start_time,Weighted Average Power,Power Count,Prefer Perceived Exertion,Perceived Relative Effort,Commute,Total Weight Lifted,From Upload,Grade Adjusted Distance,Weather Observation Time,Weather Condition,Weather Temperature,Apparent Temperature,Dewpoint,Humidity,Weather Pressure,Wind Speed,Wind Gust,Wind Bearing,Precipitation Intensity,Sunrise Time,Sunset Time,Moon Phase,Bike,Gear,Precipitation Probability,Precipitation Type,Cloud Cover,Weather Visibility,UV Index,Weather Ozone,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.jump_count,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.total_grit,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.avg_flow,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.flagged\n" +
                "4512261173,\"24 Dec 2020, 08:13:59\",Test activity cycling ,Ride,\"\",19595,101.17,,false,Lynskey,activities/4821174253.fit.gz,,10.0,19595.0,18566.0,101178.203125,11.5,5.449649810791016,739.0,768.0,-15.399999618530273,84.5999984741211,12.600000381469727,-0.02708093263208866,,,131.0,82.44711303710938,,,,70.17720031738281,2938.0,,3.0,,,,,,,,,,,,0.0,,0.0,,1.0,,,,,,,,,,,,,,,,4598181.0,,,,,,,,,,,";

        Path tempFile = Files.createTempFile("test-strava-activity", ".csv");
        Files.write(tempFile, line.getBytes());

        List<StravaActivity> activities = StravaActivity.fromFile(tempFile);
        assertEquals(activities.size(), 1);
        StravaActivity activity = activities.get(0);

        assertEquals(activity.getActivity_ID(), "4512261173");
        assertEquals(activity.getActivity_Date(), LocalDateTime.parse("24 Dec 2020, 08:13:59", DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm:ss")));
        assertEquals(activity.getActivity_Name(), "Test activity cycling");
        assertEquals(activity.getElapsed_Time(), 19595);
        assertEquals(activity.getDistance(), 101.17);
        assertEquals(activity.getActivity_Gear(), "Lynskey");

    }
}
