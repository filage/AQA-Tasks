package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final By userButton = By.xpath("//button[normalize-space(.)='Войти как пользователь']");

    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void enterAsUser() {
        wait.until(ExpectedConditions.elementToBeClickable(userButton)).click();
    }
}