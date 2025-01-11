package frc.robot.utils

import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.wpilibj2.command.button.CommandXboxController

class DriveInput (joystick: CommandXboxController,
      private val joystickX: Double = joystick.getLeftX(),
      private val joystickY: Double = joystick.getLeftY(),
      private val joystickOmega: Double = joystick.getRightX()
){
    fun getJoystickChassisSpeed(maxSpeed: Double, maxRotationalSpeed: Double): ChassisSpeeds {
        val translationalSpeed: Translation2d = getJoystickTranslationalSpeed(maxSpeed)
        return ChassisSpeeds(
            translationalSpeed.x,
            translationalSpeed.y,
            maxRotationalSpeed
        )
    }

    fun getJoystickTranslationalSpeed(maxSpeed: Double): Translation2d{
        return Translation2d(
            -joystickX * maxSpeed,
            -joystickY * maxSpeed
        )
    }

    fun getJoystickRotationalSpeed(maxRotationalSpeed: Double): Double {
        return -joystickOmega * maxRotationalSpeed
    }

    //Parker's way
    fun getJoystickX(): Double {
        return joystickX
    }

    fun getJoystickY(): Double {
        return joystickY
    }

    fun getJoystickOmega(): Double {
        return joystickOmega
    }
}