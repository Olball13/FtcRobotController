package org.firstinspires.ftc.teamcode.ErrorPackage.ErrorMechanisms;

import android.util.Size;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.ArrayList;
import java.util.List;

public class AprilTagWebcam {
    private static AprilTagProcessor aprilTagProcessor;
    private static VisionPortal visionPortal;
    private static List<AprilTagDetection> detectedTags = new ArrayList<>();
    private Telemetry telemetry;
    public static double degreeCorrection;
    public static double rangeCorrection;
    public static final double speedToAccuracyConstant = 30;

    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        aprilTagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawAxes(true)
                .setDrawCubeProjection(true)
                .setOutputUnits(DistanceUnit.CM, AngleUnit.DEGREES)
                .build();

        VisionPortal.Builder builder = new VisionPortal.Builder();
        builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        builder.setCameraResolution(new Size(640, 480));
        builder.addProcessor(aprilTagProcessor);
        visionPortal = builder.build();
    }

    public void update() {
        detectedTags = aprilTagProcessor.getDetections();
    }

    public List<AprilTagDetection> getDetectedTags() {
        return detectedTags;
    }

    public void displayDetectionTelemetry(AprilTagDetection detectedid) {
        if (detectedid == null) {
            degreeCorrection = 0;
            rangeCorrection = 0;
            return;}

        if (detectedid.metadata != null) {
            degreeCorrection = -detectedid.ftcPose.bearing;
            telemetry.addData("Degree Correction", degreeCorrection);
            rangeCorrection = detectedid.ftcPose.range;
            telemetry.addData("Range Correction", rangeCorrection);
            /*
            telemetry.addLine(String.format("\n==== (ID %d) %s", detectedid.id, detectedid.metadata.name));
            telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (cm)", detectedid.ftcPose.x, detectedid.ftcPose.y, detectedid.ftcPose.z));
            telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detectedid.ftcPose.pitch, detectedid.ftcPose.roll, detectedid.ftcPose.yaw));
            telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (cm, deg, deg)", detectedid.ftcPose.range, detectedid.ftcPose.bearing, detectedid.ftcPose.elevation));
            */
        } else {
            telemetry.addLine(String.format("\n==== (ID %d) Unknown", detectedid.id));
            telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detectedid.center.x, detectedid.center.y));
        }


    }

    public AprilTagDetection getTagBySpecificid(int id) {
        for (AprilTagDetection detection : detectedTags) {
            if (detection.id == id) {
                return detection;
            }
        }
        return null;
    }

    public void stop() {
        if (visionPortal != null) {
            visionPortal.close();
        }
    }
}