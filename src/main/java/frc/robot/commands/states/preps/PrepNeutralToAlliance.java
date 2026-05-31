// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states.preps;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.ConstMotion;
import frc.robot.constants.ConstRotors;
import frc.robot.subsystems.StateMachine.RobotState;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class PrepNeutralToAlliance extends BasePrep {
  /** Creates a new PrepNeautralToAlliance. */
  public PrepNeutralToAlliance() {

    super(ConstRotors.FLYWHEEL_NEUTRAL_TO_ALLIANCE_SPEED, ConstMotion.HOOD_NEUTRAL_TO_ALLIANCE_ANGLE,
        RobotState.PREP_NEUTRAL_TO_ALLIANCE);

    // Use addRequirements() here to declare subsystem dependencies.
  }

}