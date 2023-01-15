// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.spartronics4915.frc;

import java.util.function.Function;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class GyroTest {
        public static final int kMotorID = 1;
        public static final int kPigeonID = 9;

        public static final Function<Integer, CANSparkMax> kMotorConstructor = (Integer ID) -> { return new CANSparkMax(ID, MotorType.kBrushless); };

        public static final double kMaxVelocityRPM = 5676;
        public static final double kMaxVelocity = kMaxVelocityRPM * (1 / 60) * (2 * Math.PI);
        public static final double kVelocityConversionFactor = (1 / 60) * (2 * Math.PI);

        public static final double kPositionConversionFactor = (2 * Math.PI);

        public static class MotorPID {
            public static final double kP = 1.675e-3;
            public static final double kI = 0.0;
            public static final double kD = 0.001;
        }

        public static class VelocityPID {
            public static final double kP = 0.01;
            public static final double kI = 0.0;
            public static final double kD = 0.0;
        }
    }
    
    public static class OperatorConstants {
        public static final int kDriverControllerPort = 0;
    }
}
