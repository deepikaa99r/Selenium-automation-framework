package base;

import factory.DriverFactory;
import pages.automationexercise.HomePage;
import pages.automationexercise.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected HomePage doLogin(String email, String password) {

    	open(ConfigReader.get("baseUrl"));
        LoginPage login = new HomePage(driver).goToLoginPage();
        login.login(email, password);

        return new HomePage(driver);
    }
    
    protected void dismissPopup() {
    	try {
            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
            driver.findElement(By.tagName("body")).click();
        } catch (Exception ignored) {}
    }
    
    protected void open(String url) {
        driver.get(url);
    }
}