package tests.automationexercise;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.automationexercise.HomePage;
import pages.automationexercise.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        HomePage home = doLogin("shelby99@gmail.com","n6fZUBLN8E875pIR");
        Assert.assertTrue(home.isUserLoggedIn());
    }

    @Test
    public void invalidLoginTest() {
    	open(ConfigReader.get("baseUrl"));
        LoginPage login = new HomePage(driver).goToLoginPage();
        login.login("wrong@mail.com", "wrongpass");
        Assert.assertTrue(login.isLoginErrorDisplayed());
    }

    @Test
    public void logoutTest() {
        HomePage home = doLogin("shelby99@gmail.com","n6fZUBLN8E875pIR");
        home.clickLogout();
        Assert.assertTrue(home.isLoginButtonVisible());
    }
}
