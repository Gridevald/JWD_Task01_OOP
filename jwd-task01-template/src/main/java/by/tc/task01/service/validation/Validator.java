package by.tc.task01.service.validation;

import by.tc.task01.dao.DoubleFields;
import by.tc.task01.dao.IntegerFields;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (DoubleFields.isDouble(entry.getKey().toString())) {
                if (!validateDouble(entry.getValue())) {
                    return false;
                }
            } else {
                if (IntegerFields.isInteger(entry.getKey().toString())) {
                    if (!validateInteger(entry.getValue())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean validateDouble(Object object) {
        Matcher matcher = Pattern.compile("[\\p{Digit}]+(\\.[\\p{Digit}]+)?").matcher(String.valueOf(object));
        return matcher.matches();
    }

    private static boolean validateInteger(Object object) {
        Matcher matcher = Pattern.compile("[\\p{Digit}]+").matcher(String.valueOf(object));
        return matcher.matches();
    }
}
