package pages.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;
import utils.WaitUtil;

public class HomePage extends BasePage {

	By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
	By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
	By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");
	By productsBtn = By.xpath("//a[@href='/products']");
	
    public HomePage(WebDriver driver) 
    {
        super(driver);
    }

    public LoginPage goToLoginPage() 
    {
        click(signupLoginBtn);
        return new LoginPage(driver);
    }

    public boolean isUserLoggedIn() 
    {
        return isDisplayed(loggedInText);
    }

    public void clickLogout() 
    {
        click(logoutBtn);
    }

    public boolean isLoginButtonVisible() 
    {
        return isDisplayed(signupLoginBtn);
    }
    
    public ProductsPage goToProductsPage() 
    {
        WaitUtil.removeAds();
        driver.get(ConfigReader.get("baseUrl") + "products");      
        return new ProductsPage(driver);
    }
}