package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.pages.DeathServiceDataPage;
import org.openqa.selenium.WebDriver;

public class DeathRegistrationSteps {

    private final DeathServiceDataPage deathServiceDataPage;

    public DeathRegistrationSteps(WebDriver driver) {
        this.deathServiceDataPage = new DeathServiceDataPage(driver);
    }

    public void submitValidDeathDetails() {
        deathServiceDataPage.fillDeathData("2026-10-01", "Минск");
        deathServiceDataPage.submit();
    }
}