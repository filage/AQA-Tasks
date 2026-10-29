package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.model.CitizenData;
import by.filage.zagzaqa.pages.CitizenDataPage;
import org.openqa.selenium.WebDriver;

public class CitizenSteps {

    private final CitizenDataPage citizenDataPage;

    public CitizenSteps(WebDriver driver) {
        this.citizenDataPage = new CitizenDataPage(driver);
    }

    public void submitValidCitizen(CitizenData citizen) {
        citizenDataPage.fillCitizen(citizen.surname(), citizen.name(), citizen.secondName(), citizen.birthDate(), citizen.passport(), citizen.gender(), citizen.address());
        citizenDataPage.clickNext();
    }
}
