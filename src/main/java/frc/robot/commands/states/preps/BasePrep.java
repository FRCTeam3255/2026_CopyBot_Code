// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states.preps;

import edu.wpi.first.units.measure.*;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.StateMachine.RobotState;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class BasePrep extends Command {
  AngularVelocity globalFlyWheelSpeed;
  Angle globalHoodAngle;
  RobotState globalState;

  /** Creates a new BasePrep. */
  public BasePrep(AngularVelocity flyWheelSpeed, Angle hoodAngle, RobotState state) {
    addRequirements(RobotContainer.stateMachineInstance);
    globalFlyWheelSpeed = flyWheelSpeed;
    globalHoodAngle = hoodAngle;
    globalState = state;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.rotorsInstance.setFlyWheelSpeeds(globalFlyWheelSpeed);
    RobotContainer.motionInstance.setHoodPivotAngle(globalHoodAngle);
    RobotContainer.stateMachineInstance.setRobotState(globalState);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
