// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states.preps;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.commands.SubCommands;
import frc.robot.constants.ConstRotors;
import frc.robot.subsystems.StateMachine.RobotState;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class PrepAnywhere extends Command {
  /** Creates a new PrepAnywhere. */
  public PrepAnywhere() {
    addRequirements(RobotContainer.stateMachineInstance);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.visionInstance.setVisionEnabled(true);
    RobotContainer.stateMachineInstance.setRobotState(RobotState.PREP_ANYWHERE);
    RobotContainer.drivetrainInstance.setManualDrive(false);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SubCommands.aim(true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivetrainInstance.setManualDrive(true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
