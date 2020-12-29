package uk.dlpb;

import uk.dlpb.model.GarminActivity;
import uk.dlpb.model.Params;
import uk.dlpb.model.StravaActivity;
import uk.dlpb.processor.ActivityProcessor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class App {
    public static void main(String[] params) throws IOException {
        Params appParams = new Params(params);

        Stream<StravaActivity> stravaActivities = StravaActivity.fromFile(Path.of(appParams.getStravaActivitiesFilePath())).stream();
        Stream<GarminActivity> garminActivities = GarminActivity.fromFile(Path.of(appParams.getGarminActivitiesFilePath())).stream();

        new ActivityProcessor().process(stravaActivities, garminActivities, appParams.getStravaFilterGear(), appParams.getGarminToken(), appParams.getGarminGearToRemove(), appParams.getGarminGearToAdd());

    }
}
