package uk.dlpb.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GarminActivityTest {

    @Test
    public void shouldCreateActivityFromJson() throws IOException {
        String json = "[" +
                "    {\n" +
                "        \"activityId\": 5997342560,\n" +
                "        \"activityName\": \"Test activity Cycling\",\n" +
                "        \"description\": null,\n" +
                "        \"startTimeLocal\": \"2020-12-24 08:13:59\",\n" +
                "        \"startTimeGMT\": \"2020-12-24 08:13:59\",\n" +
                "        \"activityType\": {\n" +
                "            \"typeId\": 2,\n" +
                "            \"typeKey\": \"cycling\",\n" +
                "            \"parentTypeId\": 17,\n" +
                "            \"sortOrder\": 8,\n" +
                "            \"isHidden\": false\n" +
                "        },\n" +
                "        \"eventType\": {\n" +
                "            \"typeId\": 9,\n" +
                "            \"typeKey\": \"uncategorized\",\n" +
                "            \"sortOrder\": 10\n" +
                "        },\n" +
                "        \"comments\": null,\n" +
                "        \"parentId\": null,\n" +
                "        \"distance\": 101180.1171875,\n" +
                "        \"duration\": 19594.833984375,\n" +
                "        \"elapsedDuration\": 1.9594833984375E7,\n" +
                "        \"movingDuration\": 18834.0,\n" +
                "        \"elevationGain\": 739.0,\n" +
                "        \"elevationLoss\": 768.0,\n" +
                "        \"averageSpeed\": 5.164000034332275,\n" +
                "        \"maxSpeed\": 11.710000038146973,\n" +
                "        \"startLatitude\": 0.1,\n" +
                "        \"startLongitude\": 0.1,\n" +
                "        \"hasPolyline\": true,\n" +
                "        \"ownerId\": 14304694,\n" +
                "        \"ownerDisplayName\": \"dlpb\",\n" +
                "        \"ownerFullName\": \"Daniel Brown\",\n" +
                "        \"ownerProfileImageUrlSmall\": \"https://s3.amazonaws.com/garmin-connect-prod/profile_images/b094d691-fc6c-48b3-a780-50e08955affe-14304694.jpg\",\n" +
                "        \"ownerProfileImageUrlMedium\": \"https://s3.amazonaws.com/garmin-connect-prod/profile_images/8a367d1c-d855-4f29-b9c8-84b0ea3c8ff4-14304694.jpg\",\n" +
                "        \"ownerProfileImageUrlLarge\": \"https://s3.amazonaws.com/garmin-connect-prod/profile_images/49efd860-a2e1-44b9-8f2e-b1b96bee3222-14304694.jpg\",\n" +
                "        \"calories\": 2938.0,\n" +
                "        \"averageHR\": null,\n" +
                "        \"maxHR\": null,\n" +
                "        \"averageRunningCadenceInStepsPerMinute\": null,\n" +
                "        \"maxRunningCadenceInStepsPerMinute\": null,\n" +
                "        \"averageBikingCadenceInRevPerMinute\": 82.0,\n" +
                "        \"maxBikingCadenceInRevPerMinute\": 131.0,\n" +
                "        \"averageSwimCadenceInStrokesPerMinute\": null,\n" +
                "        \"maxSwimCadenceInStrokesPerMinute\": null,\n" +
                "        \"averageSwolf\": null,\n" +
                "        \"activeLengths\": null,\n" +
                "        \"steps\": null,\n" +
                "        \"conversationUuid\": null,\n" +
                "        \"conversationPk\": null,\n" +
                "        \"numberOfActivityLikes\": null,\n" +
                "        \"numberOfActivityComments\": null,\n" +
                "        \"likedByUser\": null,\n" +
                "        \"commentedByUser\": null,\n" +
                "        \"activityLikeDisplayNames\": null,\n" +
                "        \"activityLikeFullNames\": null,\n" +
                "        \"requestorRelationship\": null,\n" +
                "        \"userRoles\": [\n" +
                "            \"ROLE_CONNECTUSER\",\n" +
                "            \"ROLE_FITNESS_USER\",\n" +
                "            \"ROLE_CONNECT_2_USER\"\n" +
                "        ],\n" +
                "        \"privacy\": {\n" +
                "            \"typeId\": 2,\n" +
                "            \"typeKey\": \"private\"\n" +
                "        },\n" +
                "        \"userPro\": false,\n" +
                "        \"courseId\": null,\n" +
                "        \"poolLength\": null,\n" +
                "        \"unitOfPoolLength\": null,\n" +
                "        \"hasVideo\": false,\n" +
                "        \"videoUrl\": null,\n" +
                "        \"timeZoneId\": 159,\n" +
                "        \"beginTimestamp\": 1608797639000,\n" +
                "        \"sportTypeId\": 2,\n" +
                "        \"avgPower\": null,\n" +
                "        \"maxPower\": null,\n" +
                "        \"aerobicTrainingEffect\": null,\n" +
                "        \"anaerobicTrainingEffect\": null,\n" +
                "        \"strokes\": 18822.0,\n" +
                "        \"normPower\": null,\n" +
                "        \"leftBalance\": null,\n" +
                "        \"rightBalance\": null,\n" +
                "        \"avgLeftBalance\": null,\n" +
                "        \"max20MinPower\": null,\n" +
                "        \"avgVerticalOscillation\": null,\n" +
                "        \"avgGroundContactTime\": null,\n" +
                "        \"avgStrideLength\": null,\n" +
                "        \"avgFractionalCadence\": null,\n" +
                "        \"maxFractionalCadence\": null,\n" +
                "        \"trainingStressScore\": null,\n" +
                "        \"intensityFactor\": null,\n" +
                "        \"vO2MaxValue\": null,\n" +
                "        \"avgVerticalRatio\": null,\n" +
                "        \"avgGroundContactBalance\": null,\n" +
                "        \"lactateThresholdBpm\": null,\n" +
                "        \"lactateThresholdSpeed\": null,\n" +
                "        \"maxFtp\": null,\n" +
                "        \"avgStrokeDistance\": null,\n" +
                "        \"avgStrokeCadence\": null,\n" +
                "        \"maxStrokeCadence\": null,\n" +
                "        \"workoutId\": null,\n" +
                "        \"avgStrokes\": null,\n" +
                "        \"minStrokes\": null,\n" +
                "        \"deviceId\": 3910024244,\n" +
                "        \"minTemperature\": 0.0,\n" +
                "        \"maxTemperature\": null,\n" +
                "        \"minElevation\": -1539.9999618530273,\n" +
                "        \"maxElevation\": 8459.99984741211,\n" +
                "        \"avgDoubleCadence\": null,\n" +
                "        \"maxDoubleCadence\": null,\n" +
                "        \"summarizedExerciseSets\": null,\n" +
                "        \"maxDepth\": null,\n" +
                "        \"avgDepth\": null,\n" +
                "        \"surfaceInterval\": null,\n" +
                "        \"startN2\": null,\n" +
                "        \"endN2\": null,\n" +
                "        \"startCns\": null,\n" +
                "        \"endCns\": null,\n" +
                "        \"summarizedDiveInfo\": {\n" +
                "            \"weight\": null,\n" +
                "            \"weightUnit\": null,\n" +
                "            \"visibility\": null,\n" +
                "            \"visibilityUnit\": null,\n" +
                "            \"surfaceCondition\": null,\n" +
                "            \"current\": null,\n" +
                "            \"waterType\": null,\n" +
                "            \"waterDensity\": null,\n" +
                "            \"summarizedDiveGases\": [],\n" +
                "            \"totalSurfaceTime\": null\n" +
                "        },\n" +
                "        \"activityLikeAuthors\": null,\n" +
                "        \"avgVerticalSpeed\": null,\n" +
                "        \"maxVerticalSpeed\": 0.5,\n" +
                "        \"floorsClimbed\": null,\n" +
                "        \"floorsDescended\": null,\n" +
                "        \"manufacturer\": \"GARMIN\",\n" +
                "        \"diveNumber\": null,\n" +
                "        \"locationName\": \"Barking and Dagenham\",\n" +
                "        \"bottomTime\": null,\n" +
                "        \"lapCount\": 2,\n" +
                "        \"endLatitude\": null,\n" +
                "        \"endLongitude\": null,\n" +
                "        \"minAirSpeed\": null,\n" +
                "        \"maxAirSpeed\": null,\n" +
                "        \"avgAirSpeed\": null,\n" +
                "        \"avgWindYawAngle\": null,\n" +
                "        \"minCda\": null,\n" +
                "        \"maxCda\": null,\n" +
                "        \"avgCda\": null,\n" +
                "        \"avgWattsPerCda\": null,\n" +
                "        \"flow\": null,\n" +
                "        \"grit\": null,\n" +
                "        \"jumpCount\": null,\n" +
                "        \"caloriesEstimated\": null,\n" +
                "        \"caloriesConsumed\": null,\n" +
                "        \"waterEstimated\": null,\n" +
                "        \"waterConsumed\": null,\n" +
                "        \"maxAvgPower_1\": null,\n" +
                "        \"maxAvgPower_2\": null,\n" +
                "        \"maxAvgPower_5\": null,\n" +
                "        \"maxAvgPower_10\": null,\n" +
                "        \"maxAvgPower_20\": null,\n" +
                "        \"maxAvgPower_30\": null,\n" +
                "        \"maxAvgPower_60\": null,\n" +
                "        \"maxAvgPower_120\": null,\n" +
                "        \"maxAvgPower_300\": null,\n" +
                "        \"maxAvgPower_600\": null,\n" +
                "        \"maxAvgPower_1200\": null,\n" +
                "        \"maxAvgPower_1800\": null,\n" +
                "        \"maxAvgPower_3600\": null,\n" +
                "        \"maxAvgPower_7200\": null,\n" +
                "        \"maxAvgPower_18000\": null,\n" +
                "        \"excludeFromPowerCurveReports\": null,\n" +
                "        \"totalSets\": null,\n" +
                "        \"activeSets\": null,\n" +
                "        \"totalReps\": null,\n" +
                "        \"minRespirationRate\": null,\n" +
                "        \"maxRespirationRate\": null,\n" +
                "        \"avgRespirationRate\": null,\n" +
                "        \"trainingEffectLabel\": null,\n" +
                "        \"activityTrainingLoad\": null,\n" +
                "        \"avgFlow\": null,\n" +
                "        \"avgGrit\": null,\n" +
                "        \"minActivityLapDuration\": 3797.547119140625,\n" +
                "        \"avgStress\": null,\n" +
                "        \"startStress\": null,\n" +
                "        \"endStress\": null,\n" +
                "        \"differenceStress\": null,\n" +
                "        \"maxStress\": null,\n" +
                "        \"aerobicTrainingEffectMessage\": null,\n" +
                "        \"anaerobicTrainingEffectMessage\": null,\n" +
                "        \"splitSummaries\": [],\n" +
                "        \"hasSplits\": false,\n" +
                "        \"moderateIntensityMinutes\": null,\n" +
                "        \"vigorousIntensityMinutes\": null,\n" +
                "        \"manualActivity\": false,\n" +
                "        \"favorite\": false,\n" +
                "        \"decoDive\": null,\n" +
                "        \"elevationCorrected\": false,\n" +
                "        \"atpActivity\": false,\n" +
                "        \"pr\": false,\n" +
                "        \"autoCalcCalories\": false,\n" +
                "        \"parent\": false,\n" +
                "        \"purposeful\": false\n" +
                "    }" +
                "]";

        Path tempFile = Files.createTempFile("test-garmin-activity", ".json");
        Files.write(tempFile, json.getBytes());

        List<GarminActivity> activities = GarminActivity.fromFile(tempFile);

        assertEquals(activities.size(), 1);
        GarminActivity activity = activities.get(0);

        assertEquals(activity.getActivityId(), "5997342560");
        assertEquals(activity.getStartTimeGMT(), LocalDateTime.parse("24 Dec 2020, 08:13:59", DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm:ss")));
        assertEquals(activity.getActivityName(), "Test activity Cycling");
        assertEquals(activity.getElapsedDuration(), 1.9594833984375E7);
        assertEquals(activity.getDistance(), 101180.1171875);
    }
}
