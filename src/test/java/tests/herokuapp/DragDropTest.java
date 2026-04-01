package tests.herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.herokuapp.DragDropPage;
import utils.ConfigReader;

public class DragDropTest extends BaseTest{

    @Test
    public void verifyDragAndDrop() {
    	
        open(ConfigReader.get("herokuUrl") + "drag_and_drop");
        DragDropPage page = new DragDropPage();
        page.performDragDrop();
        Assert.assertEquals(page.getSourceText(), "B");
        Assert.assertEquals(page.getTargetText(), "A");
    }
}