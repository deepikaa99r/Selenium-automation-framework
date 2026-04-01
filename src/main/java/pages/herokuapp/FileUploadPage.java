package pages.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;

public class FileUploadPage {

    WebDriver driver = DriverFactory.getDriver();

    By uploadInput = By.id("file-upload");
    By uploadBtn = By.id("file-submit");
    By successText = By.tagName("h3");
    By uploadedFile = By.id("uploaded-files");

    public void uploadFile(String path) 
    {
        driver.findElement(uploadInput).sendKeys(path);
        driver.findElement(uploadBtn).click();
    }

    public String getSuccessText() 
    {
        return driver.findElement(successText).getText();
    }

    public String getUploadedFileName() 
    {
        return driver.findElement(uploadedFile).getText();
    }
}