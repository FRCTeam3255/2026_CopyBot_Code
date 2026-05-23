// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Degrees;
import com.ctre.phoenix6.controls.MotionMagicExpoVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceIDs;
import frc.robot.Robot;
import frc.robot.constants.ConstMotion;

@Logged
public class Motion extends SubsystemBase {
  /** Creates a new Motion. */
  final TalonFX intakePivot = new TalonFX(DeviceIDs.motionIDs.INTAKE_PIVOT_CAN);
  final TalonFX hoodPivot = new TalonFX(DeviceIDs.motionIDs.HOOD_PIVOT_CAN);

  MotionMagicExpoVoltage hoodPivotMotionRequest = new MotionMagicExpoVoltage(0);
  MotionMagicExpoVoltage intakePivotMotionRequest = new MotionMagicExpoVoltage(0);

  Angle lastDesiredHoodPivotAngle = Degrees.zero();
  Angle lastDesiredIntakePivotAngle = Degrees.zero();

  private boolean hoodAtPostion = false;
  private boolean intakePivotAtPosition = false;

  public Motion() {
    intakePivot.getConfigurator().apply(ConstMotion.INTAKE_PIVOT_CONFIGURATION);
    hoodPivot.getConfigurator().apply(ConstMotion.HOOD_PIVOT_CONFIGURATION);
  }

  /**
   * this codes takes an angle and setting a desired angle for the Intake to
   * allign to.
   */
  public void setIntakePivotAngle(Angle setAngle) {
    intakePivot.setControl(intakePivotMotionRequest.withPosition(setAngle));
    lastDesiredIntakePivotAngle = setAngle;
  }

  /**
   * this codes takes an angle and setting a desired angle for the Hood to allign
   * to
   */
  public void setHoodPivotAngle(Angle setAngle) {
    hoodPivot.setControl(hoodPivotMotionRequest.withPosition(setAngle));
    lastDesiredHoodPivotAngle = setAngle;
  }

  public Angle getIntakePivotAngle() {
    if (Robot.isSimulation()) {
      return lastDesiredIntakePivotAngle;
    }
    return intakePivot.getPosition().getValue();
  }

  public Angle getHoodPivotAngle() {
    if (Robot.isSimulation()) {
      return lastDesiredHoodPivotAngle;
    }
    return hoodPivot.getPosition().getValue();
  }

  /** checks to see if hood is at correct angle */
  public boolean isHoodPivotAtAngle(Angle tolerance) {
    Angle lowerlim = lastDesiredHoodPivotAngle.minus(tolerance);
    Angle upperlim = lastDesiredHoodPivotAngle.plus(tolerance);

    Angle hoodPivotAngle = getPivotAngle();

    hoodAtPostion = hoodPivotAngle.gte(lowerlim)
        && hoodPivotAngle.lte(upperlim);
    return hoodAtPostion;
  }

  public boolean isIntakePivotAtAngle(Angle tolerance) {
    Angle lowerlim = lastDesiredIntakePivotAngle.minus(tolerance);
    Angle upperlim = lastDesiredIntakePivotAngle.plus(tolerance);

    Angle intakePivotAngle = getPivotAngle();

    intakePivotAtPosition = intakePivotAngle.gte(lowerlim)
        && intakePivotAngle.lte(upperlim);
    return intakePivotAtPosition;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
