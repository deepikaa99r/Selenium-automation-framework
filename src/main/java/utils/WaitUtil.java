package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import factory.DriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class WaitUtil {

    public static WebElement waitForElement(By locator) 
    {
        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(10)
        );
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void removeAds() 
    {
        WebDriver driver = DriverFactory.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "document.querySelectorAll('iframe, .adsbygoogle, .ad, .popup, .overlay').forEach(el => el.remove());"
        );
    }
    public static void safeClick(By locator) 
    {

        WebDriver driver = DriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 

        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {

        	removeAds();
        	new Actions(driver).sendKeys(Keys.ESCAPE).perform();
            ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe').forEach(el => el.remove());"
            );

            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
        }
    }
}