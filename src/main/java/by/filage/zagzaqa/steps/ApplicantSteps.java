package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.model.ApplicantData;
import by.filage.zagzaqa.pages.ApplicantDataPage;
import by.filage.zagzaqa.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class ApplicantSteps {

    private final MainPage mainPage;
    private final ApplicantDataPage applicantDataPage;

    public ApplicantSteps(WebDriver driver) {
        this.mainPage = new MainPage(driver);
        this.applicantDataPage = new ApplicantDataPage(driver);
    }

    public void submitValidApplicant(ApplicantData applicant) {
        mainPage.enterAsUser();
        applicantDataPage.fillApplicant(
                applicant.surname(),
                applicant.name(),
                applicant.seconName(),
                applicant.phone(),
                applicant.passport(),
                applicant.adress()
        );
        applicantDataPage.clickNext();
    }
}
