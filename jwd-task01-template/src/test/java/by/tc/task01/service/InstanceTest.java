package by.tc.task01.service;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.impl.ApplianceServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InstanceTest {

    @Test
    public void laptopTest() {
        Criteria<SearchCriteria.Laptop> criteria = new Criteria<>();
        criteria.add(SearchCriteria.Laptop.DISPLAY_INCHS, 18);
        assertTrue(new ApplianceServiceImpl().find(criteria) instanceof Laptop);
    }

    @Test
    public void ovenTest() {
        Criteria<SearchCriteria.Oven> criteria = new Criteria<>();
        criteria.add(SearchCriteria.Oven.WEIGHT, 10);
        assertTrue(new ApplianceServiceImpl().find(criteria) instanceof Oven);
    }

    @Test
    public void refrigeratorTest() {
        Criteria<SearchCriteria.Refrigerator> criteria = new Criteria<>();
        criteria.add(SearchCriteria.Refrigerator.WIDTH, 75);
        assertTrue(new ApplianceServiceImpl().find(criteria) instanceof Refrigerator);
    }

    @Test
    public void  speakersTest() {
        Criteria<SearchCriteria.Speakers> criteria = new Criteria<>();
        criteria.add(SearchCriteria.Speakers.FREQUENCY_RANGE, "3-4");
        assertTrue(new ApplianceServiceImpl().find(criteria) instanceof Speakers);
    }

    @Test
    public void tabletPC() {
        Criteria<SearchCriteria.TabletPC> criteria = new Criteria<>();
        criteria.add(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY, 8);
        assertTrue(new ApplianceServiceImpl().find(criteria) instanceof TabletPC);
    }

    @Test
    public void vacuumCleaner() {
        Criteria<SearchCriteria.VacuumCleaner> criteria = new Criteria<>();
        criteria.add(SearchCriteria.VacuumCleaner.BAG_TYPE, "aa-89");
        assertTrue(new ApplianceServiceImpl().find(criteria) instanceof VacuumCleaner);
    }
}
