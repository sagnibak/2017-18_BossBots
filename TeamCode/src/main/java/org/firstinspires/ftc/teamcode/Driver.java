package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by sagnick on 8/18/2017.
 * Edited by Steve 17-Sep-17
 */

/**
 *   Motor position (as seen from above)
 *
 *       FRONT
 * motor4     motor3
 *    [\]-------[/]
 *       |     |
 *       |     |
 *       |     |
 *    [/]-------[\]
 *  motor1    motor2
 *
 * Direction     X  Y  Actuation
 *  Forward      0  -   All forward same speed
 *  Reverse      0  +   All backward same speed
 *  Right Shift  +  0   Wheels 4 and 1 forward, 3 and 2 backward
 *  Left Shift   -  0   Wheels 3 and 2 forward, 4 and 1 backward
 *  CW Turn             Wheels 3 and 1 forward, 4 and 2 backward
 *  CCW Turn            Wheels 4 and 2 forward, 3 and 1 backward
 */

public abstract class Driver extends OpMode implements Navigation{
    public double powerMotor1 = 0.0, powerMotor2 = 0.0,
                  powerMotor3 = 0.0, powerMotor4 = 0.0;
    final private float powerScale = 1.2f;  // increase this up to a little more than sqrt(2) to allow intuitive turning

    public void setMotorPower(float joystickX, float joystickY, float turnStick){
        joystickX = joystickX/powerScale;
        joystickY = -joystickY/powerScale;  // because pushing the joystick forward makes the reading more negative

        turnStick = Range.clip(turnStick, -1, 1);

        if (turnStick == 0) {
            powerMotor1 = (joystickY + joystickX);
            powerMotor2 = (joystickY - joystickX);
            powerMotor3 = (joystickY + joystickX);
            powerMotor4 = (joystickY - joystickX);
        }

        if (turnStick != 0) {
            powerMotor1 = -turnStick;
            powerMotor2 = -turnStick;
            powerMotor3 = -turnStick;
            powerMotor4 = -turnStick;
        }

        powerMotor1 = Range.clip(powerMotor1, -1, 1);
        powerMotor2 = Range.clip(powerMotor2, -1, 1);
        powerMotor3 = Range.clip(powerMotor3, -1, 1);
        powerMotor4 = Range.clip(powerMotor4, -1, 1);
    }
}
