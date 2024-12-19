package lt.vcs.senukai.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Driver {

    private static WebDriver driver;

    public static void setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");


        driver = new ChromeDriver(options);
    }

    public static void setFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        driver = new FirefoxDriver(firefoxOptions);
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }
}

