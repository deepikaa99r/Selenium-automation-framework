package tests.herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.herokuapp.DynamicLoadingPage;
import utils.ConfigReader;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void verifyDynamicLoading() {
        open(ConfigReader.get("herokuUrl") + "dynamic_loading/1");
        DynamicLoadingPage page = new DynamicLoadingPage();
        page.clickStart();
        String text = page.getText();
        Assert.assertEquals(text, "Hello World!");
        Assert.assertFalse(text.isEmpty());
    }
}
