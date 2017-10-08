package by.tc.task01.dao;

import java.util.HashSet;
import java.util.Set;

public enum IntegerFields {
    POWER_CONSUMPTION,
    MEMORY_ROM,
    SYSTEM_MEMORY,
    FLASH_MEMORY_CAPACITY,
    MOTOR_SPEED_REGULATION,
    CLEANING_WIDTH,
    NUMBER_OF_SPEAKERS;

    private static final Set<String> CHECK = new HashSet<>();

    static {
        CHECK.add(POWER_CONSUMPTION.name());
        CHECK.add(MEMORY_ROM.name());
        CHECK.add(SYSTEM_MEMORY.name());
        CHECK.add(FLASH_MEMORY_CAPACITY.name());
        CHECK.add(MOTOR_SPEED_REGULATION.name());
        CHECK.add(CLEANING_WIDTH.name());
        CHECK.add(NUMBER_OF_SPEAKERS.name());
    }

    public static boolean isInteger(String key) {
        return CHECK.contains(key);
    }
}
