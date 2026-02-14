package org.firstinspires.ftc.teamcode.ErrorPackage.ErrorMechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
public class ShootingLogic {
    public DcMotor flywheel;
    public DcMotor coreHex;
    public static int shortVelocity = 1370;
    public static int longVelocity = 1865;
    ElapsedTime inertiaBuildUp = new ElapsedTime();

    public void init(HardwareMap hardwareMap) {
        flywheel = hardwareMap.get(DcMotor.class, "flywheel");
        coreHex = hardwareMap.get(DcMotor.class, "coreHex");
        flywheel.setDirection(DcMotor.Direction.REVERSE);
        coreHex.setDirection(DcMotor.Direction.REVERSE);
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void Shoot(String ShootingState) {
        switch (ShootingState) {
            case "Short":
                ((DcMotorEx) flywheel).setVelocity(shortVelocity);
                if (((DcMotorEx) flywheel).getVelocity() < shortVelocity - 25) {
                    coreHex.setPower(-1);
                    inertiaBuildUp.reset();
                } else if (inertiaBuildUp.milliseconds() > 5) {
                    coreHex.setPower(1);
                }
                break;
            case "Long":
                ((DcMotorEx) flywheel).setVelocity(longVelocity);
                if (((DcMotorEx) flywheel).getVelocity() < longVelocity - 25) {
                    coreHex.setPower(-1);
                    inertiaBuildUp.reset();
                } else if (inertiaBuildUp.milliseconds() > 5) {
                    coreHex.setPower(1);
                }
                break;
            case "Idle":
                flywheel.setPower(0);
                coreHex.setPower(0);
                break;
            case "Manual Short":
                ((DcMotorEx) flywheel).setVelocity(shortVelocity);
                break;
            case "Manual Long":
                ((DcMotorEx) flywheel).setVelocity(longVelocity);
                break;
            case "Range Shooting Test":
                if (AprilTagWebcam.rangeCorrection != 0) {
                    ((DcMotorEx) flywheel).setVelocity(AprilTagWebcam.rangeCorrection);
                    if (((DcMotorEx) flywheel).getVelocity() < AprilTagWebcam.rangeCorrection -25) {
                        coreHex.setPower(-1);
                        inertiaBuildUp.reset();
                    } else if (inertiaBuildUp.milliseconds() > 2) {
                        coreHex.setPower(1);
                    }
                }
        }
    }
}
