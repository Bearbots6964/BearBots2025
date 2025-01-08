package frc.robot

import com.ctre.phoenix6.swerve.SwerveModule
import com.ctre.phoenix6.swerve.SwerveRequest
import edu.wpi.first.math.util.Units
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.constants.TunerConstants
import frc.robot.constants.TunerConstants.createDrivetrain
import frc.robot.subsystems.drive.CommandSwerveDrivetrain

class RobotContainer {
    private val MaxSpeed = TunerConstants.kSpeedAt12VoltMps.`in`(Units.MetersPerSecond)
    private val MaxAngularRate = Units.RotationsPerSecond.of(0.75).`in`(Units.RadiansPerSecond)

    private val joystick = CommandXboxController(0);

    private val drivetrain: CommandSwerveDrivetrain = createDrivetrain()
    private val drive: SwerveRequest.FieldCentric = SwerveRequest.FieldCentric()
    .withDeadband(MaxSpeed * 0.1)
    .withRotationlDeadband(MaxAngularRate * 0.1)
    .withDriveRequestType(SwerveModule.DriveRequestType.OpenLoopVoltage)

    init {
        configureBindings()
    }

    private fun configureBindings() {

    }

    fun getChasisMaxSpeed(): Double {
        return MaxSpeed
    }

    fun getChasisMaxAngularRate(): Double {
        return MaxAngularRate
    }
}