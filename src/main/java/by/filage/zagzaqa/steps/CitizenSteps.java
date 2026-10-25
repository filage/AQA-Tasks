package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.pages.CitizenDataPage;
import org.openqa.selenium.WebDriver;

public class CitizenSteps {

    private final CitizenDataPage citizenDataPage;

    public CitizenSteps(WebDriver driver) {
        this.citizenDataPage = new CitizenDataPage(driver);
    }

    public void submitValidCitizen() {
        citizenDataPage.fillCitizen("Петров", "Михаил", "Михайлович", "2001-06-15", "MP123456", "Муж", "Гродно, улица Тавлая, 20");
        citizenDataPage.clickNext();
    }
}
