package by.filage.zagzaqa;

import by.filage.zagzaqa.model.AdminData;
import by.filage.zagzaqa.model.ApplicantData;
import by.filage.zagzaqa.model.CitizenData;
import by.filage.zagzaqa.model.DeathRegistrationData;
import by.filage.zagzaqa.steps.AdminSteps;
import by.filage.zagzaqa.steps.ApplicantSteps;
import by.filage.zagzaqa.steps.ApplicationStatusSteps;
import by.filage.zagzaqa.steps.CitizenSteps;
import by.filage.zagzaqa.steps.DeathRegistrationSteps;
import by.filage.zagzaqa.steps.ServiceSelectionSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeathRegistrationTest extends TestSetup {
    private ApplicantSteps applicantSteps;
    private ServiceSelectionSteps serviceSteps;
    private CitizenSteps citizenSteps;
    private DeathRegistrationSteps deathSteps;
    private ApplicationStatusSteps statusSteps;
    private AdminSteps adminSteps;

    @BeforeEach
    void setUpSteps() {
        applicantSteps = new ApplicantSteps(driver);
        serviceSteps = new ServiceSelectionSteps(driver);
        citizenSteps = new CitizenSteps(driver);
        deathSteps = new DeathRegistrationSteps(driver);
        statusSteps = new ApplicationStatusSteps(driver);
        adminSteps = new AdminSteps(driver);
    }

    @Test
    void shouldRegisterDeathApplication() {
        applicantSteps.submitValidApplicant(new ApplicantData("Максимов", "Максим", "Максимович", "291234567", "AB123456", "Гродно, улица Тавлая, 10"));
        serviceSteps.selectDeathRegistration();
        citizenSteps.submitValidCitizen(new CitizenData("Петров", "Михаил", "Михайлович", "2001-06-15", "MP123456", "Муж", "Гродно, улица Тавлая, 20"));
        deathSteps.submitValidDeathDetails(new DeathRegistrationData("2026-10-01", "Минск"));
        assertEquals("Статус заявки: На рассмотрении.", statusSteps.getStatus());
        String applicationNumber = statusSteps.getApplicationNumber();
        statusSteps.close();
        adminSteps.enterAsAdmin(new AdminData("Иванов", "Иван", "Иванович", "291234567", "AB123456", "1990-01-01"));
        assertEquals("На рассмотрении", adminSteps.getStatusByNumber(applicationNumber));
    }
}
