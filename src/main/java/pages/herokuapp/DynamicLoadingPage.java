package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import utils.WaitUtil;

public class DynamicLoadingPage {

    WebDriver driver = DriverFactory.getDriver();

    By startBtn = By.xpath("//button[text()='Start']");
    By finishText = By.id("finish");

    public void clickStart() 
    {
        driver.findElement(startBtn).click();
    }

    public String getText() 
    {
        WaitUtil.waitForElement(finishText);
        return driver.findElement(finishText).getText();
    }
}