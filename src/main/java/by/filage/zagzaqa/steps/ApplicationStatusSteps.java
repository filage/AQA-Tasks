package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.pages.ApplicationStatusPage;
import org.openqa.selenium.WebDriver;

public class ApplicationStatusSteps {

    private final ApplicationStatusPage statusPage;

    public ApplicationStatusSteps(WebDriver driver) {
        statusPage = new ApplicationStatusPage(driver);
    }

    public String getStatus() {
        return statusPage.getStatus();
    }

    public String getApplicationNumber() {
        return statusPage.getApplicationNumber();
    }

    public void close() {
        statusPage.close();
    }
}