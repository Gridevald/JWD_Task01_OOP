package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DoubleFields;
import by.tc.task01.dao.IntegerFields;
import by.tc.task01.dao.StringFields;
import by.tc.task01.dao.command.ApplianceHandler;
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

    private static final String NAME_REGEX = "[\\p{Alpha}]+(?=\\p{Blank}:)";

    private static final String OPTION_REGEX = "[\\p{Upper}_]+=[\\p{Alnum}\\-\\.]+";

    private static final String SPLIT_REGEX = "=";

    private static final int NAME_INDEX = 0;

    private static final int VALUE_INDEX = 1;

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        String name = criteria.getApplianceType();
        try (Scanner sc = new Scanner(new File(getClass()
                .getClassLoader()
                .getResource("appliances_db.txt")
                .getFile()))) {
            while (sc.hasNextLine()) {
                Map<String, String> fieldsMap = parseLine(sc.nextLine());
                if (fieldsMap != null && name.equals(fieldsMap.get(StringFields.NAME.name()))) {
                    if (isMatches(criteria, fieldsMap)) {
                        return ApplianceHandler.getCreator(name).create(fieldsMap);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Read file error.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates Map, witch contains pairs of entity fields and it's values
     */
    private Map<String, String> parseLine(String line) {
        Map<String, String> fieldsMap = null;

        if (!line.isEmpty()) {
            fieldsMap = new HashMap<>();

            Matcher nameMatcher = Pattern.compile(NAME_REGEX).matcher(line);
            if (nameMatcher.find()) {
                fieldsMap.put(StringFields.NAME.name(), nameMatcher.group());
            }

            Matcher optionMatcher = Pattern.compile(OPTION_REGEX).matcher(line);

            while (optionMatcher.find()) {
                String[] temp = optionMatcher.group().split(SPLIT_REGEX);
                fieldsMap.put(temp[NAME_INDEX], temp[VALUE_INDEX]);
            }
        }
        return fieldsMap;
    }

    /**
     * Finds out if given entity matches given criteria
     */
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
}
