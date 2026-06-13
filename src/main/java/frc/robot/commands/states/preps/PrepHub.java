// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states.preps;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.constants.ConstMotion;
import frc.robot.constants.ConstRotors;
import frc.robot.subsystems.StateMachine.RobotState;

public class PrepHub extends BasePrep {
  /** Creates a new PrepDepot. */
  public PrepHub() {

    super(ConstRotors.FLYWHEEL_PREP_HUB_SPEED, ConstMotion.HOOD_HUB_ANGLE, RobotState.PREP_HUB);

    // setState
    // Use addRequirements() here to declare subsystem dependencies.
  }
}