// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.InternalSub;
import frc.robot.subsystems.LimelightSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoRun1 extends SequentialCommandGroup {
  /** Creates a new AutoRun1. */
  public AutoRun1(InternalSub internalSub, DriveTrainSub drive, LimelightSub lime) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new LowerIntakeAuto(internalSub, 80), 
      new AimAuto(drive, lime),
      new ShootAuto(internalSub, 40),
      new MoveAuto(drive, 30)
      );
  }
}
