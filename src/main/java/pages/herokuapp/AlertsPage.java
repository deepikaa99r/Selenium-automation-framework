package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import factory.DriverFactory;
import utils.ExtentLogger;

public class AlertsPage {

    WebDriver driver = DriverFactory.getDriver();
    By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");
    By resultText = By.id("result");
    By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");

    public void triggerConfirmAlert() 
    {
        driver.findElement(jsConfirmBtn).click();
    }

    public void dismissAlert() 
    {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getResultText() 
    {
        return driver.findElement(resultText).getText();
    }

    public void triggerAlert() 
    {
        driver.findElement(jsAlertBtn).click();
        ExtentLogger.info("Clicked on Alert");
    }

    public void acceptAlert() 
    {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        ExtentLogger.info("Accepted Alert");
    }

    public boolean isSuccessMessageDisplayed() 
    {
        return getResultText().contains("You successfully clicked an alert");
    }
}