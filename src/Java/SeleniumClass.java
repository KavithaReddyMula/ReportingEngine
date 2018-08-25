package Java;

import PageProperties.SerengitiLawPageObject;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

public class SeleniumClass {
    public static void collectData(HashMap<Integer, ArrayList<String>> sheetValues, String sheetName) throws InterruptedException {
        switch (sheetName) {
            case "SerengitiLaw":
                for (int i = 1; i < sheetValues.size(); i++) {
                    String inVoiceNo = sheetValues.get(i).get(0);
                    String customerName = sheetValues.get(i).get(1);
                    ProcessSerengitiLawReports.process(inVoiceNo, customerName);
                }

        }

    }
}
