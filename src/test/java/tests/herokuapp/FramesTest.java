package tests.herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.herokuapp.FramesPage;
import utils.ConfigReader;

public class FramesTest extends BaseTest {

    @Test
    public void verifyIframe() {
        open(ConfigReader.get("herokuUrl") + "iframe");
        FramesPage page = new FramesPage();
        page.switchToFrame();
        String text = page.getText();
        Assert.assertTrue(text.contains("Your content goes here."));
    }
}