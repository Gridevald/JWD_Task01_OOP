package by.tc.task01.dao.command;

import by.tc.task01.dao.DoubleFields;
import by.tc.task01.dao.IntegerFields;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;

import java.util.Map;

public class RefrigeratorCreator implements EntityCreator {

    @Override
    public Appliance create(Map<String, String> fieldsMap) {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setPowerConsumption(Integer.valueOf(fieldsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        refrigerator.setWeight(Double.valueOf(fieldsMap.get(DoubleFields.WEIGHT.name())));
        refrigerator.setFreezerCapacity(Double.valueOf(fieldsMap.get(DoubleFields.FREEZER_CAPACITY.name())));
        refrigerator.setOverallCapacity(Double.valueOf(fieldsMap.get(DoubleFields.OVERALL_CAPACITY.name())));
        refrigerator.setHeight(Double.valueOf(fieldsMap.get(DoubleFields.HEIGHT.name())));
        refrigerator.setWidth(Double.valueOf(fieldsMap.get(DoubleFields.WIDTH.name())));
        return refrigerator;
    }
}
