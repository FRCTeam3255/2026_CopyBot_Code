// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.AngularVelocity;

/** Add your docs here. */
public class ConstRotors {

  public static final TalonFXConfiguration SERIALIZER_ROLLERS_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration INTAKE_ROLLERS_EAST_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration INTAKE_ROLLERS_WEST_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration TRANSFER_ROLLERS_EAST_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration TRANSFER_ROLLERS_WEST_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration FLYWHEEL_EAST_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration FLYWHEEL_WEST_CONFIGURATION = new TalonFXConfiguration();
  public static final AngularVelocity INTAKE_ROLLERS_SPEED = Units.RPM.of(3);

  static {

    // SHOOTER_TRANSFER_EAST_CONFIGURATION.MotorOutput.NeutralMode =
    // NeutralModeValue.Coast;/

    FLYWHEEL_WEST_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    FLYWHEEL_WEST_CONFIGURATION.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    FLYWHEEL_WEST_CONFIGURATION.Slot0.kS = 0.14;
    FLYWHEEL_WEST_CONFIGURATION.Slot0.kV = 0.11167;
    FLYWHEEL_WEST_CONFIGURATION.Slot0.kA = 0;
    FLYWHEEL_WEST_CONFIGURATION.Slot0.kP = 0.5;
    FLYWHEEL_WEST_CONFIGURATION.MotionMagic.MotionMagicCruiseVelocity = 0;
    FLYWHEEL_WEST_CONFIGURATION.MotionMagic.MotionMagicAcceleration = 9999;
    FLYWHEEL_WEST_CONFIGURATION.MotionMagic.MotionMagicJerk = 0;
    FLYWHEEL_WEST_CONFIGURATION.CurrentLimits.SupplyCurrentLimitEnable = true;
    FLYWHEEL_WEST_CONFIGURATION.CurrentLimits.SupplyCurrentLowerLimit = 70;

    FLYWHEEL_EAST_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    FLYWHEEL_EAST_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    FLYWHEEL_EAST_CONFIGURATION.Slot0.kS = 0.14;
    FLYWHEEL_EAST_CONFIGURATION.Slot0.kV = 0.11167;
    FLYWHEEL_EAST_CONFIGURATION.Slot0.kA = 0;
    FLYWHEEL_EAST_CONFIGURATION.Slot0.kP = 0.5;
    FLYWHEEL_EAST_CONFIGURATION.MotionMagic.MotionMagicCruiseVelocity = 0;
    FLYWHEEL_EAST_CONFIGURATION.MotionMagic.MotionMagicAcceleration = 9999;
    FLYWHEEL_EAST_CONFIGURATION.MotionMagic.MotionMagicJerk = 0;
    FLYWHEEL_EAST_CONFIGURATION.CurrentLimits.SupplyCurrentLimitEnable = true;
    FLYWHEEL_EAST_CONFIGURATION.CurrentLimits.SupplyCurrentLowerLimit = 70;

    SERIALIZER_ROLLERS_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    SERIALIZER_ROLLERS_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    INTAKE_ROLLERS_EAST_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    INTAKE_ROLLERS_EAST_CONFIGURATION.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    INTAKE_ROLLERS_EAST_CONFIGURATION.CurrentLimits.SupplyCurrentLimitEnable = true;
    INTAKE_ROLLERS_EAST_CONFIGURATION.CurrentLimits.SupplyCurrentLowerLimit = 35;

    INTAKE_ROLLERS_WEST_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    INTAKE_ROLLERS_WEST_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    INTAKE_ROLLERS_WEST_CONFIGURATION.CurrentLimits.SupplyCurrentLimitEnable = true;
    INTAKE_ROLLERS_WEST_CONFIGURATION.CurrentLimits.SupplyCurrentLowerLimit = 35;

    TRANSFER_ROLLERS_EAST_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    TRANSFER_ROLLERS_EAST_CONFIGURATION.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    TRANSFER_ROLLERS_EAST_CONFIGURATION.Slot0.kP = 0.7;
    TRANSFER_ROLLERS_EAST_CONFIGURATION.Slot0.kS = 0.15;
    TRANSFER_ROLLERS_EAST_CONFIGURATION.Slot0.kV = 0.12;
    TRANSFER_ROLLERS_EAST_CONFIGURATION.Slot0.kA = 0;
    TRANSFER_ROLLERS_EAST_CONFIGURATION.MotionMagic.MotionMagicCruiseVelocity = 0;
    TRANSFER_ROLLERS_EAST_CONFIGURATION.MotionMagic.MotionMagicAcceleration = 9999;
    TRANSFER_ROLLERS_EAST_CONFIGURATION.MotionMagic.MotionMagicJerk = 0;

    TRANSFER_ROLLERS_WEST_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    TRANSFER_ROLLERS_WEST_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

  }

  public static final AngularVelocity STOP = Units.RPM.of(0);

}
