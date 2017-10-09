package by.tc.task01.dao;

import by.tc.task01.dao.impl.ApplianceDAOImpl;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FindTest {

    @Test
    public void testOne() {
        ApplianceDAOImpl a = new ApplianceDAOImpl();
        Criteria<SearchCriteria.Oven> criteriaOven = new Criteria<>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(SearchCriteria.Oven.WEIGHT, 10);
        Appliance apl = a.find(criteriaOven);
        assertTrue(apl != null);
        System.out.println(apl);
    }

    @Test
    public void testTwo() {
        ApplianceDAOImpl a = new ApplianceDAOImpl();
        Criteria<SearchCriteria.Oven> criteriaOven = new Criteria<>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(SearchCriteria.Oven.WEIGHT, 5);
        Appliance apl = a.find(criteriaOven);
        assertTrue(apl == null);
    }

    @Test
    public void testThree() {
        ApplianceDAOImpl a = new ApplianceDAOImpl();
        Criteria<SearchCriteria.Speakers> criteria = new Criteria<>();
        criteria.setApplianceType("Speakers");
        criteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, 2);
        criteria.add(SearchCriteria.Speakers.POWER_CONSUMPTION, 15);
        Appliance apl = a.find(criteria);
        assertTrue(apl != null);
    }

    @Test
    public void testFour() {
        ApplianceDAOImpl a = new ApplianceDAOImpl();
        Criteria<SearchCriteria.Speakers> criteria = new Criteria<>();
        criteria.setApplianceType("Speakers");
        criteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, 5);
        criteria.add(SearchCriteria.Speakers.POWER_CONSUMPTION, 15);
        Appliance apl = a.find(criteria);
        assertFalse(apl != null);
    }
}
