// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class InternalSub extends SubsystemBase {
  /** Creates a new InternalSub. */

  CANSparkMax rightShooter;
  CANSparkMax leftShooter;
  CANSparkMax indexer;
  CANSparkMax intake;
  CANSparkMax lift;
  
  CANEncoder shooterEnc;
  CANEncoder indexerEnc;
  CANEncoder liftEnc;
  
  AnalogInput detector;

  public InternalSub() 
  {
    rightShooter = new CANSparkMax(9, MotorType.kBrushless);
    leftShooter = new CANSparkMax(8, MotorType.kBrushless);
    indexer = new CANSparkMax(7, MotorType.kBrushless);
    lift = new CANSparkMax(6, MotorType.kBrushless);
    intake = new CANSparkMax(5, MotorType.kBrushless);

    shooterEnc = rightShooter.getEncoder();
    indexerEnc = indexer.getEncoder();
    liftEnc = lift.getEncoder();

    detector = new AnalogInput(0);
  }

  // ++++++++++ LIFT METHODS ++++++++++++
  public void raiseIntake()
  {
    lift.set(-0.3);
  }

  public void lowerIntake()
  {
    lift.set(.3);
  }

  public void stopLift()
  {
    lift.set(0);
  }

  // +++++++++++++ SHOOTER METHODS ++++++++++++
  public void shoot(double x)
  {
    rightShooter.set(-x);
    leftShooter.set(x);
  }

  public void stopShooting()
  {
    rightShooter.set(0);
    leftShooter.set(0);
  }

  public double getVelocity()
  {
    return shooterEnc.getVelocity();
  }

  // ++++++++++ INDEXER METHODS +++++++++++++
  public void setIndexerPos()
  {
    indexerEnc.setPosition(0);
  }

  public double getIndexerEnc()
  {
    return indexerEnc.getPosition();
  }

  public void indexerOn()
  {
    indexer.set(.5);
  }

  public void indexerReverse()
  {
    indexer.set(-.1);
  }

  public void indexerOff()
  {
    indexer.set(0);
  }

  // ++++++++++++++ INTAKE METHODS ++++++++++++
  public void intakeOn()
  {
    intake.set(.8);
  }

  public void intakeOff()
  {
    intake.set(0);
  }

  public double getLiftEnc()
  {
    return liftEnc.getPosition();
  }

  public void intakeReverse()
  {
    intake.set(-.5);
  }

  // ++++++++++++ COMMAND METHODS ++++++++++++
  public void reverse()
  {
    intake.set(-.8);
    indexer.set(-.1);
  }

  public void end()
  {
    intake.set(0);
    indexer.set(0);
  }

  public boolean canReload()
  {
    return (detector.getVoltage() > 0);
  }

  public void reload()
  {
    SmartDashboard.putNumber("Encoder of Indexer", getIndexerEnc());
    setIndexerPos();
    indexerOn();
    if(getIndexerEnc() > 5)
    {
      indexerOff();
    }
  }

  public void indexerOnBy(double speed)
  {
    indexer.set(speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
