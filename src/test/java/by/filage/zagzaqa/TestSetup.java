package by.filage.zagzaqa;

import by.filage.zagzaqa.driver.DriverSingleton;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestSetup {

    protected WebDriver driver;

    @BeforeEach
    protected void setUp() {
        Dotenv dotenv = Dotenv.load();
        String username = dotenv.get("ZAGS_USERNAME");
        String password = dotenv.get("ZAGS_PASSWORD");

        driver = DriverSingleton.getDriver();
        driver.get(String.format("https://%s:%s@regoffice.senla.eu/", username, password));
    }

    @AfterEach
    protected void tearDown() {
        try {
            DriverSingleton.quitDriver();
        } finally {
            driver = null;
        }
    }
}
