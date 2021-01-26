// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RomiWrist extends SubsystemBase {
  
  private final Servo m_wrist = new Servo(Constants.WRIST);
  private double m_tiltPos;

  /** Creates a new RomiWrist. */
  public RomiWrist() {
    reset();
  }

  public void reset() {
    m_tiltPos = 0.5;

    m_wrist.set(m_tiltPos);
  }

  public void incrementWrist(double delta) {
    /* Spec: https://www.pololu.com/docs/0J76/4
     * Range should be 1200 (down) - 1900 (up) us 
    */
    m_tiltPos = saturateLimit(m_tiltPos + delta, 0.45, .6); 
    m_wrist.set(m_tiltPos);
  }

  public double get_wristPos() {
    return m_tiltPos;
  }
  
  public double getwristAngle(){
    return m_wrist.getAngle();
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