package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

    private Map<E, Object> criteria = new HashMap<>();

    public void add(E searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public Map<E, Object> getAsMap() {
        return criteria;
    }

    // you may add your own code here
}
