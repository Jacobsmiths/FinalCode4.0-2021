// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.InternalSub;

public class Intake extends CommandBase {
  /** Creates a new Intake. */
  InternalSub in;

  public Intake(InternalSub internalSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    in = internalSub;

    addRequirements(internalSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {   
    in.indexerOn();
    in.intakeOn();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    in.intakeOff();
    in.indexerOff();
  }

  // DELETED IS FINISHED BECAUSE THIS IS BINDED TO A BUTTON
  @Override
  public boolean isFinished()
  {
    return true;
  }
}
