package frc.robot

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import com.ctre.phoenix6.swerve.SwerveRequest

class RobotContainer {

   private val joystick = CommandXboxController(0);
    
    private val drive : SwerveRequest.FieldCentric = SwerveRequest.FieldCentric()
    private val point = SwerveRequest.PointWheelsAt()

    init {
        configureBindings()
    }

    private fun configureBindings() {}

    val autonomousCommand: Command
        get() = Commands.print("No autonomous command configured")
}
