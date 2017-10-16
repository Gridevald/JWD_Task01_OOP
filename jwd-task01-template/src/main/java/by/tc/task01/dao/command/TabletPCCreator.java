package by.tc.task01.dao.command;

import by.tc.task01.dao.DoubleFields;
import by.tc.task01.dao.IntegerFields;
import by.tc.task01.dao.StringFields;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;

import java.util.Map;

public class TabletPCCreator implements EntityCreator {

    @Override
    public Appliance create(Map<String, String> fieldsMap) {
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(Double.valueOf(fieldsMap.get(DoubleFields.BATTERY_CAPACITY.name())));
        tabletPC.setDisplayInches(Double.valueOf(fieldsMap.get(DoubleFields.DISPLAY_INCHES.name())));
        tabletPC.setMemoryRom(Integer.valueOf(fieldsMap.get(IntegerFields.MEMORY_ROM.name())));
        tabletPC.setFlashMemoryCapacity(Integer.valueOf(fieldsMap.get(IntegerFields.FLASH_MEMORY_CAPACITY.name())));
        tabletPC.setColor(fieldsMap.get(StringFields.COLOR.name()));
        return tabletPC;
    }
}
