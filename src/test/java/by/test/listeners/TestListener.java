package by.test.listeners;

import by.test.helpers.ScreenshotHelper;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {
  @Override
  public void onTestStart(ITestResult iTestResult) {

  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    try {
      ScreenshotHelper.takeScreenShotOnFailure(iTestResult);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
  }


  @Override
  public void onTestSkipped(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

  }

  @Override
  public void onStart(ITestContext iTestContext) {

  }

  @Override
  public void onFinish(ITestContext iTestContext) {

  }
}
