// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RomiArm extends SubsystemBase {

  private final Spark m_gripper = new Spark(Constants.GRIPPER);
  private final Spark m_arm = new Spark(Constants.ARM);
  private final Spark m_wrist = new Spark(Constants.WRIST);
  private double m_liftPos;
  private double m_tiltPos;
  private double m_gripperPos;


  /** Creates a new RomiArm. */
  public RomiArm() {
    reset();
  }

  public void reset() {
    m_liftPos = 0.5;
    m_tiltPos = 0.5;
    m_gripperPos = 0.5;

    m_gripper.set(m_gripperPos);
    m_arm.set(m_tiltPos);
    m_wrist.set(m_liftPos);
    // SmartDashboard.putNumber("Arm Pos", get_armPos());
    // SmartDashboard.putNumber("Gripper Pos", get_gripperPos());
    // SmartDashboard.putNumber("Wrist Pos", get_wristPos());
  }

  public void incrementGripper(double delta) {
    /* Spec: https://www.pololu.com/docs/0J76/4
     * Range should be 500 (open) - 2400 (closed) us 
     * AnalogIn range right now from 440 - 1850.
    */
    m_gripperPos = saturateLimit(m_gripperPos + delta, -1, 1); 
    SmartDashboard.putNumber("Gripper Pos", get_gripperPos());
    m_gripper.set(m_gripperPos);
  }

  public void incrementArm(double delta) {
    /* Spec: https://www.pololu.com/docs/0J76/4
     * Range should be 1000 (raised) - 1900 (lowered) us 
     */
    m_liftPos = saturateLimit(m_liftPos + delta, -1,0.15); 
    SmartDashboard.putNumber("Arm Pos", get_armPos());
    m_arm.set(m_liftPos);
  }

  public void incrementWrist(double delta) {
    /* Spec: https://www.pololu.com/docs/0J76/4
     * Range should be 1200 (down) - 1900 (up) us 
    */
    m_tiltPos = saturateLimit(m_tiltPos + delta, -0.5, .7); 
    SmartDashboard.putNumber("Wrist Pos", get_wristPos());
    m_wrist.set(m_tiltPos);
  }


  public double saturateLimit(double val, double l_limit, double u_limit) {
    double outval = val;
    if(val > u_limit) {
      outval =  u_limit;
    } else if (val < l_limit) {
      outval = l_limit;
    }
    return outval;
  }

  public double get_gripperPos() {
    return m_gripperPos;
  }

  public double get_armPos() {
    return m_liftPos;
  }

  public double get_wristPos() {
    return m_tiltPos;
  }
  
  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }
}
