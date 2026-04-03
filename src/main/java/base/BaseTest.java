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
import org.testng.annotations.AfterSuite;
import utils.ExtentManager;
import utils.RetryAnalyzer;
import utils.WaitUtil;

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
    
    @AfterSuite
    public void flushReport() {
        ExtentManager.getInstance().flush();

        System.out.println("\nReport generated at:");
        System.out.println(System.getProperty("user.dir") + "/reports/");
        System.out.println("\n========== EXECUTION SUMMARY ==========");
        System.out.println("Total Retries: " + RetryAnalyzer.totalRetries);

        if (RetryAnalyzer.totalRetries > 0) {
            System.out.println("Note: 'Skipped' count may include retried test attempts.");
        }

        System.out.println("======================================\n");
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