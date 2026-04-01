package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import factory.DriverFactory;


public class WindowsPage {

    WebDriver driver = DriverFactory.getDriver();

    By clickHereLink = By.linkText("Click Here");
    By newWindowText = By.tagName("h3");

    public void openNewWindow() 
    {
        driver.findElement(clickHereLink).click();
    }

    public void switchToNewWindow() 
    {

        String parent = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1);

        for (String window : driver.getWindowHandles()) 
        {
            if (!window.equals(parent)) 
            {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public String getNewWindowText() 
    {
 
        return driver.findElement(newWindowText).getText();
    }
    
    public String getTitle() 
    {
        return driver.getTitle();
    }
}