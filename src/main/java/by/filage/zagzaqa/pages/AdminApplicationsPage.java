package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminApplicationsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By table = By.xpath("//table[.//th[normalize-space(.)='Заявитель']]");

    public AdminApplicationsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ApplicationRow findByNumber(String applicationNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(table));

        By rowLocator = By.xpath(".//tr[td[1][normalize-space(.)='" + applicationNumber + "']]");
        WebElement tableElement = driver.findElement(table);
        WebElement row = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(tableElement, rowLocator)).get(0);

        return new ApplicationRow(row);
    }

    public void waitForStatus(String applicationNumber, String expectedStatus) {
        findByNumber(applicationNumber);
        By status = By.xpath("//tr[td[1][normalize-space(.)='" + applicationNumber + "']]/td[5]");
        wait.until(ExpectedConditions.textToBe(status, expectedStatus));
    }

    public ApplicationRow findFirstPendingApplication() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(table));

        By pendingRow = By.xpath(".//tr[td[5][normalize-space(.)='На рассмотрении']]");
        WebElement tableElement = driver.findElement(table);
        WebElement row = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(tableElement, pendingRow)).get(0);

        return new ApplicationRow(row);
    }
}
