// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.RomiDrivetrain;
public class Forward extends CommandBase {
  double distance;
  RomiDrivetrain chassis;
  /** Creates a new Forward. */
  public Forward(double inches) {
    // Use addRequirements() here to declare subsystem dependencies.
    distance = inches;
    chassis = RobotContainer.chassis;
    addRequirements(chassis);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    chassis.resetEncoders();
    chassis.arcadeDrive(Constants.AUTON_SPEED, 0);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    chassis.arcadeDrive(Constants.AUTON_SPEED, 0);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    chassis.arcadeDrive(0, 0);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (chassis.getLeftDistanceInch() >= distance);
  }
}