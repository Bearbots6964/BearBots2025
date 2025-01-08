package frc.robot.subsystems.drive

import com.ctre.phoenix6.Utils
import com.ctre.phoenix6.swerve.SwerveDrivetrain
import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants
import com.ctre.phoenix6.swerve.SwerveModuleConstants
import com.ctre.phoenix6.swerve.SwerveRequest
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Subsystem
import java.util.function.Supplier
import com.pathplanner.lib.auto.AutoBuilder
import com.pathplanner.lib.config.RobotConfig
import edu.wpi.first.math.Matrix
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.math.numbers.N1
import edu.wpi.first.math.numbers.N3
import edu.wpi.first.units.Units
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.Notifier
import edu.wpi.first.wpilibj.RobotController
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine

class CommandSwerveDrivetrain(
    private val drivetrainConstants: SwerveDrivetrainConstants,
    private val moduleConstants: SwerveModuleConstants
) : SwerveDrivetrain(drivetrainConstants, moduleConstants), Subsystem{

    fun applyRequest(requestSupplier: Supplier<SwerveRequest>): Command{
        return run { setControl(requestSupplier.get()) }
    }
}