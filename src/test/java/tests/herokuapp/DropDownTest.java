package tests.herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.herokuapp.DropDownPage;
import utils.ConfigReader;

public class DropDownTest extends BaseTest{

    @Test
    public void verifyDropdown() {
        open(ConfigReader.get("herokuUrl") + "dropdown");
        DropDownPage page = new DropDownPage();
        page.selectOption("Option 1");
        Assert.assertEquals(page.getSelectedOption(), "Option 1");
        Assert.assertTrue(page.getSelectedOption().contains("Option"));
    }
}