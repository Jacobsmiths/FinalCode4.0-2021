// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSub extends SubsystemBase {
  /** Creates a new LimelightSub. */
  double x;
  double y;
  double area;
  
  NetworkTable table;
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  //NetworkTableEntry tv;

  public LimelightSub() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    updateValues();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run 
    updateValues();

  }

  public void updateValues() {
    
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");


    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0);
    SmartDashboard.putNumber("X values",x);
    SmartDashboard.putNumber("Y values", y);
    SmartDashboard.putNumber("Area values", area);
    SmartDashboard.putNumber("Distance",getDistance());
  }

  public double getX()
  {
  
    return x;
  }

  public double getY()
  {

    return y;
  }

  public double getArea()
  {
    return area;
  }

  public double getDistance()
  {
  
  double a1 = Math.toRadians(65);
  double a2 = Math.toRadians(getY());
  return 3.636363*(64 / Math.tan(a1 +a2));  
  }
}
