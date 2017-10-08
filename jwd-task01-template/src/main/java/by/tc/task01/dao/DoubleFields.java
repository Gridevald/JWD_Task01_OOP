package by.tc.task01.dao;

import java.util.HashSet;
import java.util.Set;

public enum DoubleFields {
    WEIGHT,
    DEPTH,
    HEIGHT,
    WIDTH,
    CAPACITY,
    BATTERY_CAPACITY,
    CPU,
    FREEZER_CAPACITY,
    OVERALL_CAPACITY,
    DISPLAY_INCHS,
    DISPLAY_INCHES,
    CORD_LENGTH;

    private static final Set<String> CHECK = new HashSet<>();

    static {
        CHECK.add(WEIGHT.name());
        CHECK.add(DEPTH.name());
        CHECK.add(HEIGHT.name());
        CHECK.add(WIDTH.name());
        CHECK.add(CAPACITY.name());
        CHECK.add(BATTERY_CAPACITY.name());
        CHECK.add(CPU.name());
        CHECK.add(FREEZER_CAPACITY.name());
        CHECK.add(OVERALL_CAPACITY.name());
        CHECK.add(DISPLAY_INCHS.name());
        CHECK.add(DISPLAY_INCHES.name());
        CHECK.add(CORD_LENGTH.name());
    }

    public static boolean isDouble(String key) {
        return CHECK.contains(key);
    }
}
