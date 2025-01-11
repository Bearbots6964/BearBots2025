package frc.robot

import com.ctre.phoenix6.swerve.SwerveModule
import com.ctre.phoenix6.swerve.SwerveRequest
import edu.wpi.first.units.Units
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.commands.drive.JoystickDrive
import frc.robot.generated.TunerConstants
import frc.robot.generated.TunerConstants.createDrivetrain
import frc.robot.subsystems.drive.CommandSwerveDrivetrain
import frc.robot.utils.DriveInput

object RobotContainer {
    private val maxSpeed: Double
    private val maxAngularRate: Double

    private val joystick = CommandXboxController(0);

    private val drivetrain: CommandSwerveDrivetrain = createDrivetrain()
    private val drive: SwerveRequest.FieldCentric

    init {
        maxSpeed = TunerConstants.kSpeedAt12VoltsMps.`in`(Units.MetersPerSecond)
        maxAngularRate = Units.RotationsPerSecond.of(0.75).`in`(Units.RadiansPerSecond)

        drive = SwerveRequest.FieldCentric()
            .withDeadband(maxSpeed * 0.1)
            .withRotationalDeadband(maxAngularRate * 0.1)
            .withDriveRequestType(SwerveModule.DriveRequestType.OpenLoopVoltage)

        configureBindings()
    }

    private fun configureBindings() {
        // Set default command to JoystickDrive
        drivetrain.defaultCommand = JoystickDrive(
            DriveInput(joystick),
            drivetrain,
            drive,
            maxSpeed,
            maxAngularRate
        )
    }

//    fun getAutonomousCommand(): Command {
//        return
//    }

    fun getChasisMaxSpeed(): Double {
        return maxSpeed
    }

    fun getChasisMaxAngularRate(): Double {
        return maxAngularRate
    }
}