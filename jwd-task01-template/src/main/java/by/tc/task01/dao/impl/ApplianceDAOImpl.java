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
                Map<String, String> fieldsMap = parseLine(sc.nextLine());
                if (fieldsMap != null && name.equals(fieldsMap.get(StringFields.NAME.name()))) {
                    if (isMatches(criteria, fieldsMap)) {
                        return createEntity(fieldsMap);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Read file error.");
        }
        return null;
    }

    private Map<String, String> parseLine(String line) {
        Map<String, String> fieldsMap = null;
        if (!line.equals("")) {
            fieldsMap = new HashMap<>();
            Matcher nameMatcher = Pattern.compile("[\\p{Alpha}]+(?=\\p{Blank}:)").matcher(line);
            if (nameMatcher.find()) {
                fieldsMap.put(StringFields.NAME.name(), nameMatcher.group());
            }
            Matcher optionMatcher = Pattern.compile("[\\p{Upper}_]+=[\\p{Alnum}\\-\\.]+").matcher(line);
            while (optionMatcher.find()) {
                String[] temp = optionMatcher.group().split("=");
                fieldsMap.put(temp[0], temp[1]);
            }
        }
        return fieldsMap;
    }

    private <E> boolean isMatches(Criteria<E> criteria, Map<String, String> fieldsMap) {
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (IntegerFields.isInteger(entry.getKey().toString()) ||
                    DoubleFields.isDouble(entry.getKey().toString())) {
                if (!Double.valueOf(String.valueOf(entry.getValue()))
                        .equals(Double.valueOf(fieldsMap.get(entry.getKey().toString())))) {
                    return false;
                }
            } else {
                if (!String.valueOf(entry.getValue()).trim()
                        .equalsIgnoreCase(fieldsMap.get(entry.getKey().toString()))) {
                    return false;
                }
            }
        }
        return true;
    }

    private Appliance createEntity(Map<String, String> fieldsMap) {
        switch (fieldsMap.get(StringFields.NAME.name())) {
            case "Laptop":
                return createLaptop(fieldsMap);
            case "Oven":
                return createOven(fieldsMap);
            case "Refrigerator":
                return createRefrigerator(fieldsMap);
            case "Speakers":
                return createSpeakers(fieldsMap);
            case "TabletPC":
                return createTabletPC(fieldsMap);
            case "VacuumCleaner":
                return createVacuumCleaner(fieldsMap);
            default:
                return null;
        }

    }

    private Laptop createLaptop(Map<String, String> fieldsMap) {
        Laptop laptop = new Laptop();
        laptop.setBatteryCapacity(Double.valueOf(fieldsMap.get(DoubleFields.BATTERY_CAPACITY.name())));
        laptop.setOs(fieldsMap.get(StringFields.OS.name()));
        laptop.setMemoryRom(Integer.valueOf(fieldsMap.get(IntegerFields.MEMORY_ROM.name())));
        laptop.setSystemMemory(Integer.valueOf(fieldsMap.get(IntegerFields.SYSTEM_MEMORY.name())));
        laptop.setCpu(Double.valueOf(fieldsMap.get(DoubleFields.CPU.name())));
        laptop.setDisplayInches(Double.valueOf(fieldsMap.get(DoubleFields.DISPLAY_INCHS.name())));
        return laptop;
    }

    private Oven createOven(Map<String, String> fieldsMap) {
        Oven oven = new Oven();
        oven.setPowerConsumption(Integer.valueOf(fieldsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        oven.setWeight(Double.valueOf(fieldsMap.get(DoubleFields.WEIGHT.name())));
        oven.setCapacity(Double.valueOf(fieldsMap.get(DoubleFields.CAPACITY.name())));
        oven.setDepth(Double.valueOf(fieldsMap.get(DoubleFields.DEPTH.name())));
        oven.setHeight(Double.valueOf(fieldsMap.get(DoubleFields.HEIGHT.name())));
        oven.setWidth(Double.valueOf(fieldsMap.get(DoubleFields.WIDTH.name())));
        return oven;
    }

    private Refrigerator createRefrigerator(Map<String, String> fieldsMap) {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setPowerConsumption(Integer.valueOf(fieldsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        refrigerator.setWeight(Double.valueOf(fieldsMap.get(DoubleFields.WEIGHT.name())));
        refrigerator.setFreezerCapacity(Double.valueOf(fieldsMap.get(DoubleFields.FREEZER_CAPACITY.name())));
        refrigerator.setOverallCapacity(Double.valueOf(fieldsMap.get(DoubleFields.OVERALL_CAPACITY.name())));
        refrigerator.setHeight(Double.valueOf(fieldsMap.get(DoubleFields.HEIGHT.name())));
        refrigerator.setWidth(Double.valueOf(fieldsMap.get(DoubleFields.WIDTH.name())));
        return refrigerator;
    }

    private Speakers createSpeakers(Map<String, String> fieldsMap) {
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(Integer.valueOf(fieldsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        speakers.setNumberOfSpeakers(Integer.valueOf(fieldsMap.get(IntegerFields.NUMBER_OF_SPEAKERS.name())));
        speakers.setFrequencyRange(fieldsMap.get(StringFields.FREQUENCY_RANGE.name()));
        speakers.setCordLength(Double.valueOf(fieldsMap.get(DoubleFields.CORD_LENGTH.name())));
        return speakers;
    }

    private TabletPC createTabletPC(Map<String, String> fieldsMap) {
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(Double.valueOf(fieldsMap.get(DoubleFields.BATTERY_CAPACITY.name())));
        tabletPC.setDisplayInches(Double.valueOf(fieldsMap.get(DoubleFields.DISPLAY_INCHES.name())));
        tabletPC.setMemoryRom(Integer.valueOf(fieldsMap.get(IntegerFields.MEMORY_ROM.name())));
        tabletPC.setFlashMemoryCapacity(Integer.valueOf(fieldsMap.get(IntegerFields.FLASH_MEMORY_CAPACITY.name())));
        tabletPC.setColor(fieldsMap.get(StringFields.COLOR.name()));
        return tabletPC;
    }

    private VacuumCleaner createVacuumCleaner(Map<String, String> fieldsMap) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setPowerConsumption(Integer.valueOf(fieldsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        vacuumCleaner.setFilterType(fieldsMap.get(StringFields.FILTER_TYPE.name()));
        vacuumCleaner.setBagType(fieldsMap.get(StringFields.BAG_TYPE.name()));
        vacuumCleaner.setWandType(fieldsMap.get(StringFields.WAND_TYPE.name()));
        vacuumCleaner.setMotorSpeedRegulation(Integer.valueOf(fieldsMap.get(IntegerFields.MOTOR_SPEED_REGULATION.name())));
        vacuumCleaner.setCleaningWidth(Integer.valueOf(fieldsMap.get(IntegerFields.CLEANING_WIDTH.name())));
        return vacuumCleaner;
    }
}
