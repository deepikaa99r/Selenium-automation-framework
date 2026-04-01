package tests.automationexercise;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.automationexercise.HomePage;
import pages.automationexercise.SignupPage;
import utils.ConfigReader;

public class SignupTest extends BaseTest {

    @Test
    public void verifySignupFlow() {

    	open(ConfigReader.get("baseUrl"));
        String email = "test" + System.currentTimeMillis() + "@mail.com";
        SignupPage signup = new HomePage(driver).goToLoginPage().startSignup("TestUser", email);
        signup.fillSignupForm();
        signup.submit();
        Assert.assertTrue(signup.isAccountCreated());
    }
}
