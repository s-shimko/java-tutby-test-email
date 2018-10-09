package by.test.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static by.test.driver.Driver.getDriver;

public class WaitHelper {

  private static final int WAIT_TIME = 10;

  private static WebDriverWait getWait() {
    return new WebDriverWait(getDriver(), WAIT_TIME);
  }

  public static void waitForPageTitle(String title) {
    getWait().until(ExpectedConditions.titleIs(title));
  }

  public static void waitPageLoading() {
    ExpectedCondition<Boolean> expectation = new
            ExpectedCondition<Boolean>() {
              public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
              }
            };
    try {
      Thread.sleep(1000);
      WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_TIME);
      wait.until(expectation);
    } catch (Throwable error) {
      Assert.fail("Timeout waiting for Page Load Request to complete.");
    }
  }

  public static void waitSeconds(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
