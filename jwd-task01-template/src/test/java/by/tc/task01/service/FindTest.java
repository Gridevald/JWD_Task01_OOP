package by.tc.task01.service;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.main.PrintApplianceInfo;
import by.tc.task01.service.impl.ApplianceServiceImpl;
import org.junit.Test;

public class FindTest {

    @Test
    public void testOne() {
        ApplianceServiceImpl a = new ApplianceServiceImpl();
        Criteria<SearchCriteria.TabletPC> criteria = new Criteria<>();
        criteria.add(SearchCriteria.TabletPC.COLOR, "BLUE");
        PrintApplianceInfo.print(a.find(criteria));
    }

    @Test
    public void findFirstInFile() {
        Criteria<SearchCriteria.Oven> criteria = new Criteria<>();
        criteria.add(SearchCriteria.Oven.POWER_CONSUMPTION, 1000);
        PrintApplianceInfo.print(new ApplianceServiceImpl().find(criteria));
    }
}
