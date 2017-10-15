package by.tc.task01.service.validation;

import by.tc.task01.dao.DoubleFields;
import by.tc.task01.dao.IntegerFields;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates double and integer values
 */
public class Validator {

    /**
     * Validates value, if criteria key is integer or double field.
     */
    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        if (criteria.getCriteria().size() == 0) {
            return false;
        }
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (entry.getKey() == null) {
                return false;
            }
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
