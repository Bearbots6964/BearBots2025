package frc.robot.commands.drive

import com.ctre.phoenix6.swerve.SwerveModule
import com.ctre.phoenix6.swerve.SwerveRequest
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.wpilibj2.command.Command
import frc.robot.subsystems.drive.CommandSwerveDrivetrain
import frc.robot.utils.DriveInput
import java.util.function.Supplier

class JoystickDrive(
    private val input: DriveInput?,
    private val drivetrain: CommandSwerveDrivetrain,
    private val drive: SwerveRequest.FieldCentric,
    private val maxSpeed: Double,
    private val maxRotationalSpeed: Double
) : Command() {


    override fun execute() {
        if(input == null) return

        //val chassisSpeed : ChassisSpeeds = input.getJoystickChassisSpeed(maxSpeed, maxRotationalSpeed)

        //Parker's way
        drivetrain.applyRequest {
            drive.withVelocityX(-input.getJoystickX() * maxSpeed)
                .withVelocityY(-input.getJoystickY() * maxSpeed)
                .withRotationalRate(-input.getJoystickX() * maxRotationalSpeed)
        }
    }
}