// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceIDs;
import frc.robot.DeviceIDs.rotorIDs;
import frc.robot.constants.ConstRotors;

@Logged
public class Rotors extends SubsystemBase {
  final TalonFX serializerRollers = new TalonFX(rotorIDs.SERIALIZER_ROLLERS_CAN);
  final TalonFX intakeRollersWest = new TalonFX(rotorIDs.INTAKE_ROLLERS_WEST_CAN);
  final TalonFX intakeRollersEast = new TalonFX(rotorIDs.INTAKE_ROLLERS_EAST_CAN);
  final TalonFX transferRollersWest = new TalonFX((rotorIDs.TRANSFER_ROLLERS_WEST_CAN));
  final TalonFX transferRollersEast = new TalonFX((rotorIDs.TRANSFER_ROLLERS_EAST_CAN));
  final TalonFX flywheelRollersWest = new TalonFX((rotorIDs.FLYWHEEL_ROLLERS_WEST_CAN));
  final TalonFX flywheelRollersEast = new TalonFX((rotorIDs.FLYWHEEL_EAST_FOLLOWER));
  final TalonFX flywheelWestFollower = new TalonFX((rotorIDs.TRANSFER_ROLLERS_WEST_CAN));
  final TalonFX flywheelEastFollower = new TalonFX(rotorIDs.FLYWHEEL_EAST_FOLLOWER);

  /** Creates a new Rotors. */
  public Rotors() {
    serializerRollers.getConfigurator().apply(ConstRotors.SERIALIZER_ROLLERS_CONFIGURATION);
    intakeRollersEast.getConfigurator().apply(ConstRotors.INTAKE_ROLLERS_EAST_CONFIGURATION);
    intakeRollersWest.getConfigurator().apply(ConstRotors.FLYWHEEL_ROLLERS_WEST_CONFIGURATION);
    transferRollersEast.getConfigurator().apply(ConstRotors.TRANSFER_ROLLERS_EAST_CONFIGURATION);
    transferRollersWest.getConfigurator().apply(ConstRotors.TRANSFER_ROLLERS_WEST_CONFIGURATION);
    flywheelRollersEast.getConfigurator().apply(ConstRotors.FLYWHEEL_ROLLERS_EAST_CONFIGURATION);
    flywheelRollersEast.getConfigurator().apply(ConstRotors.FLYWHEEL_ROLLERS_EAST_CONFIGURATION);
    flywheelEastFollower.getConfigurator().apply(ConstRotors.FLYWHEEL_EAST_FOLLOWER_CONFIGURATION);
    flywheelWestFollower.getConfigurator().apply(ConstRotors.FLYWHEEL_WEST_FOLLOWER_CONFIGURATION);

  }

  public AngularVelocity getSerializerRollers() {
    return serializerRollers.getVelocity().getValue();

  }

  public AngularVelocity getIntakeRollersEast() {
    return serializerRollers.getVelocity().getValue();
  }

  public AngularVelocity getIntakeRollersWest() {
    return serializerRollers.getVelocity().getValue();
  }

  public AngularVelocity getTransferRollersEast() {
    return serializerRollers.getVelocity().getValue();
  }

  public AngularVelocity getTransferRollersWest() {
    return serializerRollers.getVelocity().getValue();
  }

  public AngularVelocity getFlywheelRollersEast() {
    return serializerRollers.getVelocity().getValue();
  }

  public AngularVelocity getFlywheelRollersWest() {
    return serializerRollers.getVelocity().getValue();
  }

  public AngularVelocity getFlywheelEastFollower() {
    return serializerRollers.getVelocity().getValue();
  }

  public AngularVelocity getFlywheelWestFollower() {
    return serializerRollers.getVelocity().getValue();
  }

  public void setSerializerRollers(double speed) {
    serializerRollers.set(speed);

  }

  public void intakeRollersEast(double speed) {
    intakeRollersWest.set(speed);

  }

  public void intakeRollersWest(double speed) {
    intakeRollersEast.set(speed);

  }

  public void transferRollersEast(double speed) {
    transferRollersEast.set(speed);

  }

  public void transferRollersWest(double speed) {
    transferRollersWest.set(speed);

  }

  public void flywheelRollersEast(double speed) {
    flywheelEastFollower.set(speed);

  }

  public void flywheelRollersWest(double speed) {
    flywheelRollersWest.set(speed);

  }

  public void flywheelWestFollower(double speed) {
    flywheelRollersWest.set(speed);

  }

  public void flywheelEastFollower(double speed) {
    flywheelEastFollower.set(speed);

  }

  @Override
  public void periodic() {

  }
}
