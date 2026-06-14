// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceIDs.rotorIDs;
import frc.robot.Robot;
import frc.robot.constants.ConstRotors;

@Logged
public class Rotors extends SubsystemBase {

  final TalonFX serializerRollersLeader = new TalonFX(rotorIDs.SERIALIZER_ROLLERS_CAN);

  final TalonFX intakeRollersWestFollower = new TalonFX(rotorIDs.INTAKE_ROLLERS_WEST_CAN);
  final TalonFX intakeRollersEastLeader = new TalonFX(rotorIDs.INTAKE_ROLLERS_EAST_CAN);

  final TalonFX transferRollersWestLeader = new TalonFX((rotorIDs.TRANSFER_ROLLERS_WEST_CAN));
  final TalonFX transferRollersEastFollower = new TalonFX((rotorIDs.TRANSFER_ROLLERS_EAST_CAN));

  final TalonFX flywheelTopWest = new TalonFX((rotorIDs.FLYWHEEL_TOP_WEST_CAN));
  final TalonFX flywheelTopEastLeader = new TalonFX((rotorIDs.FLYWHEEL_TOP_EAST_CAN));
  final TalonFX flywheelBottomWest = new TalonFX((rotorIDs.FLYWHEEL_BOTTOM_WEST_CAN));
  final TalonFX flywheelBottomEast = new TalonFX((rotorIDs.FLYWHEEL_BOTTOM_EAST_CAN));

  AngularVelocity lastDesiredFlyWheelSpeed = Units.RPM.of(0);
  AngularVelocity lastDesiredTransferRollersSpeed = Units.RPM.of(0);

  Follower flywheelFollowerAlignedRequest = new Follower(flywheelTopEastLeader.getDeviceID(),
      MotorAlignmentValue.Aligned);
  Follower flywheelFollowerOpposedRequest = new Follower(flywheelTopEastLeader.getDeviceID(),
      MotorAlignmentValue.Opposed);

  Follower transferRollersFollowerOpposedRequest = new Follower(transferRollersWestLeader.getDeviceID(),
      MotorAlignmentValue.Opposed);

  Follower intakeRollerWestFollowerOpposedRequest = new Follower(intakeRollersEastLeader.getDeviceID(),
      MotorAlignmentValue.Opposed);

  final MotionMagicVelocityVoltage flyWheelVelocityRequest = new MotionMagicVelocityVoltage(0);
  final MotionMagicVelocityVoltage transferRollersVelocityRequest = new MotionMagicVelocityVoltage(0);
  final MotionMagicVelocityVoltage serializerVelocityRequest = new MotionMagicVelocityVoltage(0);
  private boolean flyWheelAtSpeed = false;

  final MotionMagicVelocityVoltage intakeRollersVelocityRequest = new MotionMagicVelocityVoltage(0);
  // private boolean intakeRollersAtSpeed = false;/

  public Rotors() {
    serializerRollersLeader.getConfigurator().apply(ConstRotors.SERIALIZER_ROLLERS_CONFIGURATION);
    intakeRollersEastLeader.getConfigurator().apply(ConstRotors.INTAKE_ROLLERS_EAST_CONFIGURATION);
    intakeRollersWestFollower.getConfigurator().apply(ConstRotors.INTAKE_ROLLERS_WEST_CONFIGURATION);
    transferRollersEastFollower.getConfigurator().apply(ConstRotors.TRANSFER_ROLLERS_EAST_CONFIGURATION);
    transferRollersWestLeader.getConfigurator().apply(ConstRotors.TRANSFER_ROLLERS_WEST_CONFIGURATION);
    flywheelTopEastLeader.getConfigurator().apply(ConstRotors.FLYWHEEL_EAST_CONFIGURATION);
    flywheelTopWest.getConfigurator().apply(ConstRotors.FLYWHEEL_WEST_CONFIGURATION);
    flywheelBottomEast.getConfigurator().apply(ConstRotors.FLYWHEEL_EAST_CONFIGURATION);
    flywheelBottomWest.getConfigurator().apply(ConstRotors.FLYWHEEL_WEST_CONFIGURATION);
  }

  // final MotionMagicVelocityVoltage TransferVelocityRequest = new
  // MotionMagicVelocityVoltage(0);/

  public AngularVelocity getFlyWheelSpeeds() {
    if (Robot.isSimulation()) {
      return lastDesiredFlyWheelSpeed;
    }
    return flywheelTopEastLeader.getVelocity().getValue();
  }

  public AngularVelocity getSerializerRollersVelocity() {
    return serializerRollersLeader.getVelocity().getValue();
  }

  public AngularVelocity getIntakeRollersVelocity() {
    return intakeRollersEastLeader.getVelocity().getValue();
  }

  public AngularVelocity getTransferRollersVelocity() {
    return transferRollersWestLeader.getVelocity().getValue();
  }

  public void setSerializerRollersPercentOutput(Double speed) {
    serializerRollersLeader.set(speed);
  }

  public void setIntakeRollersPercentOutput(Double speed) {
    intakeRollersEastLeader.set(speed);
    intakeRollersWestFollower.setControl(intakeRollerWestFollowerOpposedRequest);
  }

  public void setTransferRollersSpeeds(AngularVelocity speed) {
    // THIS WAS THE BUG, LEADER AND FOLLOWER WERE SWITCHED
    transferRollersWestLeader.setControl(transferRollersVelocityRequest.withVelocity(speed));
    transferRollersEastFollower.setControl(transferRollersFollowerOpposedRequest);
  }

  public void setTransferRollersPercentOutput(Double speed) {
    transferRollersWestLeader.set(speed);
    transferRollersEastFollower.setControl(transferRollersFollowerOpposedRequest);
  }

  public void setFlyWheelSpeeds(AngularVelocity speed) {
    flywheelTopEastLeader.setControl(flyWheelVelocityRequest.withVelocity(speed));
    flywheelTopWest.setControl(flywheelFollowerOpposedRequest);
    flywheelBottomWest.setControl(flywheelFollowerOpposedRequest);
    flywheelBottomEast.setControl(flywheelFollowerAlignedRequest);
    lastDesiredFlyWheelSpeed = speed;
  }

  public void setFlywheelPercentOutput(double speed) {
    flywheelTopEastLeader.set(speed);
    flywheelTopWest.setControl(flywheelFollowerOpposedRequest);
    flywheelBottomWest.setControl(flywheelFollowerOpposedRequest);
    flywheelBottomEast.setControl(flywheelFollowerAlignedRequest);
  }

  public boolean isFlyWheelAtSpeed(AngularVelocity tolerance) {
    AngularVelocity lowerLim = lastDesiredFlyWheelSpeed.minus(tolerance);
    AngularVelocity upperLim = lastDesiredFlyWheelSpeed.plus(tolerance);

    AngularVelocity flyWheelSpeed = getFlyWheelSpeeds();

    flyWheelAtSpeed = flyWheelSpeed.gte(lowerLim)
        && flyWheelSpeed.lte(upperLim);
    return flyWheelAtSpeed;

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
