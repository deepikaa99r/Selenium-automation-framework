package tests.herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.herokuapp.WindowsPage;
import utils.ConfigReader;

public class WindowsTest  extends BaseTest {

    @Test
    public void verifyNewWindow(){
        open(ConfigReader.get("herokuUrl") + "windows");
        WindowsPage page = new WindowsPage();
        page.openNewWindow();
        page.switchToNewWindow();      
        System.out.println("TITLE: " + driver.getTitle());
        System.out.println("TEXT: " + page.getNewWindowText());
        Assert.assertEquals(page.getNewWindowText(), "New Window");
        Assert.assertTrue(page.getTitle().contains("New Window"));
    }
}