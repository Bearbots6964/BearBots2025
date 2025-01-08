package frc.robot.commands.drive

import com.ctre.phoenix6.swerve.SwerveModule
import com.ctre.phoenix6.swerve.SwerveRequest
import edu.wpi.first.math.util.Units
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Subsystem
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.constants.TunerConstants
import frc.robot.subsystems.drive.CommandSwerveDrivetrain
import java.util.function.DoubleSupplier

class JoystickDrive(joystick: CommandXboxController, // For swerve drive platform
                    private val drivetrain: CommandSwerveDrivetrain,
                    private val drive: SwerveRequest.FieldCentric
) : Command() {
    private val JoystickX: Double = joystick.getRightX()
    private val JoystickY: Double = joystick.getRightY()
    private val JoystickOmega: Double = joystick.getLeftX()

    override fun execute() {

        /*
        drivetrain.defaultCommand = drivetrain.applyRequest{
            drive.withVelocityX(-joystick.leftY * MaxSpeed.asDouble())
                .withVelocityY(-joystick.leftX * MaxSpeed.asDouble())
                .withRotationalRate(-joystick.rightX * MaxAngularRate.asDouble())
        }
         */
    }
}