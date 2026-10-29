package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.model.BirthRegistrationData;
import by.filage.zagzaqa.pages.BirthServiceDataPage;
import org.openqa.selenium.WebDriver;

public class BirthRegistrationSteps {

    private final BirthServiceDataPage birthPage;

    public BirthRegistrationSteps(WebDriver driver) {
        birthPage = new BirthServiceDataPage(driver);
    }

    public void submitBirthDetails(BirthRegistrationData birthData) {
        birthPage.fillBirthData(birthData.birthPlace(), birthData.mother(), birthData.father(), birthData.grandmother(), birthData.grandfather());
        birthPage.submit();
    }
}