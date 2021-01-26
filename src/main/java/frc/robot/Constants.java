// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //XBOX controller
    public final class Button {
        public static final int X = 1;
        public static final int A = 2;
        public static final int B = 3;
        public static final int Y = 4;
        public static final int TOPLEFT = 5;
        public static final int TOPRIGHT = 6;
        public static final int BOTTOMLEFT = 7;
        public static final int BOTTOMRIGHT = 8;
    }

    //Romi motors
    public static final int LEFT_MOTOR = 0;
    public static final int RIGHT_MOTOR = 1;
    public static final int GRIPPER = 2;
    public static final int ARM = 3;
    public static final int WRIST = 4;

    //Romi encoder
    public static final int LEFT_ENCODER_A = 4;
    public static final int LEFT_ENCODER_B = 5;
    public static final int RIGHT_ENCODER_A = 6;
    public static final int RIGHT_ENCODER_B = 7;

    //Romi parameters
    public static final double COUNTS_PER_REV = 1440.0;
    public static final double WHEEL_DIAMETER_IN = 2.75591; //70 mm
    //wheel placement diameter of 149 mm. Width of wheel is 8 mm. Wheel track is 141 mm, or 5.551"
    public static final double WHEEL_TRACK = 5.551; //wheel placement
    public static final double INCHES_PER_PULSE = (Math.PI * WHEEL_DIAMETER_IN ) / COUNTS_PER_REV;

    //Onboard Romi sensors/input/output
    public final static int BTN_A = 0;
    public final static int BTN_B = 1;
    public final static int BTN_C = 2;
    public final static int GREEN_LED = 1;
    public final static int RED_LED = 2;
    public final static int YEL_LED = 3;

    //command constants
	public static final double AUTON_SPEED = 0.5 ;



}
