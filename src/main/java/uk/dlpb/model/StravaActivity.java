package uk.dlpb.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import javax.swing.text.DateFormatter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StravaActivity {
    //fields Activity ID,Activity Date,Activity Name,Activity Type,Activity Description,Elapsed Time,Distance,Relative Effort,Commute,Activity Gear,Filename,Athlete Weight,Bike Weight,Elapsed Time,Moving Time,Distance,Max Speed,Average Speed,Elevation Gain,Elevation Loss,Elevation Low,Elevation High,Max Grade,Average Grade,Average Positive Grade,Average Negative Grade,Max Cadence,Average Cadence,Max Heart Rate,Average Heart Rate,Max Watts,Average Watts,Calories,Max Temperature,Average Temperature,Relative Effort,Total Work,Number of Runs,Uphill Time,Downhill Time,Other Time,Perceived Exertion,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.type,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.start_time,Weighted Average Power,Power Count,Prefer Perceived Exertion,Perceived Relative Effort,Commute,Total Weight Lifted,From Upload,Grade Adjusted Distance,Weather Observation Time,Weather Condition,Weather Temperature,Apparent Temperature,Dewpoint,Humidity,Weather Pressure,Wind Speed,Wind Gust,Wind Bearing,Precipitation Intensity,Sunrise Time,Sunset Time,Moon Phase,Bike,Gear,Precipitation Probability,Precipitation Type,Cloud Cover,Weather Visibility,UV Index,Weather Ozone,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.jump_count,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.total_grit,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.avg_flow,translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.flagged
    private String Activity_ID;
    private LocalDateTime Activity_Date;
    private String Activity_Name;
    private String Activity_Type;
    private String Activity_Description;
    private double Elapsed_Time;
    private double Distance;
    private String Relative_Effort;
    private boolean Commute;
    private String Activity_Gear;
    private String Filename;
    private String Athlete_Weight;
    private String Bike_Weight;
    private String Elapsed_Time_2;
    private String Moving_Time;
    private String Distance_2;
    private String Max_Speed;
    private String Average_Speed;
    private String Elevation_Gain;
    private String Elevation_Loss;
    private String Elevation_Low;
    private String Elevation_High;
    private String Max_Grade;
    private String Average_Grade;
    private String Average_Positive_Grade;
    private String Average_Negative_Grade;
    private String Max_Cadence;
    private String Average_Cadence;
    private String Max_Heart_Rate;
    private String Average_Heart_Rate;
    private String Max_Watts;
    private String Average_Watts;
    private String Calories;
    private String Max_Temperature;
    private String Average_Temperature;
    private String Relative_Effort_2;
    private String Total_Work;
    private String Number_of_Runs;
    private String Uphill_Time;
    private String Downhill_Time;
    private String Other_Time;
    private String Perceived_Exertion;
    private String Activity_Horton_Type;
    private String Activity_Horton_Start_Time;
    private String Weighted_Average_Power;
    private String Power_Count;
    private String Prefer_Perceived_Exertion;
    private String Perceived_Relative_Effort;
    private String Commute_2;
    private String Total_Weight_Lifted;
    private String From_Upload;
    private String Grade_Adjusted_Distance;
    private String Weather_Observation_Time;
    private String Weather_Condition;
    private String Weather_Temperature;
    private String Apparent_Temperature;
    private String Dewpoint;
    private String Humidity;
    private String Weather_Pressure;
    private String Wind_Speed;
    private String Wind_Gust;
    private String Wind_Bearing;
    private String Precipitation_Intensity;
    private String Sunrise_Time;
    private String Sunset_Time;
    private String Moon_Phase;
    private String Bike;
    private String Gear;
    private String Precipitation_Probability;
    private String Precipitation_Type;
    private String Cloud_Cover;
    private String Weather_Visibility;
    private String UV_Index;
    private String Weather_Ozone;
    private String jump_count;
    private String total_grit;
    private String avg_flow;

    public String getActivity_ID() {
        return Activity_ID;
    }

    public void setActivity_ID(String activity_ID) {
        Activity_ID = activity_ID;
    }

    public LocalDateTime getActivity_Date() {
        return Activity_Date;
    }

    public void setActivity_Date(LocalDateTime activity_Date) {
        Activity_Date = activity_Date;
    }

    public String getActivity_Name() {
        return Activity_Name;
    }

    public void setActivity_Name(String activity_Name) {
        Activity_Name = activity_Name;
    }

    public String getActivity_Type() {
        return Activity_Type;
    }

    public void setActivity_Type(String activity_Type) {
        Activity_Type = activity_Type;
    }

    public String getActivity_Description() {
        return Activity_Description;
    }

    public void setActivity_Description(String activity_Description) {
        Activity_Description = activity_Description;
    }

    public double getElapsed_Time() {
        return Elapsed_Time;
    }

    public void setElapsed_Time(double elapsed_Time) {
        Elapsed_Time = elapsed_Time;
    }

    public Double getDistance() {
        return Distance;
    }

    public void setDistance(double distance) {
        Distance = distance;
    }

    public String getRelative_Effort() {
        return Relative_Effort;
    }

    public void setRelative_Effort(String relative_Effort) {
        Relative_Effort = relative_Effort;
    }

    public boolean isCommute() {
        return Commute;
    }

    public void setCommute(boolean commute) {
        Commute = commute;
    }

    public String getActivity_Gear() {
        return Activity_Gear;
    }

    public void setActivity_Gear(String activity_Gear) {
        Activity_Gear = activity_Gear;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }

    public String getAthlete_Weight() {
        return Athlete_Weight;
    }

    public void setAthlete_Weight(String athlete_Weight) {
        Athlete_Weight = athlete_Weight;
    }

    public String getBike_Weight() {
        return Bike_Weight;
    }

    public void setBike_Weight(String bike_Weight) {
        Bike_Weight = bike_Weight;
    }

    public String getElapsed_Time_2() {
        return Elapsed_Time_2;
    }

    public void setElapsed_Time_2(String elapsed_Time_2) {
        Elapsed_Time_2 = elapsed_Time_2;
    }

    public String getMoving_Time() {
        return Moving_Time;
    }

    public void setMoving_Time(String moving_Time) {
        Moving_Time = moving_Time;
    }

    public String getDistance_2() {
        return Distance_2;
    }

    public void setDistance_2(String distance_2) {
        Distance_2 = distance_2;
    }

    public String getMax_Speed() {
        return Max_Speed;
    }

    public void setMax_Speed(String max_Speed) {
        Max_Speed = max_Speed;
    }

    public String getAverage_Speed() {
        return Average_Speed;
    }

    public void setAverage_Speed(String average_Speed) {
        Average_Speed = average_Speed;
    }

    public String getElevation_Gain() {
        return Elevation_Gain;
    }

    public void setElevation_Gain(String elevation_Gain) {
        Elevation_Gain = elevation_Gain;
    }

    public String getElevation_Loss() {
        return Elevation_Loss;
    }

    public void setElevation_Loss(String elevation_Loss) {
        Elevation_Loss = elevation_Loss;
    }

    public String getElevation_Low() {
        return Elevation_Low;
    }

    public void setElevation_Low(String elevation_Low) {
        Elevation_Low = elevation_Low;
    }

    public String getElevation_High() {
        return Elevation_High;
    }

    public void setElevation_High(String elevation_High) {
        Elevation_High = elevation_High;
    }

    public String getMax_Grade() {
        return Max_Grade;
    }

    public void setMax_Grade(String max_Grade) {
        Max_Grade = max_Grade;
    }

    public String getAverage_Grade() {
        return Average_Grade;
    }

    public void setAverage_Grade(String average_Grade) {
        Average_Grade = average_Grade;
    }

    public String getAverage_Positive_Grade() {
        return Average_Positive_Grade;
    }

    public void setAverage_Positive_Grade(String average_Positive_Grade) {
        Average_Positive_Grade = average_Positive_Grade;
    }

    public String getAverage_Negative_Grade() {
        return Average_Negative_Grade;
    }

    public void setAverage_Negative_Grade(String average_Negative_Grade) {
        Average_Negative_Grade = average_Negative_Grade;
    }

    public String getMax_Cadence() {
        return Max_Cadence;
    }

    public void setMax_Cadence(String max_Cadence) {
        Max_Cadence = max_Cadence;
    }

    public String getAverage_Cadence() {
        return Average_Cadence;
    }

    public void setAverage_Cadence(String average_Cadence) {
        Average_Cadence = average_Cadence;
    }

    public String getMax_Heart_Rate() {
        return Max_Heart_Rate;
    }

    public void setMax_Heart_Rate(String max_Heart_Rate) {
        Max_Heart_Rate = max_Heart_Rate;
    }

    public String getAverage_Heart_Rate() {
        return Average_Heart_Rate;
    }

    public void setAverage_Heart_Rate(String average_Heart_Rate) {
        Average_Heart_Rate = average_Heart_Rate;
    }

    public String getMax_Watts() {
        return Max_Watts;
    }

    public void setMax_Watts(String max_Watts) {
        Max_Watts = max_Watts;
    }

    public String getAverage_Watts() {
        return Average_Watts;
    }

    public void setAverage_Watts(String average_Watts) {
        Average_Watts = average_Watts;
    }

    public String getCalories() {
        return Calories;
    }

    public void setCalories(String calories) {
        Calories = calories;
    }

    public String getMax_Temperature() {
        return Max_Temperature;
    }

    public void setMax_Temperature(String max_Temperature) {
        Max_Temperature = max_Temperature;
    }

    public String getAverage_Temperature() {
        return Average_Temperature;
    }

    public void setAverage_Temperature(String average_Temperature) {
        Average_Temperature = average_Temperature;
    }

    public String getRelative_Effort_2() {
        return Relative_Effort_2;
    }

    public void setRelative_Effort_2(String relative_Effort_2) {
        Relative_Effort_2 = relative_Effort_2;
    }

    public String getTotal_Work() {
        return Total_Work;
    }

    public void setTotal_Work(String total_Work) {
        Total_Work = total_Work;
    }

    public String getNumber_of_Runs() {
        return Number_of_Runs;
    }

    public void setNumber_of_Runs(String number_of_Runs) {
        Number_of_Runs = number_of_Runs;
    }

    public String getUphill_Time() {
        return Uphill_Time;
    }

    public void setUphill_Time(String uphill_Time) {
        Uphill_Time = uphill_Time;
    }

    public String getDownhill_Time() {
        return Downhill_Time;
    }

    public void setDownhill_Time(String downhill_Time) {
        Downhill_Time = downhill_Time;
    }

    public String getOther_Time() {
        return Other_Time;
    }

    public void setOther_Time(String other_Time) {
        Other_Time = other_Time;
    }

    public String getPerceived_Exertion() {
        return Perceived_Exertion;
    }

    public void setPerceived_Exertion(String perceived_Exertion) {
        Perceived_Exertion = perceived_Exertion;
    }

    public String getActivity_Horton_Type() {
        return Activity_Horton_Type;
    }

    public void setActivity_Horton_Type(String activity_Horton_Type) {
        Activity_Horton_Type = activity_Horton_Type;
    }

    public String getActivity_Horton_Start_Time() {
        return Activity_Horton_Start_Time;
    }

    public void setActivity_Horton_Start_Time(String activity_Horton_Start_Time) {
        Activity_Horton_Start_Time = activity_Horton_Start_Time;
    }

    public String getWeighted_Average_Power() {
        return Weighted_Average_Power;
    }

    public void setWeighted_Average_Power(String weighted_Average_Power) {
        Weighted_Average_Power = weighted_Average_Power;
    }

    public String getPower_Count() {
        return Power_Count;
    }

    public void setPower_Count(String power_Count) {
        Power_Count = power_Count;
    }

    public String getPrefer_Perceived_Exertion() {
        return Prefer_Perceived_Exertion;
    }

    public void setPrefer_Perceived_Exertion(String prefer_Perceived_Exertion) {
        Prefer_Perceived_Exertion = prefer_Perceived_Exertion;
    }

    public String getPerceived_Relative_Effort() {
        return Perceived_Relative_Effort;
    }

    public void setPerceived_Relative_Effort(String perceived_Relative_Effort) {
        Perceived_Relative_Effort = perceived_Relative_Effort;
    }

    public String getCommute_2() {
        return Commute_2;
    }

    public void setCommute_2(String commute_2) {
        Commute_2 = commute_2;
    }

    public String getTotal_Weight_Lifted() {
        return Total_Weight_Lifted;
    }

    public void setTotal_Weight_Lifted(String total_Weight_Lifted) {
        Total_Weight_Lifted = total_Weight_Lifted;
    }

    public String getFrom_Upload() {
        return From_Upload;
    }

    public void setFrom_Upload(String from_Upload) {
        From_Upload = from_Upload;
    }

    public String getGrade_Adjusted_Distance() {
        return Grade_Adjusted_Distance;
    }

    public void setGrade_Adjusted_Distance(String grade_Adjusted_Distance) {
        Grade_Adjusted_Distance = grade_Adjusted_Distance;
    }

    public String getWeather_Observation_Time() {
        return Weather_Observation_Time;
    }

    public void setWeather_Observation_Time(String weather_Observation_Time) {
        Weather_Observation_Time = weather_Observation_Time;
    }

    public String getWeather_Condition() {
        return Weather_Condition;
    }

    public void setWeather_Condition(String weather_Condition) {
        Weather_Condition = weather_Condition;
    }

    public String getWeather_Temperature() {
        return Weather_Temperature;
    }

    public void setWeather_Temperature(String weather_Temperature) {
        Weather_Temperature = weather_Temperature;
    }

    public String getApparent_Temperature() {
        return Apparent_Temperature;
    }

    public void setApparent_Temperature(String apparent_Temperature) {
        Apparent_Temperature = apparent_Temperature;
    }

    public String getDewpoint() {
        return Dewpoint;
    }

    public void setDewpoint(String dewpoint) {
        Dewpoint = dewpoint;
    }

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String humidity) {
        Humidity = humidity;
    }

    public String getWeather_Pressure() {
        return Weather_Pressure;
    }

    public void setWeather_Pressure(String weather_Pressure) {
        Weather_Pressure = weather_Pressure;
    }

    public String getWind_Speed() {
        return Wind_Speed;
    }

    public void setWind_Speed(String wind_Speed) {
        Wind_Speed = wind_Speed;
    }

    public String getWind_Gust() {
        return Wind_Gust;
    }

    public void setWind_Gust(String wind_Gust) {
        Wind_Gust = wind_Gust;
    }

    public String getWind_Bearing() {
        return Wind_Bearing;
    }

    public void setWind_Bearing(String wind_Bearing) {
        Wind_Bearing = wind_Bearing;
    }

    public String getPrecipitation_Intensity() {
        return Precipitation_Intensity;
    }

    public void setPrecipitation_Intensity(String precipitation_Intensity) {
        Precipitation_Intensity = precipitation_Intensity;
    }

    public String getSunrise_Time() {
        return Sunrise_Time;
    }

    public void setSunrise_Time(String sunrise_Time) {
        Sunrise_Time = sunrise_Time;
    }

    public String getSunset_Time() {
        return Sunset_Time;
    }

    public void setSunset_Time(String sunset_Time) {
        Sunset_Time = sunset_Time;
    }

    public String getMoon_Phase() {
        return Moon_Phase;
    }

    public void setMoon_Phase(String moon_Phase) {
        Moon_Phase = moon_Phase;
    }

    public String getBike() {
        return Bike;
    }

    public void setBike(String bike) {
        Bike = bike;
    }

    public String getGear() {
        return Gear;
    }

    public void setGear(String gear) {
        Gear = gear;
    }

    public String getPrecipitation_Probability() {
        return Precipitation_Probability;
    }

    public void setPrecipitation_Probability(String precipitation_Probability) {
        Precipitation_Probability = precipitation_Probability;
    }

    public String getPrecipitation_Type() {
        return Precipitation_Type;
    }

    public void setPrecipitation_Type(String precipitation_Type) {
        Precipitation_Type = precipitation_Type;
    }

    public String getCloud_Cover() {
        return Cloud_Cover;
    }

    public void setCloud_Cover(String cloud_Cover) {
        Cloud_Cover = cloud_Cover;
    }

    public String getWeather_Visibility() {
        return Weather_Visibility;
    }

    public void setWeather_Visibility(String weather_Visibility) {
        Weather_Visibility = weather_Visibility;
    }

    public String getUV_Index() {
        return UV_Index;
    }

    public void setUV_Index(String UV_Index) {
        this.UV_Index = UV_Index;
    }

    public String getWeather_Ozone() {
        return Weather_Ozone;
    }

    public void setWeather_Ozone(String weather_Ozone) {
        Weather_Ozone = weather_Ozone;
    }

    public String getJump_count() {
        return jump_count;
    }

    public void setJump_count(String jump_count) {
        this.jump_count = jump_count;
    }

    public String getTotal_grit() {
        return total_grit;
    }

    public void setTotal_grit(String total_grit) {
        this.total_grit = total_grit;
    }

    public String getAvg_flow() {
        return avg_flow;
    }

    public void setAvg_flow(String avg_flow) {
        this.avg_flow = avg_flow;
    }

    public String getFlagged() {
        return flagged;
    }

    public void setFlagged(String flagged) {
        this.flagged = flagged;
    }

    private String flagged;

    public static List<StravaActivity> fromFile(Path path) throws IOException {
        List<StravaActivity> activities = new ArrayList<>();

        Reader in = new FileReader(path.toFile());
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
        for (CSVRecord record : records) {
            StravaActivity activity = new StravaActivity();
            activity.setActivity_ID(record.get("Activity ID"));
            activity.setActivity_Date(getDate(record.get("Activity Date")));
            activity.setActivity_Name(record.get("Activity Name"));
            activity.setActivity_Type(record.get("Activity Type"));
            activity.setActivity_Description(record.get("Activity Description"));
            activity.setElapsed_Time(Double.parseDouble(record.get("Elapsed Time")));
            activity.setDistance(Double.parseDouble(record.get(6)));
            activity.setRelative_Effort(record.get("Relative Effort"));
            activity.setCommute(Boolean.parseBoolean(record.get("Commute")));
            activity.setActivity_Gear(record.get("Activity Gear"));
            activity.setFilename(record.get("Filename"));
            activity.setAthlete_Weight(record.get("Athlete Weight"));
            activity.setBike_Weight(record.get("Bike Weight"));
            activity.setElapsed_Time_2(record.get(13));
            activity.setMoving_Time(record.get("Moving Time"));
            activity.setDistance_2(record.get(15));
            activity.setMax_Speed(record.get("Max Speed"));
            activity.setAverage_Speed(record.get("Average Speed"));
            activity.setElevation_Gain(record.get("Elevation Gain"));
            activity.setElevation_Loss(record.get("Elevation Loss"));
            activity.setElevation_Low(record.get("Elevation Low"));
            activity.setElevation_High(record.get("Elevation High"));
            activity.setMax_Grade(record.get("Max Grade"));
            activity.setAverage_Grade(record.get("Average Grade"));
            activity.setAverage_Positive_Grade(record.get("Average Positive Grade"));
            activity.setAverage_Negative_Grade(record.get("Average Negative Grade"));
            activity.setMax_Cadence(record.get("Max Cadence"));
            activity.setAverage_Cadence(record.get("Average Cadence"));
            activity.setMax_Heart_Rate(record.get("Max Heart Rate"));
            activity.setAverage_Heart_Rate(record.get("Average Heart Rate"));
            activity.setMax_Watts(record.get("Max Watts"));
            activity.setAverage_Watts(record.get("Average Watts"));
            activity.setCalories(record.get("Calories"));
            activity.setMax_Temperature(record.get("Max Temperature"));
            activity.setAverage_Temperature(record.get("Average Temperature"));
            activity.setRelative_Effort(record.get("Relative Effort"));
            activity.setTotal_Work(record.get("Total Work"));
            activity.setNumber_of_Runs(record.get("Number of Runs"));
            activity.setUphill_Time(record.get("Uphill Time"));
            activity.setDownhill_Time(record.get("Downhill Time"));
            activity.setOther_Time(record.get("Other Time"));
            activity.setPerceived_Exertion(record.get("Perceived Exertion"));
            activity.setActivity_Horton_Type(record.get("translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.type"));
            activity.setActivity_Horton_Start_Time(record.get("translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.start_time"));
            activity.setWeighted_Average_Power(record.get("Weighted Average Power"));
            activity.setPower_Count(record.get("Power Count"));
            activity.setPrefer_Perceived_Exertion(record.get("Prefer Perceived Exertion"));
            activity.setPerceived_Relative_Effort(record.get("Perceived Relative Effort"));
            activity.setCommute(Boolean.parseBoolean(record.get(48)));
            activity.setTotal_Weight_Lifted(record.get("Total Weight Lifted"));
            activity.setFrom_Upload(record.get("From Upload"));
            activity.setGrade_Adjusted_Distance(record.get("Grade Adjusted Distance"));
            activity.setWeather_Observation_Time(record.get("Weather Observation Time"));
            activity.setWeather_Condition(record.get("Weather Condition"));
            activity.setWeather_Temperature(record.get("Weather Temperature"));
            activity.setApparent_Temperature(record.get("Apparent Temperature"));
            activity.setDewpoint(record.get("Dewpoint"));
            activity.setHumidity(record.get("Humidity"));
            activity.setWeather_Pressure(record.get("Weather Pressure"));
            activity.setWind_Speed(record.get("Wind Speed"));
            activity.setWind_Gust(record.get("Wind Gust"));
            activity.setWind_Bearing(record.get("Wind Bearing"));
            activity.setPrecipitation_Intensity(record.get("Precipitation Intensity"));
            activity.setSunrise_Time(record.get("Sunrise Time"));
            activity.setSunset_Time(record.get("Sunset Time"));
            activity.setMoon_Phase(record.get("Moon Phase"));
            activity.setBike(record.get("Bike"));
            activity.setGear(record.get("Gear"));
            activity.setPrecipitation_Probability(record.get("Precipitation Probability"));
            activity.setPrecipitation_Type(record.get("Precipitation Type"));
            activity.setCloud_Cover(record.get("Cloud Cover"));
            activity.setWeather_Visibility(record.get("Weather Visibility"));
            activity.setUV_Index(record.get("UV Index"));
            activity.setWeather_Ozone(record.get("Weather Ozone"));
            activity.setJump_count(record.get("translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.jump_count"));
            activity.setTotal_grit(record.get("translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.total_grit"));
            activity.setAvg_flow(record.get("translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.avg_flow"));
            activity.setFlagged(record.get("translation missing: en-GB.lib.export.portability_exporter.activities.horton_values.flagged"));

            activities.add(activity);
        }

        return activities;
    }

    static LocalDateTime getDate(String dateString) {
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm:ss"));
    }
}
