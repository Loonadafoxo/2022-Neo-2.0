// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Triggers.LeftTriggerDown;
import frc.robot.Triggers.LeftTriggerUp;
import frc.robot.Triggers.RightTriggerDown;
import frc.robot.Triggers.RightTriggerUp;
import frc.robot.commands.Arms.LowerArms;
import frc.robot.commands.Arms.RaiseArms;
import frc.robot.commands.Arms.StopArms;
import frc.robot.commands.Climb.IdleClimb;
import frc.robot.commands.Climb.LowerClimb;
import frc.robot.commands.Climb.RaiseClimb;
import frc.robot.commands.Drivetrain.Drive;
import frc.robot.commands.Shooter.IdleShooter;
import frc.robot.commands.Shooter.PickUp;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Arms;
import frc.robot.subsystems.Climb;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public final Drivetrain m_drivetrain;
  public final Arms m_arms;
  public final Intake m_intake;
  public final Climb m_climb;



  public final XboxController controller = new XboxController(0);

  //Don't worry about these
  private Trigger rightTriggerDown = new RightTriggerDown(controller);
  private Trigger leftTriggerDown = new LeftTriggerDown(controller);
  private Trigger rightTriggerUp = new RightTriggerUp(controller);
  private Trigger leftTriggerUp = new LeftTriggerUp(controller);

  public RobotContainer() {
    //Defining the subsystems
    m_drivetrain = new Drivetrain();
    m_intake = new Intake();
    m_arms = new Arms();
    m_climb = new Climb();

    //If no code is saying otherwise, the drivetrain will listen to the controller, arms will not move, the shooter will not move, and the climb will not climb
    m_drivetrain.setDefaultCommand(new Drive(m_drivetrain, controller));
    m_arms.setDefaultCommand(new StopArms(m_arms));
    m_intake.setDefaultCommand(new IdleShooter(m_intake));
    m_climb.setDefaultCommand(new IdleClimb(m_climb));

    //sets the controls
    configureButtonBindings();
  }

  //controls are set here
  private void configureButtonBindings() {

    //Shoot the balls
    new Button(controller::getLeftBumper).whenHeld(new Shoot(m_intake));

    //Pick Up balls
    new Button(controller::getRightBumper).whenHeld(new PickUp(m_intake));

    //Raise the arms
    leftTriggerDown.whenActive(new RaiseArms(m_arms));

    //Lower the arms
    rightTriggerDown.whenActive(new LowerArms(m_arms));

    //CLIMB!
    new Button(controller::getAButton).whenHeld(new LowerClimb(m_climb));

    //Reset the climb
    new Button(controller::getYButton).whenHeld(new RaiseClimb(m_climb));

    //Don't worry about these they're only here cause wpi is stupid
    rightTriggerUp.whenActive(new StopArms(m_arms));
    leftTriggerUp.whenActive(new StopArms(m_arms));
  }

}
