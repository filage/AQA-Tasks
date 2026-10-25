package by.filage.zagzaqa.steps;

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

    public void submitValidApplicant() {
        mainPage.enterAsUser();
        applicantDataPage.fillApplicant("Максимов", "Максим", "Максимович", "291234567", "AB123456", "Гродно, улица Тавлая, 10");
        applicantDataPage.clickNext();
    }
}
