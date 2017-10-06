package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static List<String> optionList = new ArrayList<>();

    static {
        //TODO: fill list with options to check
        optionList.add(SearchCriteria.Oven.POWER_CONSUMPTION.name());
        optionList.add(SearchCriteria.Oven.WEIGHT.name());
        optionList.add(SearchCriteria.Oven.CAPACITY.name());
        optionList.add(SearchCriteria.Oven.DEPTH.name());
        optionList.add(SearchCriteria.Oven.HEIGHT.name());
        optionList.add(SearchCriteria.Oven.WIDTH.name());


    }

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        // you may add your own code here
        for (Map.Entry<E, Object> entry : criteria.getAsMap().entrySet()) {
            if (optionList.contains(entry.getKey())) {
                if (!validateNumber(entry.getValue())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validateNumber(Object object) {
            //TODO: enter validation
        Matcher matcher = Pattern.compile("[\\p{Digit}]+(\\.[\\p{Digit}]+)?").matcher((String) object);
        return matcher.matches();
    }

}

//you may add your own new classes