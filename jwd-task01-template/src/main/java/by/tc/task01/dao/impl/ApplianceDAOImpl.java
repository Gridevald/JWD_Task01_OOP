package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DoubleFields;
import by.tc.task01.dao.IntegerFields;
import by.tc.task01.dao.StringFields;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        String name = criteria.getApplianceType();
        try (Scanner sc = new Scanner(new File("src/main/resources/appliances_db.txt"))) {
            while (sc.hasNextLine()) {
                Map<String, String> entityAsMap = parseLine(sc.nextLine());
                if (entityAsMap != null && name.equals(entityAsMap.get(StringFields.NAME.name()))) {
                    if (isSame(criteria, entityAsMap)) {
                        return createEntity(entityAsMap);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Read file error.");
        }
        return null;
    }

    private Map<String, String> parseLine(String line) {
        Map<String, String> result = null;
        if (!line.equals("")) {
            result = new HashMap<>();
            Matcher nameMatcher = Pattern.compile("[\\p{Alpha}]+(?=\\p{Blank}:)").matcher(line);
            if (nameMatcher.find()) {
                result.put(StringFields.NAME.name(), nameMatcher.group());
            }
            Matcher optionMatcher = Pattern.compile("[\\p{Upper}_]+=[\\p{Alnum}\\-\\.]+").matcher(line);
            while (optionMatcher.find()) {
                String[] temp = optionMatcher.group().split("=");
                result.put(temp[0], temp[1]);
            }
        }
        return result;
    }

    private <E> boolean isSame(Criteria<E> criteria, Map<String, String> line) {
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (IntegerFields.isInteger(entry.getKey().toString()) ||
                    DoubleFields.isDouble(entry.getKey().toString())) {
                if (!Double.valueOf(String.valueOf(entry.getValue()))
                        .equals(Double.valueOf(line.get(entry.getKey().toString())))) {
                    return false;
                }
            } else {
                if (!String.valueOf(entry.getValue()).trim()
                        .equalsIgnoreCase(line.get(entry.getKey().toString()))) {
                    return false;
                }
            }
        }
        return true;
    }

    private Appliance createEntity(Map<String, String> entityAsMap) {
        switch (entityAsMap.get(StringFields.NAME.name())) {
            case "Laptop":
                return createLaptop(entityAsMap);
            case "Oven":
                return createOven(entityAsMap);
            case "Refrigerator":
                return createRefrigerator(entityAsMap);
            case "Speakers":
                return createSpeakers(entityAsMap);
            case "TabletPC":
                return createTabletPC(entityAsMap);
            case "VacuumCleaner":
                return createVacuumCleaner(entityAsMap);
            default:
                return null;
        }

    }

    private Laptop createLaptop(Map<String, String> entityAsMap) {
        Laptop laptop = new Laptop();
        laptop.setBatteryCapacity(Double.valueOf(entityAsMap.get(DoubleFields.BATTERY_CAPACITY.name())));
        laptop.setOs(entityAsMap.get(StringFields.OS.name()));
        laptop.setMemoryRom(Integer.valueOf(entityAsMap.get(IntegerFields.MEMORY_ROM.name())));
        laptop.setSystemMemory(Integer.valueOf(entityAsMap.get(IntegerFields.SYSTEM_MEMORY.name())));
        laptop.setCpu(Double.valueOf(entityAsMap.get(DoubleFields.CPU.name())));
        laptop.setDisplayInches(Double.valueOf(entityAsMap.get(DoubleFields.DISPLAY_INCHS.name())));
        return laptop;
    }

    private Oven createOven(Map<String, String> entityAsMap) {
        Oven oven = new Oven();
        oven.setPowerConsumption(Integer.valueOf(entityAsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        oven.setWeight(Double.valueOf(entityAsMap.get(DoubleFields.WEIGHT.name())));
        oven.setCapacity(Double.valueOf(entityAsMap.get(DoubleFields.CAPACITY.name())));
        oven.setDepth(Double.valueOf(entityAsMap.get(DoubleFields.DEPTH.name())));
        oven.setHeight(Double.valueOf(entityAsMap.get(DoubleFields.HEIGHT.name())));
        oven.setWidth(Double.valueOf(entityAsMap.get(DoubleFields.WIDTH.name())));
        return oven;
    }

    private Refrigerator createRefrigerator(Map<String, String> entityAsMap) {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setPowerConsumption(Integer.valueOf(entityAsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        refrigerator.setWeight(Double.valueOf(entityAsMap.get(DoubleFields.WEIGHT.name())));
        refrigerator.setFreezerCapacity(Double.valueOf(entityAsMap.get(DoubleFields.FREEZER_CAPACITY.name())));
        refrigerator.setOverallCapacity(Double.valueOf(entityAsMap.get(DoubleFields.OVERALL_CAPACITY.name())));
        refrigerator.setHeight(Double.valueOf(entityAsMap.get(DoubleFields.HEIGHT.name())));
        refrigerator.setWidth(Double.valueOf(entityAsMap.get(DoubleFields.WIDTH.name())));
        return refrigerator;
    }

    private Speakers createSpeakers(Map<String, String> entityAsMap) {
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(Integer.valueOf(entityAsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        speakers.setNumberOfSpeakers(Integer.valueOf(entityAsMap.get(IntegerFields.NUMBER_OF_SPEAKERS.name())));
        speakers.setFrequencyRange(entityAsMap.get(StringFields.FREQUENCY_RANGE.name()));
        speakers.setCordLength(Double.valueOf(entityAsMap.get(DoubleFields.CORD_LENGTH.name())));
        return speakers;
    }

    private TabletPC createTabletPC(Map<String, String> entityAsMap) {
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(Double.valueOf(entityAsMap.get(DoubleFields.BATTERY_CAPACITY.name())));
        tabletPC.setDisplayInches(Double.valueOf(entityAsMap.get(DoubleFields.DISPLAY_INCHES.name())));
        tabletPC.setMemoryRom(Integer.valueOf(entityAsMap.get(IntegerFields.MEMORY_ROM.name())));
        tabletPC.setFlashMemoryCapacity(Integer.valueOf(entityAsMap.get(IntegerFields.FLASH_MEMORY_CAPACITY.name())));
        tabletPC.setColor(entityAsMap.get(StringFields.COLOR.name()));
        return tabletPC;
    }

    private VacuumCleaner createVacuumCleaner(Map<String, String> entityAsMap) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setPowerConsumption(Integer.valueOf(entityAsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        vacuumCleaner.setFilterType(entityAsMap.get(StringFields.FILTER_TYPE.name()));
        vacuumCleaner.setBagType(entityAsMap.get(StringFields.BAG_TYPE.name()));
        vacuumCleaner.setWandType(entityAsMap.get(StringFields.WAND_TYPE.name()));
        vacuumCleaner.setMotorSpeedRegulation(Integer.valueOf(entityAsMap.get(IntegerFields.MOTOR_SPEED_REGULATION.name())));
        vacuumCleaner.setCleaningWidth(Integer.valueOf(entityAsMap.get(IntegerFields.CLEANING_WIDTH.name())));
        return vacuumCleaner;
    }
}
