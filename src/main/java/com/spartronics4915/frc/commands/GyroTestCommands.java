package com.spartronics4915.frc.commands;

import com.spartronics4915.frc.subsystems.GyroTestSubsystem;

public class GyroTestCommands {
    private final GyroTestSubsystem mGyroTestSubsystem;
    
    public GyroTestCommands() {
        mGyroTestSubsystem = GyroTestSubsystem.getInstance();
    }
}
