package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import factory.DriverFactory;

public class DropDownPage 
{

    WebDriver driver = DriverFactory.getDriver();

    By dropdown = By.id("dropdown");

    public void selectOption(String value) 
    {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(value);
    }

    public String getSelectedOption() 
    {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }
}