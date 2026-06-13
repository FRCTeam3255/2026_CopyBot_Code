// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states.preps;

import frc.robot.constants.ConstMotion;
import frc.robot.constants.ConstRotors;
import frc.robot.subsystems.StateMachine.RobotState;

public class PrepTower extends BasePrep {
  /** Creates a new PrepOutpost. */
  public PrepTower() {

    super(ConstRotors.FLYWHEEL_PREP_TOWER_SPEED, ConstMotion.HOOD_TOWER_ANGLE, RobotState.PREP_TOWER);

    // Use addRequirements() here to declare subsystem dependencies.
  }
}
