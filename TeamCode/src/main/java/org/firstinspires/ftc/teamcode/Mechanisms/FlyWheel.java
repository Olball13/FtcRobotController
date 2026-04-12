package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Teleops.ErrorMainTeleop;

public class FlyWheel {
    private static DcMotor flywheel_motor_1;
    private static DcMotor flywheel_motor_2;

    public void init(HardwareMap hardwareMap) {
        flywheel_motor_1 = hardwareMap.get(DcMotor.class, "flywheel_motor_1");
        flywheel_motor_2 = hardwareMap.get(DcMotor.class, "flywheel_motor_2");
        flywheel_motor_1.setDirection(DcMotor.Direction.REVERSE);
        flywheel_motor_2.setDirection(DcMotor.Direction.FORWARD);
        flywheel_motor_1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel_motor_2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void setVelocity(double velocity) {
        ((DcMotorEx) flywheel_motor_1).setVelocity(velocity);
        ((DcMotorEx) flywheel_motor_2).setVelocity(velocity);
        desiredVelocity = velocity;
    }
    public void update() {
        if (ErrorMainTeleop.shoot) {
            setVelocity(1500);
        } else {
            setVelocity(0);
        }
    }

    public static double getVelocity() {
        double totalVelocity = ((DcMotorEx) flywheel_motor_1).getVelocity() + ((DcMotorEx) flywheel_motor_2).getVelocity();
        return totalVelocity/2;
    }
    public static double desiredVelocity;

}
