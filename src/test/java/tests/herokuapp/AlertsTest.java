package tests.herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.herokuapp.AlertsPage;
import utils.ConfigReader;

public class AlertsTest extends BaseTest {
	
    @Test
    public void verifyAlertAccept() {

    	open(ConfigReader.get("herokuUrl") + "javascript_alerts");
        AlertsPage page = new AlertsPage();
        page.triggerAlert();
        page.acceptAlert();
        String result = page.getResultText();
        Assert.assertTrue(result.contains("You successfully clicked an alert"));
        Assert.assertTrue(result.startsWith("You"));
    }
    
    @Test
    public void verifyAlertDismiss() {

        open(ConfigReader.get("herokuUrl") + "javascript_alerts");
        AlertsPage page = new AlertsPage();
        page.triggerConfirmAlert();
        page.dismissAlert();
        Assert.assertTrue(page.getResultText().contains("You clicked: Cancel"));
    }
}