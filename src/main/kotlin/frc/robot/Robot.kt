package frc.robot

import edu.wpi.first.hal.FRCNetComm
import edu.wpi.first.wpilibj.PowerDistribution
import edu.wpi.first.wpilibj.util.WPILibVersion
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.CommandScheduler
import org.littletonrobotics.junction.LoggedRobot
import org.ironmaple.simulation.SimulatedArena

object Robot : LoggedRobot() {
    private var autonomousCommand: Command? = null

    private val currentRobotMode: String = if(isReal()) "REAL" else "SIM"

    override fun robotInit() {
        PowerDistribution(1, PowerDistribution.ModuleType.kRev)

        when(currentRobotMode){
            "REAL" -> {

            }
            "SIM" -> {

            }
            "REPLAY" -> {

            }
        }
    }

    override fun robotPeriodic() {
        CommandScheduler.getInstance().run()
    }

    override fun disabledInit() {}

    override fun disabledPeriodic() {}

    override fun disabledExit() {}

    override fun autonomousInit() {
        //autonomousCommand = Autos.selectedAutonomousCommand
    }

    override fun autonomousPeriodic() {}

    override fun autonomousExit() {}

    override fun teleopInit() {
        autonomousCommand?.cancel()
    }

    override fun teleopPeriodic() {}

    override fun teleopExit() {}

    override fun simulationPeriodic() {
        // Implement maple-sim
        SimulatedArena.getInstance().simulationPeriodic()
    }

    override fun testInit() {}

    override fun testPeriodic() {}

    override fun testExit() {}
}
