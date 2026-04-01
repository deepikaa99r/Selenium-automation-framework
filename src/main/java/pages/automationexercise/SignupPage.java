package pages.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {

    private By password = By.id("password");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By address = By.id("address1");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobile = By.id("mobile_number");
    private By createAccountBtn = By.xpath("//button[contains(text(),'Create Account')]");
    private By accountCreatedMsg = By.xpath("//b[contains(text(),'Account Created!')]");

    public SignupPage(WebDriver driver) 
    {
        super(driver);
    }

    public void fillSignupForm() 
    {
        type(password, "Test@123");
        type(firstName, "Test");
        type(lastName, "User");
        type(address, "Anjuna");
        type(state, "Goa");
        type(city, "Panjim");
        type(zipcode, "403510");
        type(mobile, "9999999999");
    }

    public void submit() 
    {
        click(createAccountBtn);
    }

    public boolean isAccountCreated() 
    {
        return isDisplayed(accountCreatedMsg);
    }
}
