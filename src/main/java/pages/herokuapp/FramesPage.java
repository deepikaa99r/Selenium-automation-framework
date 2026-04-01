package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import utils.WaitUtil;

public class FramesPage {

    WebDriver driver = DriverFactory.getDriver();

    By iframe = By.id("mce_0_ifr");
    By textBox = By.id("tinymce");

    public void switchToFrame() 
    {
    	WaitUtil.waitForElement(iframe);
        driver.switchTo().frame(driver.findElement(iframe));
    }

    public String getText() 
    {
        return driver.findElement(textBox).getText();
    }
}