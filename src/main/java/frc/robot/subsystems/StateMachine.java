// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.states.EjectingHopper;
import frc.robot.commands.states.Intaking;
import frc.robot.commands.states.None;
import frc.robot.commands.states.PrepAnywhere;
import frc.robot.commands.states.PrepCorner;
import frc.robot.commands.states.PrepHub;
import frc.robot.commands.states.PrepNeautralToAlliance;
import frc.robot.commands.states.PrepOpponentToAlliance;
import frc.robot.commands.states.PrepTower;
import frc.robot.commands.states.PrepTrench;
import frc.robot.commands.states.ReversingShooter;
import frc.robot.commands.states.Shooting;

@Logged
public class StateMachine extends SubsystemBase {
  public static RobotState currentRobotState;

  /** Creates a new StateMachine. */
  public StateMachine() {
    currentRobotState = RobotState.NONE;

  }

  public void setRobotState(RobotState robotState) {
    currentRobotState = robotState;

  }

  public RobotState getRobotState() {
    return currentRobotState;
  }

  public Command tryState(RobotState desiredState) {
    switch (desiredState) {
      case NONE:
        switch (currentRobotState) {
          case NONE:
          case INTAKING:
          case REVERSING_SHOOTER:
          case SHOOTING:
          case EJECTING_HOPPER:
            return new None();
        }
        break;
      case INTAKING:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
            return new Intaking();
        }
        break;
      case SHOOTING:
        switch (currentRobotState) {
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
            return new Shooting();
        }
        break;
      case REVERSING_SHOOTER:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
            return new ReversingShooter();
        }
        break;
      case PREP_ANYWHERE:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
          case REVERSING_SHOOTER:
            return new PrepAnywhere();
        }
        break;
      case PREP_HUB:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
          case REVERSING_SHOOTER:
            return new PrepHub();
        }
        break;
      case PREP_CORNER:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
          case REVERSING_SHOOTER:
            return new PrepCorner();
        }
        break;
      case PREP_NEUTRAL_TO_ALLIANCE:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
          case REVERSING_SHOOTER:
            return new PrepNeautralToAlliance();
        }
        break;
      case PREP_OPPONENT_TO_ALLIANCE:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
          case REVERSING_SHOOTER:
            return new PrepOpponentToAlliance();
        }
        break;
      case PREP_TOWER:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
          case REVERSING_SHOOTER:
            return new PrepTower();
        }
        break;
      case PREP_TRENCH:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
          case REVERSING_SHOOTER:
            return new PrepTrench();
        }
        break;
      case EJECTING_HOPPER:
        switch (currentRobotState) {
          case NONE:
          case RETRACT_INTAKE:
          case PREP_ANYWHERE:
          case PREP_CORNER:
          case PREP_HUB:
          case PREP_NEUTRAL_TO_ALLIANCE:
          case PREP_OPPONENT_TO_ALLIANCE:
          case PREP_TOWER:
          case PREP_TRENCH:
            return new EjectingHopper();
        }

    }
    return Commands
        .print("ITS SO OVER D: Invalid State Provided, Blame Eli. Attempted to go to: " + desiredState.toString()
            + " while at " + currentRobotState.toString());
  }

  public enum RobotState {
    NONE,
    INTAKING,
    PREP_CORNER,
    PREP_HUB,
    PREP_TRENCH,
    PREP_ANYWHERE,
    PREP_TOWER,
    PREP_NEUTRAL_TO_ALLIANCE,
    PREP_OPPONENT_TO_ALLIANCE,
    SHOOTING,
    EJECTING_HOPPER,
    REVERSING_SHOOTER,
    RETRACT_INTAKE,
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
