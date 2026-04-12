package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hood {
    private int maxAngle = 30;
    public Servo ramp_angle_servo;
    public void init(HardwareMap hardwareMap, int maxAngle) {
        ramp_angle_servo = hardwareMap.get(Servo.class, "ramp_angle_servo");
        this.maxAngle = Math.abs(maxAngle);
    }

    public void setRamp_angle(double rotationpersent) {
        if(rotationpersent > 1) {
            ramp_angle_servo.setPosition(maxAngle);
        } else if(rotationpersent < 0) {
            ramp_angle_servo.setPosition(0);
        } else {
            ramp_angle_servo.setPosition(maxAngle*rotationpersent);
        }
    }

}
