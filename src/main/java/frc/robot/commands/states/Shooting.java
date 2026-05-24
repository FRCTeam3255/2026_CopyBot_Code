// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.constants.ConstMotion;
import frc.robot.constants.ConstRotors;

public class Shooting extends Command {
  /** Creates a new Shooting. */
  public Shooting() {

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.motionInstance.setHoodPivotAngle(ConstMotion.HOOD_PIVOT_ANGLE);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.rotorsInstance.setFlywheelSpeeds(ConstRotors.FLYWHEEL_SHOOTING_SPEED);
    RobotContainer.rotorsInstance.setTransferRollersSpeeds(ConstRotors.INTAKE_TRANSFER_SPEED);
    RobotContainer.rotorsInstance.setSerializerRollersSpeed(ConstRotors.SERIALIZER_SHOOTING_SPEED);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.rotorsInstance.setFlywheelSpeeds(ConstRotors.STOP_ALL);
    RobotContainer.rotorsInstance.setTransferRollersSpeeds(ConstRotors.STOP_ALL);
    RobotContainer.rotorsInstance.setSerializerRollersSpeed(ConstRotors.STOP_ALL);
    if (RobotContainer.rotorsInstance.isFlyWheelAtSpeed(null))
      ;
    {

    }

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
