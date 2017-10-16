package by.tc.task01.dao.command;

import by.tc.task01.dao.DoubleFields;
import by.tc.task01.dao.IntegerFields;
import by.tc.task01.dao.StringFields;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;

import java.util.Map;

public class SpeakersCreator implements EntityCreator {

    @Override
    public Appliance create(Map<String, String> fieldsMap) {
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(Integer.valueOf(fieldsMap.get(IntegerFields.POWER_CONSUMPTION.name())));
        speakers.setNumberOfSpeakers(Integer.valueOf(fieldsMap.get(IntegerFields.NUMBER_OF_SPEAKERS.name())));
        speakers.setFrequencyRange(fieldsMap.get(StringFields.FREQUENCY_RANGE.name()));
        speakers.setCordLength(Double.valueOf(fieldsMap.get(DoubleFields.CORD_LENGTH.name())));
        return speakers;
    }
}
