package uk.dlpb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import uk.dlpb.serializers.LocalDateTimeDeserializer;
import uk.dlpb.serializers.LocalDateTimeSerializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GarminActivity {
    private String activityId;
    private String activityName;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTimeLocal;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTimeGMT;
    private double distance;
    private double duration;
    private double elapsedDuration;
    private double movingDuration;
    private double elevationGain;
    private double elevationLoss;
    private double averageSpeed;
    private double maxSpeed;
    private double startLattitude;
    private double startLongitude;
    private boolean hasPolyLine;
    private int ownerId;
    private String ownerDisplayName;

    public static List<GarminActivity> fromFile(Path file) throws IOException {
        byte[] json = Files.readAllBytes(file);
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //convert json string to object
        List<GarminActivity> activities = Arrays.asList(objectMapper.readValue(json, GarminActivity[].class));
        return activities;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public LocalDateTime getStartTimeLocal() {
        return startTimeLocal;
    }

    public void setStartTimeLocal(LocalDateTime startTimeLocal) {
        this.startTimeLocal = startTimeLocal;
    }

    public LocalDateTime getStartTimeGMT() {
        return startTimeGMT;
    }

    public void setStartTimeGMT(LocalDateTime startTimeGMT) {
        this.startTimeGMT = startTimeGMT;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getElapsedDuration() {
        return elapsedDuration;
    }

    public void setElapsedDuration(double elapsedDuration) {
        this.elapsedDuration = elapsedDuration;
    }

    public double getMovingDuration() {
        return movingDuration;
    }

    public void setMovingDuration(double movingDuration) {
        this.movingDuration = movingDuration;
    }

    public double getElevationGain() {
        return elevationGain;
    }

    public void setElevationGain(double elevationGain) {
        this.elevationGain = elevationGain;
    }

    public double getElevationLoss() {
        return elevationLoss;
    }

    public void setElevationLoss(double elevationLoss) {
        this.elevationLoss = elevationLoss;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getStartLattitude() {
        return startLattitude;
    }

    public void setStartLattitude(double startLattitude) {
        this.startLattitude = startLattitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public boolean isHasPolyLine() {
        return hasPolyLine;
    }

    public void setHasPolyLine(boolean hasPolyLine) {
        this.hasPolyLine = hasPolyLine;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    private String ownerFullName;

    public GarminActivity() {}

    public GarminActivity(String activityId, String activityName, LocalDateTime startTimeLocal, LocalDateTime startTimeGMT, double distance, double duration, double elapsedDuration, double movingDuration, double elevationGain, double elevationLoss, double averageSpeed, double maxSpeed, double startLattitude, double startLongitude, boolean hasPolyLine, int ownerId, String ownerDisplayName, String ownerFullName) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.startTimeLocal = startTimeLocal;
        this.startTimeGMT = startTimeGMT;
        this.distance = distance;
        this.duration = duration;
        this.elapsedDuration = elapsedDuration;
        this.movingDuration = movingDuration;
        this.elevationGain = elevationGain;
        this.elevationLoss = elevationLoss;
        this.averageSpeed = averageSpeed;
        this.maxSpeed = maxSpeed;
        this.startLattitude = startLattitude;
        this.startLongitude = startLongitude;
        this.hasPolyLine = hasPolyLine;
        this.ownerId = ownerId;
        this.ownerDisplayName = ownerDisplayName;
        this.ownerFullName = ownerFullName;
    }

    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }
}
