// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

/** Add your docs here. */
public class ConstMotion {
  public static final Angle INTAKE_PIVOT_TOLERANCE = Degrees.of(1.0);
  public static final double INTAKE_PIVOT_AGITATION_TIME = 1 / 3;
  public static final TalonFXConfiguration INTAKE_PIVOT_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration HOOD_PIVOT_CONFIGURATION = new TalonFXConfiguration();
  public static final Angle DEPLOY_INTAKE_PIVOT_ANGLE = Degrees.of(125);
  public static final Angle RETRACT_INTAKE_PIVOT_ANGLE = Degrees.of(0);
  public static final Angle HOOD_PIVOT_ANGLE = Degrees.of(14);
  public static final Angle HOOD_PIVOT_ANGLE_RETRACT = Degrees.of(0);
  public static final double STOP = 0;
  public static final Angle HOOD_NONE_ANGLE = Degrees.of(0);
  public static final Angle HOOD_TRENCH_ANGLE = Units.Degrees.of(13);
  public static final Angle HOOD_CORNER_ANGLE = Units.Degrees.of(23.5);
  public static final Angle HOOD_TOWER_ANGLE = Units.Degrees.of(14);
  public static final Angle HOOD_HUB_ANGLE = Units.Degrees.of(9.5);
  public static final Angle HOOD_ANYWHERE_ANGLE = Units.Degrees.of(45);
  public static final Angle HOOD_NEUTRAL_TO_ALLIANCE_ANGLE = Units.Degrees.of(45);
  public static final Angle HOOD_OPPENENT_TO_ALLIANCE_ANGLE = Units.Degrees.of(37);

  static {

    INTAKE_PIVOT_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    INTAKE_PIVOT_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    INTAKE_PIVOT_CONFIGURATION.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    INTAKE_PIVOT_CONFIGURATION.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    INTAKE_PIVOT_CONFIGURATION.SoftwareLimitSwitch.ForwardSoftLimitThreshold = DEPLOY_INTAKE_PIVOT_ANGLE.in(Rotations);
    INTAKE_PIVOT_CONFIGURATION.SoftwareLimitSwitch.ReverseSoftLimitThreshold = RETRACT_INTAKE_PIVOT_ANGLE.in(Rotations);
    INTAKE_PIVOT_CONFIGURATION.Slot0.GravityType = GravityTypeValue.Arm_Cosine;
    INTAKE_PIVOT_CONFIGURATION.Slot0.kS = 0.3;
    INTAKE_PIVOT_CONFIGURATION.Slot0.kP = 40;
    INTAKE_PIVOT_CONFIGURATION.Slot0.StaticFeedforwardSign = StaticFeedforwardSignValue.UseClosedLoopSign;
    INTAKE_PIVOT_CONFIGURATION.Feedback.SensorToMechanismRatio = 1.0 / ((16.0 / 42.0) * (18.0 / 60.0) * (12.0 / 60.0));

    HOOD_PIVOT_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    HOOD_PIVOT_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    HOOD_PIVOT_CONFIGURATION.Feedback.SensorToMechanismRatio = 1.0 / ((10.0 / 42.0) * (10.0 / 210.0));
    HOOD_PIVOT_CONFIGURATION.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    HOOD_PIVOT_CONFIGURATION.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    HOOD_PIVOT_CONFIGURATION.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Degrees.of(46).in(Rotations);
    // Do not change, it's not at zero because the hood is not perfectly at 0 when
    // the encoder reads 0
    HOOD_PIVOT_CONFIGURATION.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Degrees.of(1.6).in(Rotations);
    HOOD_PIVOT_CONFIGURATION.Slot0.GravityType = GravityTypeValue.Arm_Cosine;
    HOOD_PIVOT_CONFIGURATION.Slot0.kS = 0.2;
    HOOD_PIVOT_CONFIGURATION.Slot0.kP = 300;
    HOOD_PIVOT_CONFIGURATION.Slot0.kG = 0.1;
    HOOD_PIVOT_CONFIGURATION.Slot0.StaticFeedforwardSign = StaticFeedforwardSignValue.UseClosedLoopSign;
  }
}
