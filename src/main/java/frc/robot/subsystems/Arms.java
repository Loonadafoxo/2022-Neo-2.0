// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arms extends SubsystemBase {
  private VictorSPX leftIntake;
  private VictorSPX rightIntake;

  /** Creates a new Intake. */
  public Arms() {
    leftIntake = new VictorSPX(5);
    leftIntake.setNeutralMode(NeutralMode.Brake);
    rightIntake = new VictorSPX(6);
    rightIntake.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void powerMotors(double power){
    leftIntake.set(VictorSPXControlMode.PercentOutput, -power);
    rightIntake.set(VictorSPXControlMode.PercentOutput, power);
  }

}
