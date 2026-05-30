// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states;

import java.lang.Thread.State;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.constants.ConstMotion;
import frc.robot.constants.ConstRotors;
import frc.robot.subsystems.StateMachine;

public class Shooting extends Command {
  /** Creates a new Shooting. */
  public Shooting() {

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.stateMachineInstance);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.stateMachineInstance.setRobotState((StateMachine.RobotState.SHOOTING));
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    RobotContainer.rotorsInstance.setTransferRollersSpeeds(ConstRotors.TRANSFER_ROLLERS_SPEED);
    RobotContainer.rotorsInstance.setSerializerRollersPercentOutput(ConstRotors.SERIALIZER_SHOOTING_SPEED);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.rotorsInstance.setFlywheelPercentOutput(0.0);
    RobotContainer.rotorsInstance.setTransferRollersPercentOutput(0.0);
    RobotContainer.rotorsInstance.setSerializerRollersPercentOutput(0.);
    RobotContainer.motionInstance.setHoodPivotAngle(ConstMotion.HOOD_PIVOT_ANGLE_RETRACT);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}