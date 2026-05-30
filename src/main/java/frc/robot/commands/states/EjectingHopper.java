// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.constants.ConstMotion;
import frc.robot.constants.ConstRotors;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class EjectingHopper extends Command

{
  /** Creates a new EjectingHopper. */
  public EjectingHopper() {

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.motionInstance.setIntakePivotAngle(ConstMotion.INTAKE_PIVOT_DEPLOY);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.rotorsInstance.setIntakeRollersPercentOutput(ConstRotors.REVERSE_INTAKE_ROLLER_SPEED);
    RobotContainer.rotorsInstance.setSerializerRollersPercentOutput(ConstRotors.REVERSE_SERIALIZER_SPEED);
    RobotContainer.rotorsInstance.setTransferRollersPercentOutput(ConstRotors.REVERSE_TRANSFER_ROLLERS_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.rotorsInstance.setIntakeRollersPercentOutput(ConstRotors.STOP);
    RobotContainer.rotorsInstance.setSerializerRollersPercentOutput(ConstRotors.STOP);
    RobotContainer.rotorsInstance.setTransferRollersPercentOutput(ConstRotors.STOP);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
