package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeathServiceDataPage {

    private final By deathDateInput = By.xpath("//input[@id=//label[normalize-space(.)='Дата смерти *']/@for]");
    private final By deathPlaceInput = By.xpath("//input[@id=//label[normalize-space(.)='Место смерти *']/@for]");
    private final By finishButton = By.xpath("//button[normalize-space(.)='Завершить']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public DeathServiceDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fillDeathData(String deathDate, String deathPlace) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deathDateInput));
        driver.findElement(deathDateInput).sendKeys(deathDate);
        driver.findElement(deathPlaceInput).sendKeys(deathPlace);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }
}