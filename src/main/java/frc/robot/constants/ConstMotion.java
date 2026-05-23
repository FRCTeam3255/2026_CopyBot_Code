// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

import edu.wpi.first.units.measure.Angle;

/** Add your docs here. */
public class ConstMotion {
  public static final double STOP = 0;
  public static final TalonFXConfiguration INTAKE_PIVOT_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration HOOD_PIVOT_CONFIGURATION = new TalonFXConfiguration();
  public static final Angle HOOD_PIVOT_ANGLE = Degrees.of(0);
}
