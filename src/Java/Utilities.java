package Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {
    public static WebDriver webDriver;

    public static Properties getProperties(){
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(System.getProperty("user.dir")+"/src/resources/credentials.properties");
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static WebDriver chromeDriver(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(url);
        Thread.sleep(1000);
        return webDriver;
    }
    public static WebDriver ieDriver(String url) {
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/resources/IEDriverServer.exe");
        webDriver = new InternetExplorerDriver();
        webDriver.get(url);
        return webDriver;
    }

    public static void sendKeys(WebDriver webDriver, By by, String text) {
        webDriver.findElement(by).sendKeys(text);
    }

    public static void clickOnButton(WebDriver webDriver, By by) {
        webDriver.findElement(by).click();
    }
}
