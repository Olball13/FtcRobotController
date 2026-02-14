package org.firstinspires.ftc.teamcode.ErrorPackage.ErrorMechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.ftccommon.internal.manualcontrol.commands.ImuCommands;

public class DrivingLogic {
    private DcMotor left_front_drive;
    private DcMotor left_back_drive;
    private DcMotor right_front_drive;
    private DcMotor right_back_drive;

    public void init(HardwareMap hardwareMap) {
        left_front_drive = hardwareMap.get(DcMotor.class, "left_front_drive");
        left_back_drive = hardwareMap.get(DcMotor.class, "left_back_drive");
        right_front_drive = hardwareMap.get(DcMotor.class, "right_front_drive");
        right_back_drive = hardwareMap.get(DcMotor.class, "right_back_drive");

        left_front_drive.setDirection(DcMotor.Direction.FORWARD);
        left_back_drive.setDirection(DcMotor.Direction.FORWARD);
        right_front_drive.setDirection(DcMotor.Direction.FORWARD);
        right_back_drive.setDirection(DcMotor.Direction.REVERSE);

        left_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_back_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void Drive(double forward, double right, double rotate) {
        // This calculates the power needed for each wheel based on the amount of forward,
        // strafe right, and rotate
        double frontLeftPower = forward + right + rotate;
        double frontRightPower = forward - right - rotate;
        double backRightPower = forward + right - rotate;
        double backLeftPower = forward - right + rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        // This is needed to make sure we don't pass > 1.0 to any wheel
        // It allows us to keep all of the motors in proportion to what they should
        // be and not get clipped
        maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
        maxPower = Math.max(maxPower, Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(backRightPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));

        // We multiply by maxSpeed so that it can be set lower for outreaches
        // When a young child is driving the robot, we may not want to allow full
        // speed.
        left_front_drive.setPower(maxSpeed * (frontLeftPower / maxPower));
        right_front_drive.setPower(maxSpeed * (frontRightPower / maxPower));
        left_back_drive.setPower(maxSpeed * (backLeftPower / maxPower));
        right_back_drive.setPower(maxSpeed * (backRightPower / maxPower));
    }
    public void turn(double rotationPercent, double drivetrainRotation) {
        double targetPosition = rotationPercent * drivetrainRotation;
        int positiveOrNegative = (int) (Math.abs(rotationPercent)/rotationPercent);
        left_front_drive.setTargetPosition((int)targetPosition + left_front_drive.getCurrentPosition());
        right_front_drive.setTargetPosition((int)-targetPosition + right_front_drive.getCurrentPosition());
        left_back_drive.setTargetPosition((int)-targetPosition + left_back_drive.getCurrentPosition());
        right_back_drive.setTargetPosition((int)targetPosition + right_back_drive.getCurrentPosition());
        left_front_drive.setPower(1);
        right_front_drive.setPower(1);
        left_back_drive.setPower(1);
        right_back_drive.setPower(1);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
