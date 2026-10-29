package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.model.MarriageRegistrationData;
import by.filage.zagzaqa.pages.MarriageServiceDataPage;
import org.openqa.selenium.WebDriver;

public class MarriageRegistrationSteps {

    private final MarriageServiceDataPage marriagePage;

    public MarriageRegistrationSteps(WebDriver driver) {
        marriagePage = new MarriageServiceDataPage(driver);
    }

    public void submitMarriageDetails(MarriageRegistrationData marriageData) {
        marriagePage.fillMarriageData(marriageData.registrationDate(), marriageData.newSurname(), marriageData.spouseSurname(), marriageData.spouseName(), marriageData.spouseSecondName(), marriageData.spouseBirthDate(), marriageData.spousePassport());
        marriagePage.submit();
    }
}