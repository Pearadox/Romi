// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.sensors.RomiGyro;

public class RomiDrivetrain extends SubsystemBase {

  // The Romi has the left and right motors set to
  // PWM channels 0 and 1 respectively
  private final Spark m_leftMotor = new Spark(Constants.LEFT_MOTOR);
  private final Spark m_rightMotor = new Spark(Constants.RIGHT_MOTOR);

  // The Romi has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  private final Encoder m_leftEncoder = new Encoder(Constants.LEFT_ENCODER_A, Constants.LEFT_ENCODER_B);
  private final Encoder m_rightEncoder = new Encoder(Constants.RIGHT_ENCODER_A, Constants.RIGHT_ENCODER_B);

  // Set up the differential drive controller
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);


  private final RomiGyro m_gyro = new RomiGyro();
  private final BuiltInAccelerometer accel = new BuiltInAccelerometer();

  /** Creates a new RomiDrivetrain. */
  public RomiDrivetrain() {
    // Use inches as unit for encoder distances
    m_leftEncoder.setDistancePerPulse(Constants.INCHES_PER_PULSE);
    m_rightEncoder.setDistancePerPulse(Constants.INCHES_PER_PULSE);
    resetEncoders();
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }

  public void resetEncoders() {
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  public double getLeftDistanceInch() {
    return m_leftEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    return m_rightEncoder.getDistance();
  }
  
  public double getAverageDistanceInch() {
    return (getRightDistanceInch() + getLeftDistanceInch())/ 2.0;
  }

  public double getAccelX() {
    return accel.getX();
  }
  public double getAccelY() {
    return accel.getY();
  }
  public double getAccelZ() {
    return accel.getZ();
  }
  public double getGyroAngleX() {
    return m_gyro.getAngleX(); 
  }
  public double getGyroAngleY() {
    return m_gyro.getAngleY(); 
  }
  public double getGyroAngleZ() {
    return m_gyro.getAngleZ(); 
  }
  public void resetGyro() {
    m_gyro.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    
    SmartDashboard.putNumber("GyroZ", getGyroAngleZ());
    SmartDashboard.putNumber("Left inches", getLeftDistanceInch());
    SmartDashboard.putNumber("Right inches", getRightDistanceInch());
    SmartDashboard.putNumber("Average", getAverageDistanceInch());
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
