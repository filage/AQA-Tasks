package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MarriageServiceDataPage {

    private final By registrationDateInput = By.xpath("//input[@id=//label[normalize-space(.)='Дата регистрации *']/@for]");
    private final By newSurnameInput = By.xpath("//input[@id=//label[normalize-space(.)='Новая фамилия']/@for]");
    private final By spouseSurnameInput = By.xpath("//input[@id=//label[normalize-space(.)='Фамилия супруга/и *']/@for]");
    private final By spouseNameInput = By.xpath("//input[@id=//label[normalize-space(.)='Имя супруга/и *']/@for]");
    private final By spouseSecondNameInput = By.xpath("//input[@id=//label[normalize-space(.)='Отчество супруга/и *']/@for]");
    private final By spouseBirthDateInput = By.xpath("//input[@id=//label[normalize-space(.)='Дата рождения супруга/и']/@for]");
    private final By spousePassportInput = By.xpath("//input[@id=//label[normalize-space(.)='Номер паспорта супруга/и *']/@for]");
    private final By finishButton = By.xpath("//button[normalize-space(.)='Завершить']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MarriageServiceDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fillMarriageData(String registrationDate, String newSurname, String spouseSurname, String spouseName, String spouseSecondName, String spouseBirthDate, String spousePassport) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationDateInput));
        driver.findElement(registrationDateInput).sendKeys(registrationDate);
        driver.findElement(newSurnameInput).sendKeys(newSurname);
        driver.findElement(spouseSurnameInput).sendKeys(spouseSurname);
        driver.findElement(spouseNameInput).sendKeys(spouseName);
        driver.findElement(spouseSecondNameInput).sendKeys(spouseSecondName);
        driver.findElement(spouseBirthDateInput).sendKeys(spouseBirthDate);
        driver.findElement(spousePassportInput).sendKeys(spousePassport);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }
}