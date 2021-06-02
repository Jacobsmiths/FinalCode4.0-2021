// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimbSub;

public class Climb extends CommandBase {
  /** Creates a new Climb. */
  ClimbSub climb;

  public Climb(ClimbSub climbSub) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    climb = climbSub;

    addRequirements(climbSub);
  }

  @Override
  public void initialize() {}

  // +++++++++++++ RIGHT CLIMB COMMANDS ++++++++++++++++
  public void moveRight(double speed)
  {
    climb.setRight(speed);
  }

  // +++++++++++++ LEFT CLIMB COMMANDS +++++++++++++++++
  public void moveLeft(double speed) 
  {
    climb.setLeft(speed);
  }

  // ++++++++++++++++++++++ STOP CLIMB METHODS++++++++++++++++++++
  public void stopLeft()
  {
    climb.setLeft(0.0);
  }

  public void stopRight()
  {
    climb.setRight(0.0);
  }

  //++++++++++++++++++++ TOP MOTOR METHOD ++++++++++++++++++
  public void moveTopRight()
  {
    climb.setTopRight();
  }

  public void moveTopLeft()
  {
    climb.setTopLeft();
  }

  public void stopTop()
  {
    climb.endTop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    //+++++++++++++++CLIMB RIGHT+++++++++++++++++
    if(RobotContainer.operator.getRawAxis(5) > 0.0 || RobotContainer.operator.getRawAxis(5) < 0.0)
    {
      moveRight(RobotContainer.operator.getRawAxis(5) * 0.5);
    }
    // else
    // {
    //   stopRight();
    // }

    //++++++++++++++++CLIMB LEFT ++++++++++++++++++++
    if(RobotContainer.operator.getRawAxis(1) > 0.0 || RobotContainer.operator.getRawAxis(1) < 0.0)
    {
      moveLeft(RobotContainer.operator.getRawAxis(1) * 0.5);
    }
    // else 
    // {
    //   stopLeft();
    // }

    // +++++++++++++++++++ Left/Right climber motors. ++++++++++++++++++++++
    if(RobotContainer.operator.getRawButton(8))
    {
      moveTopRight();
    }
    else if(RobotContainer.operator.getRawButton(7))
    {
      moveTopLeft();
    }
    else 
    {
      stopTop();
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished()
  {
    return false;
  }
}
