// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private VictorSPX leftFront;
  private VictorSPX leftBack;
  private VictorSPX rightFront;
  private VictorSPX rightBack;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftFront = new VictorSPX(1);
    leftFront.setInverted(true);
    leftBack = new VictorSPX(2);
    leftBack.setInverted(true);
    rightFront = new VictorSPX(3);
    rightBack = new VictorSPX(4);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double leftPower, double rightPower){
    leftFront.set(VictorSPXControlMode.PercentOutput, leftPower);
    leftBack.set(VictorSPXControlMode.PercentOutput, leftPower);
    rightFront.set(VictorSPXControlMode.PercentOutput, rightPower);
    rightBack.set(VictorSPXControlMode.PercentOutput, rightPower);
  }
}
