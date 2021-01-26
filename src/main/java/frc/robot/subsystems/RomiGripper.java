// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RomiGripper extends SubsystemBase {

  private final Servo m_gripper = new Servo(Constants.GRIPPER);
  private double m_gripperPos;

  /** Creates a new RomiGripper. */
  public RomiGripper() {
    reset();
  }

  public void reset() {
    m_gripperPos = 0.5;

    m_gripper.set(m_gripperPos);
  }

  public void incrementGripper(double delta) {
    /* Spec: https://www.pololu.com/docs/0J76/4
     * Range should be 500 (open) - 2400 (closed) us 
     * AnalogIn range right now from 440 - 1850.
    */
    m_gripperPos = saturateLimit(m_gripperPos + delta, 0, 1); 
    m_gripper.set(m_gripperPos);
  }
  
  public double get_gripperPos() {
    return m_gripperPos;
  }

  public double getGripperAngle(){
    return m_gripper.getAngle();
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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}