// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states.preps;

import frc.robot.constants.ConstMotion;
import frc.robot.constants.ConstRotors;
import frc.robot.subsystems.StateMachine.RobotState;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class PrepOpponentToAlliance extends BasePrep {
  /** Creates a new PrepOpponentToAlliance. */
  public PrepOpponentToAlliance() {

    super(ConstRotors.FLYWHEEL_PREP_OPPONENT_TO_ALLIANCE_SPEED, ConstMotion.HOOD_OPPENENT_TO_ALLIANCE_ANGLE,
        RobotState.PREP_OPPONENT_TO_ALLIANCE);

    // Use addRequirements() here to declare subsystem dependencies.
  }

}
