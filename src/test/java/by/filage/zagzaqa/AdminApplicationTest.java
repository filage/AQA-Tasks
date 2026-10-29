package by.filage.zagzaqa;

import by.filage.zagzaqa.model.AdminData;
import by.filage.zagzaqa.steps.AdminSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AdminApplicationTest extends TestSetup {

    private AdminSteps adminSteps;

    @BeforeEach
    void setUpSteps() {
        adminSteps = new AdminSteps(driver);
    }

    @Test
    void shouldApproveAndRejectPendingApplications() {
        adminSteps.enterAsAdmin(new AdminData("Иванов", "Иван", "Иванович", "291234567", "AB123456", "1990-01-01"));
        String approvedNumber = adminSteps.getFirstPendingApplicationNumber();
        adminSteps.approveApplication(approvedNumber);
        assertEquals("Одобрена", adminSteps.getStatusByNumber(approvedNumber));
        String rejectedNumber = adminSteps.getFirstPendingApplicationNumber();
        assertNotEquals(approvedNumber, rejectedNumber, "Для отклонения должна быть выбрана другая заявка");
        adminSteps.rejectApplication(rejectedNumber);
        assertEquals("Отклонена", adminSteps.getStatusByNumber(rejectedNumber));
    }
}