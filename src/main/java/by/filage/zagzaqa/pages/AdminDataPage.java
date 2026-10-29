package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminDataPage {

    private final By surnameInput = By.xpath("//input[@id=//label[normalize-space(.)='Фамилия *']/@for]");
    private final By nameInput = By.xpath("//input[@id=//label[normalize-space(.)='Имя *']/@for]");
    private final By secondNameInput = By.xpath("//input[@id=//label[normalize-space(.)='Отчество *']/@for]");
    private final By phoneInput = By.xpath("//input[@id=//label[normalize-space(.)='Телефон *']/@for]");
    private final By passportInput = By.xpath("//input[@id=//label[normalize-space(.)='Номер паспорта *']/@for]");
    private final By birthDateInput = By.xpath("//input[@id=//label[normalize-space(.)='Дата рождения *']/@for]");
    private final By nextButton = By.xpath("//div[@role='dialog']//button[normalize-space(.)='Далее']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public AdminDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fillAdmin(String surname, String name, String secondName, String phone, String passport, String birthDate) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(surnameInput));
        driver.findElement(surnameInput).sendKeys(surname);
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(secondNameInput).sendKeys(secondName);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(passportInput).sendKeys(passport);
        driver.findElement(birthDateInput).sendKeys(birthDate);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}