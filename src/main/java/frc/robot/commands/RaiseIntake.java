// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.InternalSub;

public class RaiseIntake extends CommandBase {
  /** Creates a new RaiseIntake. */

  InternalSub in;

  public RaiseIntake(InternalSub internalSub) 
  {
    // Use addRequirements() here to declare subsystem dependencies.

    in = internalSub;
    addRequirements(internalSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    in.raiseIntake();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) 
  {
    in.stopLift();
  }

  @Override
  public boolean isFinished()
  {
    return true;
  }
}
