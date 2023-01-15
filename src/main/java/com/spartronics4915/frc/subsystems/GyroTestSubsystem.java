package com.spartronics4915.frc.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static com.spartronics4915.frc.Constants.GyroTest.*;

import com.ctre.phoenix.sensors.Pigeon2;

public class GyroTestSubsystem extends SubsystemBase {
    private static GyroTestSubsystem mInstance;
    
    private final CANSparkMax mMotor;
    private final Pigeon2 mIMU;

    private final RelativeEncoder mEncoder;
    private final SparkMaxPIDController mMotorPIDController;

    private final PIDController mVelocityPIDController;

    private double mTargetVelocity;

    private GyroTestSubsystem() {
        mMotor = kMotorConstructor.apply(kMotorID);
        mIMU = new Pigeon2(kPigeonID);

        mEncoder = mMotor.getEncoder();
        mEncoder.setPositionConversionFactor(kPositionConversionFactor);
        mEncoder.setVelocityConversionFactor(kVelocityConversionFactor);

        mMotorPIDController = mMotor.getPIDController();
        mMotorPIDController.setP(MotorPID.kP);
        mMotorPIDController.setI(MotorPID.kI);
        mMotorPIDController.setD(MotorPID.kD);

        mVelocityPIDController = new PIDController(VelocityPID.kP, VelocityPID.kI, VelocityPID.kD);
        mVelocityPIDController.setSetpoint(0);

        mTargetVelocity = 0;
    }

    public static GyroTestSubsystem getInstance() {
        if (mInstance == null) {
            mInstance = new GyroTestSubsystem();
        }
        return mInstance;
    }

    public double getPitch() {
        return mIMU.getPitch();
    }

    public double calculateTargetVelocity() {
        return mVelocityPIDController.calculate(getPitch());
    }

    // public CommandBase getTeleopCommand() {
    //     return runOnce(
    //         () -> {
                
    //         }
    //     );
    // }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("target velocity", calculateTargetVelocity());
    }
}
