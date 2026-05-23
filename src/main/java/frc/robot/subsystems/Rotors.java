// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Velocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceIDs.rotorIDs;
import frc.robot.constants.ConstRotors;

@Logged
public class Rotors extends SubsystemBase {
  final TalonFX serializerRollers = new TalonFX(rotorIDs.SERIALIZER_ROLLERS_CAN);
  final TalonFX intakeRollersWest = new TalonFX(rotorIDs.INTAKE_ROLLERS_WEST_CAN);
  final TalonFX intakeRollersEast = new TalonFX(rotorIDs.INTAKE_ROLLERS_EAST_CAN);
  final TalonFX transferRollersWest = new TalonFX((rotorIDs.TRANSFER_ROLLERS_WEST_CAN));
  final TalonFX transferRollersEast = new TalonFX((rotorIDs.TRANSFER_ROLLERS_EAST_CAN));
  final TalonFX flywheelWest = new TalonFX((rotorIDs.FLYWHEEL_WEST_CAN));
  final TalonFX flywheelEast = new TalonFX((rotorIDs.FLYWHEEL_EAST_CAN));
  final TalonFX flywheelWestFollower = new TalonFX((rotorIDs.FLYWHEEL_WEST_FOLLOWER_CAN));
  final TalonFX flywheelEastFollower = new TalonFX(rotorIDs.FLYWHEEL_EAST_FOLLOWER_CAN);

  /** Creates a new Rotors. */
  public Rotors() {
    serializerRollers.getConfigurator().apply(ConstRotors.SERIALIZER_ROLLERS_CONFIGURATION);
    intakeRollersEast.getConfigurator().apply(ConstRotors.INTAKE_ROLLERS_EAST_CONFIGURATION);
    intakeRollersWest.getConfigurator().apply(ConstRotors.INTAKE_ROLLERS_WEST_CONFIGURATION);
    transferRollersEast.getConfigurator().apply(ConstRotors.TRANSFER_ROLLERS_EAST_CONFIGURATION);
    transferRollersWest.getConfigurator().apply(ConstRotors.TRANSFER_ROLLERS_WEST_CONFIGURATION);
    flywheelEast.getConfigurator().apply(ConstRotors.FLYWHEEL_EAST_CONFIGURATION);
    flywheelWest.getConfigurator().apply(ConstRotors.FLYWHEEL_WEST_CONFIGURATION);
    flywheelEastFollower.getConfigurator().apply(ConstRotors.FLYWHEEL_EAST_FOLLOWER_CONFIGURATION);
    flywheelWestFollower.getConfigurator().apply(ConstRotors.FLYWHEEL_WEST_FOLLOWER_CONFIGURATION);
  }

  public AngularVelocity getSerializerRollersVelocity() {
    return serializerRollers.getVelocity().getValue();
  }

  public AngularVelocity getIntakeRollersEastVelocity() {
    return intakeRollersEast.getVelocity().getValue();
  }

  public AngularVelocity getIntakeRollersWestVelocity() {
    return intakeRollersWest.getVelocity().getValue();
  }

  public AngularVelocity getTransferRollersEastVelocity() {
    return transferRollersEast.getVelocity().getValue();
  }

  public AngularVelocity getTransferRollersWestVelocity() {
    return transferRollersWest.getVelocity().getValue();
  }

  public AngularVelocity getFlywheelEastVelocity() {
    return flywheelEast.getVelocity().getValue();
  }

  public AngularVelocity getFlywheelWestVelocity() {
    return flywheelWest.getVelocity().getValue();
  }

  public AngularVelocity getFlywheelEastFollowerVelocity() {
    return flywheelEastFollower.getVelocity().getValue();
  }

  public AngularVelocity getFlywheelWestFollowerVelocity() {
    return flywheelWestFollower.getVelocity().getValue();
  }

  public void setSerializerRollersSpeed(double speed) {
    serializerRollers.set(speed);
  }

  public void setIntakeRollersEastSpeed(double speed) {
    intakeRollersEast.set(speed);
  }

  public void setIntakeRollersWestSpeed(double speed) {
    intakeRollersWest.set(speed);
  }

  public void setTransferRollersEastSpeed(double speed) {
    transferRollersEast.set(speed);
  }

  public void setTransferRollersWestSpeed(double speed) {
    transferRollersWest.set(speed);
  }

  public void setFlywheelEastSpeed(double speed) {
    flywheelEast.set(speed);
  }

  public void setFlywheelWestSpeed(double speed) {
    flywheelWest.set(speed);
  }

  public void setFlywheelWestFollowerSpeed(double speed) {
    flywheelWestFollower.set(speed);
  }

  public void setFlywheelEastFollowerSpeed(double speed) {
    flywheelEastFollower.set(speed);
  }

  @Override
  public void periodic() {

  }
}
