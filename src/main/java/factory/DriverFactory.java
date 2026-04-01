package factory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver.set(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());

        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new RuntimeException("Driver not initialized!");
        }
        return driver.get();
    }

    public static void quitDriver() {
        WebDriver drv = driver.get();

        if (drv != null) {
            try {
                drv.quit();
            } catch (Exception e) {
                System.out.println("Driver quit failed: " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}