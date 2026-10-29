package by.filage.zagzaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApplicationRow {

    private final WebElement row;

    private final By numberCell = By.xpath("./td[1]");
    private final By typeCell = By.xpath("./td[3]");
    private final By statusCell = By.xpath("./td[5]");
    private final By approveButton = By.xpath(".//button[.//*[@data-testid='ThumbUpIcon']]");
    private final By rejectButton = By.xpath(".//button[.//*[@data-testid='ThumbDownIcon']]");

    public ApplicationRow(WebElement row) {
        this.row = row;
    }

    public String getNumber() {
        return row.findElement(numberCell).getText().trim();
    }

    public String getType() {
        return row.findElement(typeCell).getText().trim();
    }

    public String getStatus() {
        return row.findElement(statusCell).getText().trim();
    }

    public void approve() {
        row.findElement(approveButton).click();
    }

    public void reject() {
        row.findElement(rejectButton).click();
    }

    public WebElement getStatusElement() {
        return row.findElement(statusCell);
    }
}