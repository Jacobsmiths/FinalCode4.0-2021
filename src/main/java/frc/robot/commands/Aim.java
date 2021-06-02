// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.LimelightSub;

public class Aim extends CommandBase {
  /** Creates a new Aim. */
  DriveTrainSub drive;
  LimelightSub lime;
  
  public Aim(DriveTrainSub driveTrainSub, LimelightSub limelightSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    lime = limelightSub;
    drive = driveTrainSub;

    addRequirements(driveTrainSub, limelightSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    drive.setRight(-(lime.getX() * 0.015));
    drive.setLeft(lime.getX() * 0.015);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    drive.setRight(0.0);
    drive.setLeft(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
