package by.tc.task01.dao;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerTest {

    @Test
    public void testOne() {
        int counter = 0;
        try (Scanner sc = new Scanner(new File("src/main/resources/appliances_db.txt"))) {
            while (sc.hasNextLine()) {
                String temp = sc.nextLine();
                if (temp.equals("")) {
                    counter++;
                }
                System.out.println(temp);
            }
            System.out.println("number of empty lines" + counter);
        } catch (IOException e) {
            System.err.println("Read file error.");
        }
    }
}
