package by.tc.task01.dao.command;

import by.tc.task01.dao.DoubleFields;
import by.tc.task01.dao.IntegerFields;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;

import java.util.Map;

public class OvenCreator implements EntityCreator {

    @Override
    public Appliance create(Map<String, String> fieldsMap) {
        Oven oven = new Oven();
        oven.setPowerConsumption(Integer.valueOf(fieldsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        oven.setWeight(Double.valueOf(fieldsMap.get(DoubleFields.WEIGHT.name())));
        oven.setCapacity(Double.valueOf(fieldsMap.get(DoubleFields.CAPACITY.name())));
        oven.setDepth(Double.valueOf(fieldsMap.get(DoubleFields.DEPTH.name())));
        oven.setHeight(Double.valueOf(fieldsMap.get(DoubleFields.HEIGHT.name())));
        oven.setWidth(Double.valueOf(fieldsMap.get(DoubleFields.WIDTH.name())));
        return oven;
    }
}
