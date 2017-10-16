package by.tc.task01.dao.command;

import by.tc.task01.dao.IntegerFields;
import by.tc.task01.dao.StringFields;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;

import java.util.Map;

public class VacuumCleanerCreator implements EntityCreator {

    @Override
    public Appliance create(Map<String, String> fieldsMap) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setPowerConsumption(Integer.valueOf(fieldsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        vacuumCleaner.setFilterType(fieldsMap.get(StringFields.FILTER_TYPE.name()));
        vacuumCleaner.setBagType(fieldsMap.get(StringFields.BAG_TYPE.name()));
        vacuumCleaner.setWandType(fieldsMap.get(StringFields.WAND_TYPE.name()));
        vacuumCleaner.setMotorSpeedRegulation(Integer.valueOf(fieldsMap.get(IntegerFields.MOTOR_SPEED_REGULATION.name())));
        vacuumCleaner.setCleaningWidth(Integer.valueOf(fieldsMap.get(IntegerFields.CLEANING_WIDTH.name())));
        return vacuumCleaner;
    }
}
