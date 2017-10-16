package by.tc.task01.dao.command;

import java.util.HashMap;
import java.util.Map;

public class ApplianceHandler {

    private static final Map<String, EntityCreator> CREATORS = new HashMap<>();

    static {
        CREATORS.put("Laptop", new LaptopCreator());
        CREATORS.put("Oven", new OvenCreator());
        CREATORS.put("Refrigerator", new RefrigeratorCreator());
        CREATORS.put("Speakers", new SpeakersCreator());
        CREATORS.put("TabletPC", new TabletPCCreator());
        CREATORS.put("VacuumCleaner", new VacuumCleanerCreator());
    }

    public static EntityCreator getCreator(String entityName) {
        return CREATORS.get(entityName);
    }
}
