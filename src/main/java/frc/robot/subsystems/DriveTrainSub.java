// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSub extends SubsystemBase {
  /** Creates a new DriveTrainSub. */
  private CANSparkMax frontRight;
  private CANSparkMax frontLeft;
  private CANSparkMax backRight;
  private CANSparkMax backLeft;
  
  SpeedControllerGroup left;
  SpeedControllerGroup right;

  public DifferentialDrive wheels;

  CANEncoder leftEn;
  CANEncoder rightEn;

  public DriveTrainSub() 
  {
    frontRight = new CANSparkMax(1, MotorType.kBrushless);
    frontLeft = new CANSparkMax(3, MotorType.kBrushless);
    backRight = new CANSparkMax(2, MotorType.kBrushless);
    backLeft = new CANSparkMax(4, MotorType.kBrushless);

    left = new SpeedControllerGroup(frontLeft, backLeft);
    right = new SpeedControllerGroup(frontRight, backRight);

    wheels = new DifferentialDrive(left,right);

    rightEn = frontRight.getEncoder();
    leftEn = frontLeft.getEncoder();
  }

  public void move(double x)
  {
    left.set(-x);
    right.set(x);
  }

  public void setRight(double speed)
  {
    right.set(speed);
  }

  public void setLeft(double speed)
  {
    left.set(speed);
  }

  public void off()
  {
    left.set(0);
    right.set(0);
    setZero();
  }

  public void setZero()
  {
    rightEn.setPosition(0);
    leftEn.setPosition(0);
  }

  public double getEnc()
  {
    return rightEn.getPosition();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
