package by.tc.task01.dao.command;

import by.tc.task01.dao.DoubleFields;
import by.tc.task01.dao.IntegerFields;
import by.tc.task01.dao.StringFields;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;

import java.util.Map;

public class LaptopCreator implements EntityCreator {

    @Override
    public Appliance create(Map<String, String> fieldsMap) {
        Laptop laptop = new Laptop();
        laptop.setBatteryCapacity(Double.valueOf(fieldsMap.get(DoubleFields.BATTERY_CAPACITY.name())));
        laptop.setOs(fieldsMap.get(StringFields.OS.name()));
        laptop.setMemoryRom(Integer.valueOf(fieldsMap.get(IntegerFields.MEMORY_ROM.name())));
        laptop.setSystemMemory(Integer.valueOf(fieldsMap.get(IntegerFields.SYSTEM_MEMORY.name())));
        laptop.setCpu(Double.valueOf(fieldsMap.get(DoubleFields.CPU.name())));
        laptop.setDisplayInches(Double.valueOf(fieldsMap.get(DoubleFields.DISPLAY_INCHS.name())));
        return laptop;
    }
}
