package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicantDataPage {

    private final By surnameInput = By.xpath("//input[starts-with(@placeholder, 'Введите фамилию')]");
    private final By nameInput = By.xpath("//input[starts-with(@placeholder, 'Введите имя')]");
    private final By patronymicInput = By.xpath("//input[starts-with(@placeholder, 'Введите отчество')]");
    private final By phoneInput = By.xpath("//input[starts-with(@placeholder, 'Введите номер телефона')]");
    private final By passportInput = By.xpath("//input[starts-with(@placeholder, 'Введите номер паспорта')]");
    private final By addressInput = By.xpath("//input[@placeholder='Введите адрес прописки']");
    private final By nextButton = By.xpath("//button[normalize-space(.)='Далее']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ApplicantDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fillApplicant(String surname, String name, String patronymic, String phone, String passport, String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(surnameInput));
        driver.findElement(surnameInput).sendKeys(surname);
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(patronymicInput).sendKeys(patronymic);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(passportInput).sendKeys(passport);
        driver.findElement(addressInput).sendKeys(address);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}