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

  final TalonFX serializerRollers = new TalonFX(rotorIDs.SERIALIZER_ROLLERS_CAN);
  final TalonFX intakeRollersWest = new TalonFX(rotorIDs.INTAKE_ROLLERS_WEST_CAN);
  final TalonFX intakeRollersEast = new TalonFX(rotorIDs.INTAKE_ROLLERS_EAST_CAN);
  final TalonFX transferRollersWest = new TalonFX((rotorIDs.TRANSFER_ROLLERS_WEST_CAN));
  final TalonFX transferRollersEast = new TalonFX((rotorIDs.TRANSFER_ROLLERS_EAST_CAN));
  final TalonFX flywheelTopWest = new TalonFX((rotorIDs.FLYWHEEL_TOP_WEST_CAN));
  final TalonFX flywheelTopEast = new TalonFX((rotorIDs.FLYWHEEL_TOP_EAST_CAN));
  final TalonFX flywheelBottomWest = new TalonFX((rotorIDs.FLYWHEEL_BOTTOM_WEST_CAN));
  final TalonFX flywheelBottomEast = new TalonFX((rotorIDs.FLYWHEEL_BOTTOM_EAST_CAN));
  AngularVelocity lastDesiredFlyWheelSpeed = Units.RPM.of(0);
  AngularVelocity lastDesiredTransferRollersSpeed = Units.RPM.of(0);
  Follower flywheelEastFollower = new Follower(flywheelTopEast.getDeviceID(), MotorAlignmentValue.Aligned);
  Follower flywheelWestFollower = new Follower(flywheelTopEast.getDeviceID(), MotorAlignmentValue.Opposed);
  Follower transferRollersEastFollower = new Follower(intakeRollersEast.getDeviceID(), MotorAlignmentValue.Opposed);
  Follower intakeRollerEastFollower = new Follower(intakeRollersEast.getDeviceID(), MotorAlignmentValue.Opposed);
  final MotionMagicVelocityVoltage flyWheelVelocityRequest = new MotionMagicVelocityVoltage(0);
  final MotionMagicVelocityVoltage transferRollersVelocityRequest = new MotionMagicVelocityVoltage(0);
  final MotionMagicVelocityVoltage serializerVelocityRequest = new MotionMagicVelocityVoltage(0);
  private boolean flyWheelAtSpeed = false;

  final MotionMagicVelocityVoltage intakeRollersVelocityRequest = new MotionMagicVelocityVoltage(0);
  // private boolean intakeRollersAtSpeed = false;/

  public Rotors() {
    serializerRollers.getConfigurator().apply(ConstRotors.SERIALIZER_ROLLERS_CONFIGURATION);
    intakeRollersEast.getConfigurator().apply(ConstRotors.INTAKE_ROLLERS_EAST_CONFIGURATION);
    intakeRollersWest.getConfigurator().apply(ConstRotors.INTAKE_ROLLERS_WEST_CONFIGURATION);
    transferRollersEast.getConfigurator().apply(ConstRotors.TRANSFER_ROLLERS_EAST_CONFIGURATION);
    transferRollersWest.getConfigurator().apply(ConstRotors.TRANSFER_ROLLERS_WEST_CONFIGURATION);
    flywheelTopEast.getConfigurator().apply(ConstRotors.FLYWHEEL_EAST_CONFIGURATION);
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
    return flywheelTopEast.getVelocity().getValue();
  }

  public AngularVelocity getSerializerRollersVelocity() {
    return serializerRollers.getVelocity().getValue();
  }

  public AngularVelocity getIntakeRollersVelocity() {
    return intakeRollersEast.getVelocity().getValue();
  }

  public AngularVelocity getTransferRollersVelocity() {
    return transferRollersEast.getVelocity().getValue();
  }

  public void setSerializerRollersPercentOutput(Double speed) {
    serializerRollers.set(speed);
  }

  public void setIntakeRollersPercentOutput(Double speed) {
    intakeRollersEast.set(speed);
    intakeRollersWest.setControl(intakeRollerEastFollower);
  }

  public void setTransferRollersSpeeds(AngularVelocity speed) {
    transferRollersEast.setControl(transferRollersVelocityRequest.withVelocity(speed));
    transferRollersWest.setControl(transferRollersEastFollower);
  }

  public void setTransferRollersPercentOutput(Double speed) {
    transferRollersEast.set(speed);
    transferRollersWest.setControl(transferRollersEastFollower);
  }

  public void setFlywheelSpeeds(AngularVelocity speed) {
    flywheelTopEast.setControl(flyWheelVelocityRequest.withVelocity(speed));
    flywheelTopWest.setControl(flywheelWestFollower);
    flywheelBottomWest.setControl(flywheelWestFollower);
    flywheelBottomEast.setControl(flywheelEastFollower);
    lastDesiredFlyWheelSpeed = speed;
  }

  public void setFlywheelPercentOutput(Double speed) {
    flywheelTopEast.set(speed);
    flywheelTopWest.setControl(flywheelWestFollower);
    flywheelBottomWest.setControl(flywheelWestFollower);
    flywheelBottomEast.setControl(flywheelEastFollower);
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
