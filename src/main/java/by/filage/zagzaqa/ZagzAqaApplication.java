package by.filage.zagzaqa;

import by.filage.zagzaqa.steps.ApplicantSteps;
import by.filage.zagzaqa.steps.ApplicationStatusSteps;
import by.filage.zagzaqa.steps.CitizenSteps;
import by.filage.zagzaqa.steps.DeathRegistrationSteps;
import by.filage.zagzaqa.steps.ServiceSelectionSteps;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ZagzAqaApplication {

    private static final String BASE_DOMAIN = "regoffice.senla.eu";
    private static final String EXPECTED_STATUS = "Статус заявки: На рассмотрении.";

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        String username = dotenv.get("ZAGS_USERNAME");
        String password = dotenv.get("ZAGS_PASSWORD");

        String authorizedUrl = String.format("https://%s:%s@%s/", username, password, BASE_DOMAIN);

        WebDriver driver = new FirefoxDriver();

        try {
            driver.get(authorizedUrl);

            ApplicantSteps applicantSteps = new ApplicantSteps(driver);
            ServiceSelectionSteps serviceSelectionSteps = new ServiceSelectionSteps(driver);
            CitizenSteps citizenSteps = new CitizenSteps(driver);
            DeathRegistrationSteps deathRegistrationSteps = new DeathRegistrationSteps(driver);
            ApplicationStatusSteps applicationStatusSteps = new ApplicationStatusSteps(driver);

            applicantSteps.submitValidApplicant();
            serviceSelectionSteps.selectDeathRegistration();
            citizenSteps.submitValidCitizen();
            deathRegistrationSteps.submitValidDeathDetails();

            String actualStatus = applicationStatusSteps.getStatus();
            // Пока сравниваем через if, т.к. assertEquals из JUnit надо добавить в следующей домашке
            if (!EXPECTED_STATUS.equals(actualStatus)) {
                throw new AssertionError(String.format("Ожидался статус: %s; получен: %s", EXPECTED_STATUS, actualStatus));
            }
        } finally {
            driver.quit();
        }
    }
}
