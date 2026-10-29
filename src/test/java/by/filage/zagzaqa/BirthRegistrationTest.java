package by.filage.zagzaqa;

import by.filage.zagzaqa.model.AdminData;
import by.filage.zagzaqa.model.ApplicantData;
import by.filage.zagzaqa.model.BirthRegistrationData;
import by.filage.zagzaqa.model.CitizenData;
import by.filage.zagzaqa.steps.AdminSteps;
import by.filage.zagzaqa.steps.ApplicantSteps;
import by.filage.zagzaqa.steps.ApplicationStatusSteps;
import by.filage.zagzaqa.steps.BirthRegistrationSteps;
import by.filage.zagzaqa.steps.CitizenSteps;
import by.filage.zagzaqa.steps.ServiceSelectionSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BirthRegistrationTest extends TestSetup {

    private ApplicantSteps applicantSteps;
    private ServiceSelectionSteps serviceSteps;
    private CitizenSteps citizenSteps;
    private BirthRegistrationSteps birthSteps;
    private ApplicationStatusSteps statusSteps;
    private AdminSteps adminSteps;

    @BeforeEach
    void setUpSteps() {
        applicantSteps = new ApplicantSteps(driver);
        serviceSteps = new ServiceSelectionSteps(driver);
        citizenSteps = new CitizenSteps(driver);
        birthSteps = new BirthRegistrationSteps(driver);
        statusSteps = new ApplicationStatusSteps(driver);
        adminSteps = new AdminSteps(driver);
    }

    @Test
    void shouldRegisterBirthApplication() {
        applicantSteps.submitValidApplicant(new ApplicantData("Максимов", "Максим", "Максимович", "291234567", "AB123456", "Гродно, улица Тавлая, 10"));
        serviceSteps.selectBirthRegistration();
        citizenSteps.submitValidCitizen(new CitizenData("Петров", "Александр", "Михайлович", "2026-10-01", "MP123456", "Муж", "Гродно, улица Тавлая, 20"));
        birthSteps.submitBirthDetails(new BirthRegistrationData("Гродно", "Анна", "Михаил", "Елена", "Иван"));
        assertEquals("Статус заявки: На рассмотрении.", statusSteps.getStatus());
        String applicationNumber = statusSteps.getApplicationNumber();
        statusSteps.close();
        adminSteps.enterAsAdmin(new AdminData("Иванов", "Иван", "Иванович", "291234567", "AB123456", "1990-01-01"));
        assertEquals("На рассмотрении", adminSteps.getStatusByNumber(applicationNumber));
    }
}
