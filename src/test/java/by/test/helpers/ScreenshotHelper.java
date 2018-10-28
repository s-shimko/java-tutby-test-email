package by.test.helpers;

import by.test.driver.Driver;
import by.test.logger.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static by.test.driver.Driver.PATH;

public class ScreenshotHelper {

  public static void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
    if (testResult.getStatus() == ITestResult.FAILURE) {
      System.out.println(PATH + "src/test/errorScreenshots" + testResult.getName() + "-"
              + Arrays.toString(testResult.getParameters()) + ".jpg");
      File scrFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
      FileHandler.copy(scrFile, new File(PATH + "/src/test/errorScreenshots" + testResult.getName() + "-"
              + Arrays.toString(testResult.getParameters()) + ".jpg"));
      Log.info("Screenshot captured");
    }
  }
}
