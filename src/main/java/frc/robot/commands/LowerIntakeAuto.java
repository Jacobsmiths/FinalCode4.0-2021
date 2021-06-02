// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.InternalSub;

public class LowerIntakeAuto extends CommandBase {
  /** Creates a new LowerIntakeAuto. */
  InternalSub in;
  int distance;
  public LowerIntakeAuto(InternalSub internalSub, int d) {
    // Use addRequirements() here to declare subsystem dependencies.
    in = internalSub;
    distance = d;
    addRequirements(internalSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    in.lowerIntake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    in.stopLift();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (in.getLiftEnc()>distance);
  }
}
