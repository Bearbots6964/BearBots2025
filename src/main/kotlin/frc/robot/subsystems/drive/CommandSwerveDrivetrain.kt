package frc.robot.subsystems.drive

import com.ctre.phoenix6.Utils
import com.ctre.phoenix6.swerve.SwerveDrivetrain
import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants
import com.ctre.phoenix6.swerve.SwerveModule
import com.ctre.phoenix6.swerve.SwerveModuleConstants
import com.ctre.phoenix6.swerve.SwerveRequest
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Subsystem
import java.util.function.Supplier
import com.pathplanner.lib.auto.AutoBuilder
import com.pathplanner.lib.config.RobotConfig
import edu.wpi.first.math.Matrix
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.math.kinematics.SwerveDriveKinematics
import edu.wpi.first.math.kinematics.SwerveModuleState
import edu.wpi.first.math.numbers.N1
import edu.wpi.first.math.numbers.N3
import edu.wpi.first.units.Units
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.Notifier
import edu.wpi.first.wpilibj.RobotController
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine

class CommandSwerveDrivetrain(
    private val drivetrainConstants: SwerveDrivetrainConstants,
    vararg moduleConstants: SwerveModuleConstants
) : SwerveDrivetrain(
    drivetrainConstants,
    *moduleConstants
), Subsystem{
    //For controlling SwerveModules manually
    /*
    private var moduleStates: Array<SwerveModuleState>? = null
    private val swerveModules: Array<SwerveModule> = arrayOf( //TODO Add drivetrainIds and indexes
        SwerveModule(moduleConstants.get(0), "FrontLeft", 0, 0),
        SwerveModule(moduleConstants.get(1), "FrontRight", 1, 1),
        SwerveModule(moduleConstants.get(2), "BackLeft", 2, 2),
        SwerveModule(moduleConstants.get(3), "BackRight",3, 3)
    )

    fun runRawChassisSpeeds(speeds: ChassisSpeeds) {
        moduleStates = SwerveDriveKinematics().toSwerveModuleStates(speeds)


    }*/

    //Parker's way
    fun applyRequest(requestSupplier: Supplier<SwerveRequest>): Command{
        return run { setControl(requestSupplier.get()) }
    }
}