package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by sagnick on 8/18/2017.
 */

/**
    *   Motor position
    *
    * motor4     motor3
    *    []-------[]
    *      |     |
    *      |     |
    *      |     |
    *    []-------[]
    *  motor1    motor2
*/

public abstract class Driver extends OpMode implements Navigation{
    public double powerMotor1 = 0.0, powerMotor2 = 0.0,
                  powerMotor3 = 0.0, powerMotor4 = 0.0;

    public void setMotorPower(float joystickX, float joystickY, float turnStick){
        joystickX = joystickX/2;
        joystickY = -joystickY/2;

        joystickX = Range.clip(joystickX, -1, 1);
        joystickY = Range.clip(joystickY, -1, 1);
        turnStick = Range.clip(turnStick, -1, 1);

        if (turnStick == 0) {
            // change the motor numbers after testing
            powerMotor1 = (joystickY - joystickX);
            powerMotor2 = (-joystickY - joystickX);
            powerMotor3 = (-joystickY + joystickX);
            powerMotor4 = (joystickY + joystickX);
        }

        if (turnStick != 0) {
            powerMotor1 = turnStick;
            powerMotor2 = turnStick;
            powerMotor3 = turnStick;
            powerMotor4 = turnStick;
        }
    }
}
