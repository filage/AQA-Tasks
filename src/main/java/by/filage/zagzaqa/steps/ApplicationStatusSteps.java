package by.filage.zagzaqa.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationStatusSteps {

    private final By statusMessage = By.xpath("//span[starts-with(normalize-space(.), 'Статус заявки:')]");
    private final WebDriverWait wait;

    public ApplicationStatusSteps(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getStatus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusMessage)).getText().trim();
    }

}
