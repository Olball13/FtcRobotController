package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Teleops.ErrorMainTeleop;

public class Intake {
    private static DcMotor intake_motor;
    private static CRServo intake_servo;
    public static boolean intake_On = false;

    public void init(HardwareMap hardwareMap) {
        intake_motor = hardwareMap.get(DcMotor.class, "intake_servo");
        intake_motor.setDirection(DcMotor.Direction.REVERSE);
        intake_servo = hardwareMap.get(CRServo.class, "intake_servo");
        intake_servo.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void update() {
        if (intake_On) {
            intake_motor.setPower(1);
        } else {
            intake_motor.setPower(0);
        }
        if (ErrorMainTeleop.shoot && FlyWheel.getVelocity() > FlyWheel.desiredVelocity - 5) {
            intake_servo.setPower(1);
        } else {
            if (intake_On) {
                intake_servo.setPower(-1);
            } else {
                intake_servo.setPower(0);
            }
        }
    }

}
