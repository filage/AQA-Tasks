package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.pages.ServiceSelectionPage;
import org.openqa.selenium.WebDriver;

public class ServiceSelectionSteps {

    private final ServiceSelectionPage serviceSelectionPage;

    public ServiceSelectionSteps(WebDriver driver) {
        this.serviceSelectionPage = new ServiceSelectionPage(driver);
    }

    public void selectDeathRegistration() {
        serviceSelectionPage.selectDeathRegistration();
    }
}