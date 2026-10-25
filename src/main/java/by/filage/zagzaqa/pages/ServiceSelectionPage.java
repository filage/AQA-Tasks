package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServiceSelectionPage {

    private final By deathRegistrationButton = By.xpath("//button[normalize-space(.)='Регистрация смерти']");

    private final WebDriverWait wait;

    public ServiceSelectionPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void selectDeathRegistration() {
        wait.until(ExpectedConditions.elementToBeClickable(deathRegistrationButton)).click();
    }
}