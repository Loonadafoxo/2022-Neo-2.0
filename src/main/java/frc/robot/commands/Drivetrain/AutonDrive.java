// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutonDrive extends CommandBase {
  private final Drivetrain drivetrain;
  private Timer autonTimer;
  /** Creates a new AutonDrive. */
  public AutonDrive(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    addRequirements(this.drivetrain);
    autonTimer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    autonTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if(autonTimer.get() > 11){
    //   drivetrain.drive(.25, .25);
    // }
    // if(autonTimer.get() > 15){
    //  drivetrain.drive(0, 0);
    // }
    if(autonTimer.get() > 1){
      drivetrain.drive(-.25, -.25);
    }

    if(autonTimer.get() > 5){
      drivetrain.drive(.3, .3);
    }
    
    if(autonTimer.get() > 8){
      drivetrain.drive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
