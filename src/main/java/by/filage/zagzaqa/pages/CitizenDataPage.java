package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitizenDataPage {

    private final By surnameInput = By.xpath("//input[@id=//label[normalize-space(.)='Фамилия *']/@for]");
    private final By nameInput = By.xpath("//input[@id=//label[normalize-space(.)='Имя *']/@for]");
    private final By patronymicInput = By.xpath("//input[@id=//label[normalize-space(.)='Отчество *']/@for]");
    private final By birthDateInput = By.xpath("//input[@id=//label[normalize-space(.)='Дата рождения *']/@for]");
    private final By passportInput = By.xpath("//input[@id=//label[normalize-space(.)='Номер паспорта']/@for]");
    private final By genderInput = By.xpath("//input[@id=//label[normalize-space(.)='Пол *']/@for]");
    private final By addressInput = By.xpath("//input[@id=//label[normalize-space(.)='Адрес прописки *']/@for]");
    private final By nextButton = By.xpath("//button[normalize-space(.)='Далее']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CitizenDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fillCitizen(String surname, String name, String patronymic, String birthDate, String passport, String gender, String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(birthDateInput));
        driver.findElement(surnameInput).sendKeys(surname);
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(patronymicInput).sendKeys(patronymic);
        driver.findElement(birthDateInput).sendKeys(birthDate);
        driver.findElement(passportInput).sendKeys(passport);
        driver.findElement(genderInput).sendKeys(gender);
        driver.findElement(addressInput).sendKeys(address);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}