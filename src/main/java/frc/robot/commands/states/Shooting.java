// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.constants.ConstMotion;
import frc.robot.constants.ConstRotors;
import frc.robot.subsystems.StateMachine;

public class Shooting extends Command {
  /** Creates a new Shooting. */

  private final Timer intakeAgitationTimer = new Timer();

  public Shooting() {

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.stateMachineInstance);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.stateMachineInstance.setRobotState((StateMachine.RobotState.SHOOTING));
    RobotContainer.rotorsInstance.setTransferRollersSpeeds(ConstRotors.TRANSFER_ROLLERS_SPEED);
    RobotContainer.rotorsInstance.setSerializerRollersPercentOutput(ConstRotors.SERIALIZER_SHOOTING_SPEED);
    RobotContainer.rotorsInstance.setIntakeRollersPercentOutput(ConstRotors.INTAKE_ROLLERS_SPEED);
    intakeAgitationTimer.restart();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!RobotContainer.motionInstance.getIntakePivotAngle().isNear(ConstMotion.AGITATE_PIVOT_ANGLE,
        ConstMotion.INTAKE_PIVOT_TOLERANCE)
        && intakeAgitationTimer.hasElapsed(ConstMotion.INTAKE_PIVOT_AGITATION_TIME)) {
      RobotContainer.motionInstance.setIntakePivotAngle(ConstMotion.AGITATE_PIVOT_ANGLE);
      intakeAgitationTimer.restart();

    } else if (intakeAgitationTimer.hasElapsed((ConstMotion.INTAKE_PIVOT_AGITATION_TIME))) {
      RobotContainer.motionInstance.setIntakePivotAngle(ConstMotion.DEPLOY_INTAKE_PIVOT_ANGLE);
      intakeAgitationTimer.restart();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.rotorsInstance.setFlywheelPercentOutput(ConstRotors.STOP);
    RobotContainer.rotorsInstance.setTransferRollersPercentOutput(ConstRotors.STOP);
    RobotContainer.rotorsInstance.setSerializerRollersPercentOutput(ConstRotors.STOP);
    RobotContainer.motionInstance.setHoodPivotAngle(ConstMotion.HOOD_PIVOT_ANGLE_RETRACT);
    RobotContainer.motionInstance.setIntakePivotAngle(ConstMotion.DEPLOY_INTAKE_PIVOT_ANGLE);
    intakeAgitationTimer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}