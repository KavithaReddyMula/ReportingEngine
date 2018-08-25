package Java;

import PageProperties.SerengitiLawPageObject;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ProcessSerengitiLawReports {
    static Properties properties = Utilities.getProperties();
    public static void process(String invoiceNumber,String customerName) throws InterruptedException {
        WebDriver driver = Utilities.ieDriver(properties.getProperty("SerengitiLawURL"));
        Utilities.clickOnButton(driver,SerengitiLawPageObject.signInWithOnePassButton);
        Utilities.sendKeys(driver, SerengitiLawPageObject.loginUserName, properties.getProperty("SerengitiLawUserName"));
        Utilities.sendKeys(driver, SerengitiLawPageObject.loginPassword, properties.getProperty("SerengitiLawPassword"));
        Utilities.clickOnButton(driver,SerengitiLawPageObject.signInButton);

    }
}
