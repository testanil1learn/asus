package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // Capture screenshot
        String path = ScreenshotUtil.captureScreenshot(
                result.getMethod().getMethodName());

        // Log failure + attach screenshot
        ExtentTestManager.getTest()
                .fail(result.getThrowable())
                .addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flush();
    }
}
