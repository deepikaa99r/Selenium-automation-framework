package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import factory.DriverFactory;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

	public static String capture(String testName) {
	    File src = ((TakesScreenshot) DriverFactory.getDriver())
	            .getScreenshotAs(OutputType.FILE);

	    String relativePath = "reports/screenshots/" 
	            + testName + "_" + System.currentTimeMillis() + ".png";

	    File dest = new File(relativePath);

	    try {
	        FileHandler.copy(src, dest);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return dest.getAbsolutePath();
	}
}