// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoRun1;
import frc.robot.commands.Climb;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Index;
import frc.robot.commands.Intake;
import frc.robot.commands.LowerIntake;
import frc.robot.commands.RaiseIntake;
import frc.robot.commands.ReverseIntake;
import frc.robot.commands.ShootCommandGroup;
import frc.robot.subsystems.ClimbSub;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.InternalSub;
import frc.robot.subsystems.LimelightSub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);


  // +++++++++++ JoySticks ++++++++++++++
  public final static Joystick driver = new Joystick(0);  //creates the controller
  public final static Joystick operator = new Joystick(1);//logitech gamepad

  // ++++++++++++++ SUBSYSTEMS ++++++++++++++
  private final static InternalSub internalSub = new InternalSub();
  private final static LimelightSub limelightSub = new LimelightSub();
  private final static ClimbSub climbSub = new ClimbSub();
  private final static DriveTrainSub driveSub = new DriveTrainSub();

  // +++++++++++++++ TEMPORARY ++++++++++++++++++
  public static double distance = limelightSub.getDistance();

  // ++++++++++++++ COMMANDS +++++++++++++++++++++++
  private final AutoRun1 autoCommand = new AutoRun1(internalSub, driveSub, limelightSub);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    driveSub.setDefaultCommand(new Drive(driveSub));
    climbSub.setDefaultCommand(new Climb(climbSub));

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {

    final JoystickButton intakeButton = new JoystickButton(operator, 2);
    final JoystickButton indexButton = new JoystickButton(operator, 4);
    final JoystickButton reverseIntakeButton = new JoystickButton(operator, 3);
    final JoystickButton raiseIntakeButton = new JoystickButton(driver, 8);
    final JoystickButton lowerIntakeButton = new JoystickButton(driver, 7);
    // final JoystickButton shootButton = new JoystickButton(operator, 1);

    intakeButton.whileActiveContinuous(new Intake(internalSub), false);
    reverseIntakeButton.whileActiveContinuous(new ReverseIntake(internalSub), false);
    raiseIntakeButton.whileActiveContinuous(new RaiseIntake(internalSub));
    lowerIntakeButton.whileActiveContinuous(new LowerIntake(internalSub));
    // shootButton.whileActiveContinuous(new ShootCommandGroup(limelightSub, driveSub, internalSub));
    indexButton.whileActiveContinuous(new Index(internalSub), false);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
