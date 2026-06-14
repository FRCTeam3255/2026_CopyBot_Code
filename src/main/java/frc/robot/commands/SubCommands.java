package frc.robot.commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Distance;
import frc.robot.RobotContainer;

public class SubCommands{
public static Angle aim(boolean aimDT){
  Pose2d hubPose = RobotContainer.robotPose.getHub();
  Distance distanceToHub = RobotContainer.robotPose.getDistanceToHub();
  Angle targetHoodAngle = RobotContainer.motionInstance.getMappedHoodAngle(distanceToHub);
  AngularVelocity targetFlyWheelSpeed = RobotContainer.rotorsInstance.getMappedFlywheelSpeed(distanceToHub);
  Angle targetDrivetrainAngle = RobotContainer.drivetrainInstance.snapToTarget(hubPose);

  RobotContainer.rotorsInstance.setFlyWheelSpeeds(targetFlyWheelSpeed);
  RobotContainer.motionInstance.setHoodPivotAngle(targetHoodAngle);
  if (aimDT){
    RobotContainer.drivetrainInstance.setDriveRotation(targetDrivetrainAngle);
  }
  return targetDrivetrainAngle;
}

}
