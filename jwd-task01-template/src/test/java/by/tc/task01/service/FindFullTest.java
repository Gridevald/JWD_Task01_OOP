package by.tc.task01.service;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.impl.ApplianceServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FindFullTest {

    @Test
    public void laptopTest() {
        Criteria<SearchCriteria.Laptop> criteria = new Criteria<>();
        criteria.setApplianceType("Laptop");
        criteria.add(SearchCriteria.Laptop.BATTERY_CAPACITY, 1);
        criteria.add(SearchCriteria.Laptop.OS, "windows");
        criteria.add(SearchCriteria.Laptop.MEMORY_ROM, 4000);
        criteria.add(SearchCriteria.Laptop.SYSTEM_MEMORY, 1000);
        criteria.add(SearchCriteria.Laptop.CPU, 1.2);
        criteria.add(SearchCriteria.Laptop.DISPLAY_INCHS, 18);
        Appliance a = new ApplianceServiceImpl().find(criteria);
        assertTrue(a instanceof Laptop);
        System.out.println(a);
    }

    @Test
    public void ovenTest() {
        Criteria<SearchCriteria.Oven> criteria = new Criteria<>();
        criteria.setApplianceType("Oven");
        criteria.add(SearchCriteria.Oven.POWER_CONSUMPTION, 1000);
        criteria.add(SearchCriteria.Oven.WEIGHT, 10);
        criteria.add(SearchCriteria.Oven.CAPACITY, 32);
        criteria.add(SearchCriteria.Oven.DEPTH, 50);
        criteria.add(SearchCriteria.Oven.HEIGHT, 45.5);
        criteria.add(SearchCriteria.Oven.WIDTH, 59);
        Appliance a = new ApplianceServiceImpl().find(criteria);
        assertTrue(a instanceof Oven);
        System.out.println(a);
    }

    @Test
    public void refrigeratorTest() {
        Criteria<SearchCriteria.Refrigerator> criteria = new Criteria<>();
        criteria.setApplianceType("Refrigerator");
        criteria.add(SearchCriteria.Refrigerator.POWER_CONSUMPTION, 100);
        criteria.add(SearchCriteria.Refrigerator.WEIGHT, 20);
        criteria.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY, 10);
        criteria.add(SearchCriteria.Refrigerator.OVERALL_CAPACITY, 300);
        criteria.add(SearchCriteria.Refrigerator.HEIGHT, 200);
        criteria.add(SearchCriteria.Refrigerator.WIDTH, 70);
        Appliance a = new ApplianceServiceImpl().find(criteria);
        assertTrue(a instanceof Refrigerator);
        System.out.println(a);
    }

    @Test
    public void  speakersTest() {
        Criteria<SearchCriteria.Speakers> criteria = new Criteria<>();
        criteria.setApplianceType("Speakers");
        criteria.add(SearchCriteria.Speakers.POWER_CONSUMPTION, 15);
        criteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, 2);
        criteria.add(SearchCriteria.Speakers.FREQUENCY_RANGE, "2-4");
        criteria.add(SearchCriteria.Speakers.CORD_LENGTH, 2);
        Appliance a = new ApplianceServiceImpl().find(criteria);
        assertTrue(a instanceof Speakers);
        System.out.println(a);
    }

    @Test
    public void tabletPC() {
        Criteria<SearchCriteria.TabletPC> criteria = new Criteria<>();
        criteria.setApplianceType("TabletPC");
        criteria.add(SearchCriteria.TabletPC.BATTERY_CAPACITY, 3);
        criteria.add(SearchCriteria.TabletPC.DISPLAY_INCHES, 14);
        criteria.add(SearchCriteria.TabletPC.MEMORY_ROM, 8000);
        criteria.add(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY, 2);
        criteria.add(SearchCriteria.TabletPC.COLOR, "blue");
        Appliance a = new ApplianceServiceImpl().find(criteria);
        assertTrue(a instanceof TabletPC);
        System.out.println(a);
    }

    @Test
    public void vacuumCleaner() {
        Criteria<SearchCriteria.VacuumCleaner> criteria = new Criteria<>();
        criteria.setApplianceType("VacuumCleaner");
        criteria.add(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION, 100);
        criteria.add(SearchCriteria.VacuumCleaner.FILTER_TYPE, "a");
        criteria.add(SearchCriteria.VacuumCleaner.BAG_TYPE, "A2");
        criteria.add(SearchCriteria.VacuumCleaner.WAND_TYPE, "all-in-one");
        criteria.add(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION, 3000);
        criteria.add(SearchCriteria.VacuumCleaner.CLEANING_WIDTH, 20);
        Appliance a = new ApplianceServiceImpl().find(criteria);
        assertTrue(a instanceof VacuumCleaner);
        System.out.println(a);
    }
}
