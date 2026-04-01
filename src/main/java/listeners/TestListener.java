package listeners;

import com.aventstack.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentLogger;
import utils.ExtentManager;
import utils.RetryAnalyzer;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();
        String packageName = result.getTestClass().getRealClass().getPackage().getName();
        String module = "";
        
        if (packageName.contains("automationexercise")) {
            module = "AE";
        } else if (packageName.contains("herokuapp")) {
            module = "Heroku";
        }
        ExtentTest extentTest = extent.createTest(
                "[" + module + "] " + className + " - " + methodName
        );

        test.set(extentTest);
        ExtentLogger.setTest(extentTest);

        if (module.equals("AE")) {
            extentTest.assignCategory("AutomationExercise");
        } else if (module.equals("Heroku")) {
            extentTest.assignCategory("HerokuApp");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String path = ScreenshotUtil.capture(result.getMethod().getMethodName());
        test.get().pass("Test Passed")
                .addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        int retryCount = result.getMethod().getCurrentInvocationCount();

        ExtentLogger.fail("Test failed on attempt: " + retryCount);

        String path = ScreenshotUtil.capture(result.getMethod().getMethodName());

        test.get().fail(result.getThrowable())
                .addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}