// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.InternalSub;

public class ReverseIntake extends CommandBase {
  /** Creates a new ReverseIntake. */

  InternalSub in;

  public ReverseIntake(InternalSub internalSub) 
  {    
    // Use addRequirements() here to declare subsystem dependencies.
    in = internalSub;
    addRequirements(internalSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    in.intakeReverse();
  }

  // GOT RID OF EXECUTE CUZ THERE IS NO POINT
  @Override
  public void execute()
  {
    in.indexerReverse();
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    in.indexerOff();
    in.intakeOff();
  }
  @Override
  public boolean isFinished()
  {
    return true;
  }
  //DELETED IS FNISHED CUZ IT IS BINDED TO A BUTTON
}
