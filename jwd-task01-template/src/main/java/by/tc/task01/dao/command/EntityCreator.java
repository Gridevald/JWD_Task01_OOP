package by.tc.task01.dao.command;

import by.tc.task01.entity.Appliance;

import java.util.Map;

public interface EntityCreator {

    public Appliance create(Map<String, String> fieldsMap);
}
