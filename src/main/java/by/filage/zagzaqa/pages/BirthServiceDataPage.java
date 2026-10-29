package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BirthServiceDataPage {

    private final By birthPlaceInput = By.xpath("//input[@id=//label[normalize-space(.)='Место рождения *']/@for]");
    private final By motherInput = By.xpath("//input[@id=//label[normalize-space(.)='Мать']/@for]");
    private final By fatherInput = By.xpath("//input[@id=//label[normalize-space(.)='Отец']/@for]");
    private final By grandmotherInput = By.xpath("//input[@id=//label[normalize-space(.)='Бабушка']/@for]");
    private final By grandfatherInput = By.xpath("//input[@id=//label[normalize-space(.)='Дедушка']/@for]");
    private final By finishButton = By.xpath("//button[normalize-space(.)='Завершить']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BirthServiceDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fillBirthData(String birthPlace, String mother, String father, String grandmother, String grandfather) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(birthPlaceInput));
        driver.findElement(birthPlaceInput).sendKeys(birthPlace);
        driver.findElement(motherInput).sendKeys(mother);
        driver.findElement(fatherInput).sendKeys(father);
        driver.findElement(grandmotherInput).sendKeys(grandmother);
        driver.findElement(grandfatherInput).sendKeys(grandfather);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }
}