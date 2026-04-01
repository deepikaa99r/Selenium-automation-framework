package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int maxRetries = 1;

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetries) {
            count++;

            ExtentLogger.info("Retrying test: Attempt " + count);

            return true;
        }

        return false;
    }
}