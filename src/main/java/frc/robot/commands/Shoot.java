// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.InternalSub;

public class Shoot extends CommandBase {
  /** Creates a new Shoot. */

  InternalSub in;

  public Shoot(InternalSub internalSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    in = internalSub;

    addRequirements(internalSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    double d = RobotContainer.distance;

    //FIRST DISTANCE
    if (d < 100 && d >= 0)
    { 
      in.shoot(1.0); // fly wheel speed
      in.indexerOnBy(.8); // this will run the indexer
    }
    // SECOND DISTANCE
    if (d < 140 && d > 100)
    { 
      in.shoot(0.75); // fly wheel speed
        in.indexerOnBy(.9); // this will run the indexer
    }
    // THID DISTANCE
    if (d < 165 && d >= 140)
    { 
      in.shoot(0.75); // fly wheel speed
      in.indexerOnBy(.4); // this will run the index
    }
    // FOURTH DISTANCE
    if (d < 175 && d >= 165)
    { 
      in.shoot(0.82); // fly wheel speed
      in.indexerOnBy(.4); // this will run the indexer
    }
    
    // FIFTH DISTANCE
    if (d <=  200 && d >= 175 )
    { 
      in.shoot(0.84); // fly wheel speed
      in.indexerOnBy(.35); // this will run the indexer
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  public boolean checkRPM(double rpm)
  {
    return (in.getVelocity() > rpm);
  }

  @Override
  public void execute() // IF THIS DOESNT WORK: REMOVE CHECK RPM AND MOVE INTO INITIALIZE
  {
    // double d = RobotContainer.distance;

    // //FIRST DISTANCE
    // if (d < 100 && d >= 0)
    // { 
    //   in.shoot(1.0); // fly wheel speed
    //   if (checkRPM(3000.0)) // check rpm
    //   {
    //     in.indexerOnBy(.8); // this will run the indexer
    //   } 
    // }
    // // SECOND DISTANCE
    // if (d < 140 && d > 100)
    // { 
    //   in.shoot(0.75); // fly wheel speed
    //   if (checkRPM(3000.0)) // check rpm
    //   {
    //     in.indexerOnBy(.9); // this will run the indexer
    //   } 
    // }
    // // THID DISTANCE
    // if (d < 165 && d >= 140)
    // { 
    //   in.shoot(0.75); // fly wheel speed
    //   if (checkRPM(3000.0)) // check rpm
    //   {
    //     in.indexerOnBy(.4); // this will run the indexer
    //   } 
    // }
    // // FOURTH DISTANCE
    // if (d < 175 && d >= 165)
    // { 
    //   in.shoot(0.82); // fly wheel speed
    //   if (checkRPM(3000.0)) // check rpm
    //   {
    //     in.indexerOnBy(.4); // this will run the indexer
    //   } 
    // }
    
    // // FIFTH DISTANCE
    // if (d <=  200 && d >= 175 )
    // { 
    //   in.shoot(0.84); // fly wheel speed
    //   if (checkRPM(3000.0)) // check rpm
    //   {
    //     in.indexerOnBy(.35); // this will run the indexer
    //   } 
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    in.stopShooting();
    in.indexerOff();
  }
 
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
