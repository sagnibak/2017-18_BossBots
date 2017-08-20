package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

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

    public void setMotorPower(double joystickX, double joystickY){
        joystickY = -joystickY;

        // change the motor numbers after testing
        powerMotor1 = (joystickY - joystickX);
        powerMotor2 = (-joystickY - joystickX);
        powerMotor3 = (-joystickY + joystickX);
        powerMotor4 = (joystickY + joystickX);
    }
}
