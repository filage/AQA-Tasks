package by.filage.zagzaqa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            try {
                driver.quit();
            } finally {
                driver = null;
            }
        }
    }
}
