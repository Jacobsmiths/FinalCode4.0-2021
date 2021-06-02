// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSub;

public class Drive extends CommandBase {
  /** Creates a new Drive. */
  private final DriveTrainSub drive;
  
  public Drive(DriveTrainSub driveTrainSub) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    drive = driveTrainSub;

    addRequirements(driveTrainSub);
  }

  @Override 
  public void initialize() {}

  @Override
  public void execute() {
    drive.wheels.arcadeDrive(RobotContainer.driver.getRawAxis(1), -(RobotContainer.driver.getRawAxis(0)));
  }

  @Override 
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished()
  {
    return false;
  }
}
