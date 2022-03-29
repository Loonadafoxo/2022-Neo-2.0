// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private VictorSPX intake;
  /** Creates a new Intake. */
  public Intake() {
    intake = new VictorSPX(7);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void powerIntake(double power){
    intake.set(VictorSPXControlMode.PercentOutput, power);
  }
}
