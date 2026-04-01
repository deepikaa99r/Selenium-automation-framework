package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import factory.DriverFactory;

public class DragDropPage {

    WebDriver driver = DriverFactory.getDriver();

    By source = By.id("column-a");
    By target = By.id("column-b");

    public void performDragDrop() 
    {
        WebElement src = driver.findElement(source);
        WebElement tgt = driver.findElement(target);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(src, tgt).perform();
    }

    public boolean isSwapped()
    {
        String sourceText = driver.findElement(source).getText();
        return sourceText.equals("B");
    }
    
    public String getSourceText() 
    {
        return driver.findElement(source).getText();
    }

    public String getTargetText() 
    {
        return driver.findElement(target).getText();
    }
}