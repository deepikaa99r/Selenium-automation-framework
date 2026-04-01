package pages.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utils.WaitUtil;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        try {
            WaitUtil.safeClick(locator);
        } catch (Exception e) {
            new Actions(driver).sendKeys(Keys.ESCAPE).perform();
            WaitUtil.safeClick(locator);
        }
    }

    protected void type(By locator, String text) {
        WaitUtil.waitForElement(locator).sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {
        return WaitUtil.waitForElement(locator).isDisplayed();
    }
    
    protected String getText(By locator) {
        return WaitUtil.waitForElement(locator).getText();
    }
}