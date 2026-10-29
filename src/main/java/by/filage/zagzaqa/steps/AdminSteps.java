package by.filage.zagzaqa.steps;

import by.filage.zagzaqa.model.AdminData;
import by.filage.zagzaqa.pages.AdminApplicationsPage;
import by.filage.zagzaqa.pages.AdminDataPage;
import by.filage.zagzaqa.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class AdminSteps {

    private final MainPage mainPage;
    private final AdminDataPage adminDataPage;
    private final AdminApplicationsPage adminApplicationsPage;

    public AdminSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        adminDataPage = new AdminDataPage(driver);
        adminApplicationsPage = new AdminApplicationsPage(driver);
    }

    public void enterAsAdmin(AdminData admin) {
        mainPage.enterAsAdmin();
        adminDataPage.fillAdmin(admin.surname(), admin.name(), admin.secondName(), admin.phone(), admin.passport(), admin.birthDate());
        adminDataPage.clickNext();
    }

    public String getStatusByNumber(String applicationNumber) {
        return adminApplicationsPage.findByNumber(applicationNumber).getStatus();
    }

    public void approveApplication(String applicationNumber) {
        adminApplicationsPage.findByNumber(applicationNumber).approve();
        adminApplicationsPage.waitForStatus(applicationNumber, "Одобрена");
    }

    public void rejectApplication(String applicationNumber) {
        adminApplicationsPage.findByNumber(applicationNumber).reject();
        adminApplicationsPage.waitForStatus(applicationNumber, "Отклонена");
    }

    public String getFirstPendingApplicationNumber() {
        return adminApplicationsPage.findFirstPendingApplication().getNumber();
    }
}
