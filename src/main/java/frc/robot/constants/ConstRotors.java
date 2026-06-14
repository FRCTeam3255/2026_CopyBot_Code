// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import static edu.wpi.first.units.Units.RPM;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.interpolation.InterpolatingDoubleTreeMap;
import edu.wpi.first.math.interpolation.InterpolatingTreeMap;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.AngularVelocity;

/** Add your docs here. */
public class ConstRotors {

  public static final InterpolatingDoubleTreeMap flyWheelSpeedMap = new InterpolatingDoubleTreeMap();

  public static final TalonFXConfiguration SERIALIZER_ROLLERS_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration INTAKE_ROLLERS_EAST_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration INTAKE_ROLLERS_WEST_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration TRANSFER_ROLLERS_EAST_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration TRANSFER_ROLLERS_WEST_CONFIGURATION = new TalonFXConfiguration();

  public static final TalonFXConfiguration FLYWHEEL_EAST_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration FLYWHEEL_WEST_CONFIGURATION = new TalonFXConfiguration();
  public static final AngularVelocity FLYWHEEL_CORNER_SPEED = Units.RPM.of(4250);
  public static final AngularVelocity FLYWHEEL_HUB_SPEED = Units.RPM.of(4000);
  public static final AngularVelocity FLYWHEEL_TRENCH_SPEED = Units.RPM.of(4000);
  public static final AngularVelocity FLYWHEEL_TOWER_SPEED = Units.RPM.of(4000);
  public static final AngularVelocity FLYWHEEL_ANYWHERE_SPEED = Units.RPM.of(4100);
  public static final AngularVelocity FLYWHEEL_NEUTRAL_TO_ALLIANCE_SPEED = Units.RPM.of(3700);
  public static final AngularVelocity FLYWHEEL_OPPONENT_TO_ALLIANCE_SPEED = Units.RPM.of(6400);

  public static final double INTAKE_ROLLERS_SPEED = 1;
  public static final AngularVelocity FLYWHEEL_SHOOTING_SPEED = Units.RPM.of(1000);
  // public static final AngularVelocity INTAKE_ROLLER_SPEED = Units.RPM.of(2000);
  public static final double SERIALIZER_SHOOTING_SPEED = 1;
  public static final double STOP = 0;
  public static final AngularVelocity TRANSFER_ROLLERS_SPEED = Units.RPM.of(3400);
  public static final AngularVelocity FLYWHEEL_TOLERANCE = Units.RPM.of(100);
  public static final double REVERSE_SHOOTING_SPEED = -1;
  public static final double REVERSE_SERIALIZER_ROLLERS_SPEED = -1;
  public static final double REVERSE_INTAKE_ROLLERS_SPEED = -1;
  public static final double REVERSE_TRANSFER_ROLLERS_SPEED = -1;

  static {

    flyWheelSpeedMap.put(Units.Inches.of(190).in(Units.Inches), RPM.of(4200).in(RPM));
    flyWheelSpeedMap.put(Units.Inches.of(180).in(Units.Inches), RPM.of(4125).in(RPM));
    flyWheelSpeedMap.put(Units.Inches.of(165.1).in(Units.Inches), RPM.of(4100).in(RPM));
    flyWheelSpeedMap.put(Units.Inches.of(165).in(Units.Inches), RPM.of(4000).in(RPM));
    flyWheelSpeedMap.put(Units.Inches.of(160).in(Units.Inches), RPM.of(3800).in(RPM));
    flyWheelSpeedMap.put(Units.Inches.of(150).in(Units.Inches), RPM.of(3700).in(RPM));
    flyWheelSpeedMap.put(Units.Inches.of(140).in(Units.Inches), RPM.of(3600).in(RPM));
    flyWheelSpeedMap.put(Units.Inches.of(120).in(Units.Inches), RPM.of(3400).in(RPM));
    flyWheelSpeedMap.put(Units.Inches.of(0).in(Units.Inches), RPM.of(3400).in(RPM));

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
    TRANSFER_ROLLERS_WEST_CONFIGURATION.Slot0.kP = 0.7;
    TRANSFER_ROLLERS_WEST_CONFIGURATION.Slot0.kS = 0.15;
    TRANSFER_ROLLERS_WEST_CONFIGURATION.Slot0.kV = 0.12;
    TRANSFER_ROLLERS_WEST_CONFIGURATION.Slot0.kA = 0;
    TRANSFER_ROLLERS_WEST_CONFIGURATION.MotionMagic.MotionMagicCruiseVelocity = 0;
    TRANSFER_ROLLERS_WEST_CONFIGURATION.MotionMagic.MotionMagicAcceleration = 9999;
    TRANSFER_ROLLERS_WEST_CONFIGURATION.MotionMagic.MotionMagicJerk = 0;
  }

}
