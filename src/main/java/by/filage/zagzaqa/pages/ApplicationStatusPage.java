package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationStatusPage {

    private final By statusMessage = By.xpath("//span[starts-with(normalize-space(.), 'Статус заявки:')]");
    private final By applicationMessage = By.xpath("//span[starts-with(normalize-space(.), 'Ваша заявка №')]");
    private final By closeButton = By.xpath("//div[@role='dialog']//button[normalize-space(.)='Закрыть']");

    private final WebDriverWait wait;

    public ApplicationStatusPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getStatus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusMessage)).getText().trim();
    }

    public String getApplicationNumber() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(applicationMessage)).getText();
        Matcher matcher = Pattern.compile("№\\s*(\\d+)").matcher(text);

        if (!matcher.find()) {
            throw new IllegalStateException("Не найден номер заявки в тексте: " + text);
        }

        return matcher.group(1);
    }

    public void close() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(applicationMessage));
    }
}