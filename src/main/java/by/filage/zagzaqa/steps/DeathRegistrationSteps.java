package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.model.DeathRegistrationData;
import by.filage.zagzaqa.pages.DeathServiceDataPage;
import org.openqa.selenium.WebDriver;

public class DeathRegistrationSteps {

    private final DeathServiceDataPage deathServiceDataPage;

    public DeathRegistrationSteps(WebDriver driver) {
        this.deathServiceDataPage = new DeathServiceDataPage(driver);
    }

    public void submitValidDeathDetails(DeathRegistrationData deathData) {
        deathServiceDataPage.fillDeathData(deathData.deathDate(), deathData.deathPlace());
        deathServiceDataPage.submit();
    }
}