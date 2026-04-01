package pages.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class LoginPage extends BasePage {

    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By loginError = By.xpath("//p[contains(text(),'incorrect')]");
    By nameInput = By.xpath("//input[@data-qa='signup-name']");
    By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");

    public LoginPage(WebDriver driver) 
    {
        super(driver);
    }

    public void login(String email, String password) 
    {
        type(emailField, email);
        type(passwordField, password);
        click(loginBtn);
    }

    public boolean isLoginErrorDisplayed() 
    {
        return isDisplayed(loginError);
    }
    
    public SignupPage startSignup(String name, String email) 
    {
        type(nameInput, name);
        type(signupEmail, email);
        WaitUtil.safeClick(signupBtn);
        return new SignupPage(driver);
    }
}