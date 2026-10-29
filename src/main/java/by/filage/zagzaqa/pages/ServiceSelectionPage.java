package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServiceSelectionPage {

    private final By deathRegistrationButton = By.xpath("//button[normalize-space(.)='Регистрация смерти']");
    private final By marriageRegistrationButton = By.xpath("//button[normalize-space(.)='Регистрация брака']");
    private final By birthRegistrationButton = By.xpath("//button[normalize-space(.)='Регистрация рождения']");

    private final WebDriverWait wait;

    public ServiceSelectionPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void selectDeathRegistration() {
        wait.until(ExpectedConditions.elementToBeClickable(deathRegistrationButton)).click();
    }

    public void selectMarriageRegistration() {
        wait.until(ExpectedConditions.elementToBeClickable(marriageRegistrationButton)).click();
    }
    public void selectBirthRegistration() {
        wait.until(ExpectedConditions.elementToBeClickable(birthRegistrationButton)).click();
    }
}