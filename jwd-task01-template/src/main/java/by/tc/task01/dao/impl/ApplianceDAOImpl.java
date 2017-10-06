package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        // you may add your own code here
        //i can get here type of E and search for current line
        try(Scanner sc = new Scanner(new File("src/main/java/resources/appliances_db.txt"))) {
            while (sc.hasNextLine()) {
                //TODO: realization
                Map<String, String> entityAsMap = parseLine(sc.nextLine());

            }
        } catch (IOException e) {
            System.err.println("Read file error.");
        }

        return null;
    }

    private Map<String, String> parseLine(String line) {
        Map<String, String> result = new HashMap<>();
        //TODO: realization

        return result;
    }

    // you may add your own code here

}
