package by.tc.task01.service;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.Validator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void testOne() {
        Criteria<SearchCriteria.Oven> criteriaOven = new Criteria<>();
        criteriaOven.add(SearchCriteria.Oven.CAPACITY, 3);
        assertTrue(Validator.criteriaValidator(criteriaOven));
    }

    @Test
    public void testTwo() {
        Criteria<SearchCriteria.Speakers> criteria = new Criteria<>();
        criteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, 2);
        assertTrue(Validator.criteriaValidator(criteria));
    }

    @Test
    public void testThree() {
        Criteria<SearchCriteria.Speakers> criteria = new Criteria<>();
        criteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, 2.5);
        assertFalse(Validator.criteriaValidator(criteria));
    }

    @Test
    public void testFour() {
        Criteria<SearchCriteria.TabletPC> criteriaTabletPC = new Criteria<>();
        criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR, "BLUE");
        criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES, 14);
        criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM, 4);
        assertTrue(Validator.criteriaValidator(criteriaTabletPC));
    }

    @Test
    public void testFive() {
        Criteria<SearchCriteria.Oven> criteriaOven = new Criteria<>();
        criteriaOven.add(SearchCriteria.Oven.HEIGHT, "not valid value");
        criteriaOven.add(SearchCriteria.Oven.DEPTH, 300);
        assertFalse(Validator.criteriaValidator(criteriaOven));
    }
}
