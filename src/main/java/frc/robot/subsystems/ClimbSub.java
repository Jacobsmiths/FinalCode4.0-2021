// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSub extends SubsystemBase {
  /** Creates a new ClimbSub. */
  CANSparkMax rightClimb;
  CANSparkMax leftClimb;
  
  CANSparkMax topLeftClimb;
  CANSparkMax topRightClimb;

  CANEncoder encoderRight;
  CANEncoder encoderLeft;
  
  public ClimbSub() 
  {
    rightClimb = new CANSparkMax(10 , MotorType.kBrushless);
    leftClimb = new CANSparkMax(11, MotorType.kBrushless);

    topLeftClimb = new CANSparkMax(13, MotorType.kBrushless);
    topRightClimb = new CANSparkMax(12, MotorType.kBrushless);

    encoderRight = rightClimb.getEncoder();
    encoderLeft = leftClimb.getEncoder();
  }

  // +++++++++ GETTING ENCODERS +++++++++++++++++
  public double getRight()
  {
    return encoderRight.getPosition();
  }

  public double getLeft()
  {
    return encoderLeft.getPosition();
  }

  //+++++++++++++++++ LEFT AND RIGHT CLIMB METHODS ++++++++++++++
  public void setRight(double speed)
  {
    rightClimb.set(speed);
  }

  public void setLeft(double speed)
  {
    leftClimb.set(speed);
  }
  
  public void endRight()
  {
    rightClimb.set(0);
  }

  public void endLeft()
  {
    leftClimb.set(0);
  }

  // ++++++++++++++++ TOP MOTOR METHODS +++++++++++++++++++
  public void setTopRight()
  {
    topLeftClimb.set(1);
    topRightClimb.set(1);
  }

  public void setTopLeft()
  {
    topLeftClimb.set(-1);
    topRightClimb.set(-1);
  }

  public void endTop()
  {
    topRightClimb.set(0);
    topLeftClimb.set(0);
  }

  public void showEncoderValues()
  {
    SmartDashboard.putNumber("Right CLimb Encoder Values", getRight());
    SmartDashboard.putNumber("Left Climb Encoder Values",getLeft());
    SmartDashboard.putNumber("Right Trigger", rightClimb.get());
    SmartDashboard.putNumber("Left Trigger", leftClimb.get());
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
