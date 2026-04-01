package tests.herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.herokuapp.FileUploadPage;
import utils.ConfigReader;

public class FileUploadTest extends BaseTest{

    @Test
    public void verifyFileUpload() {
        open(ConfigReader.get("herokuUrl") + "upload");
        FileUploadPage page = new FileUploadPage();
        String filePath = System.getProperty("user.dir") + "/src/test/resources/test.txt";
        page.uploadFile(filePath);
        Assert.assertEquals(page.getSuccessText(), "File Uploaded!");
        Assert.assertEquals(page.getUploadedFileName(), "test.txt");
    }
}