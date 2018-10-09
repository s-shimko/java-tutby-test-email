package by.test.runner;

import by.test.dataStorage.AccountData;
import by.test.dataStorage.csv.AccountCsvImpl;
import by.test.dataStorage.db.AccountDBImpl;
import by.test.dataStorage.xml.AccountXmlImpl;
import by.test.driver.Driver;
import by.test.logger.Log;
import by.test.models.Account;
import by.test.steps.Steps;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import static by.test.driver.Driver.PATH;

public abstract class TestBase {
  Steps steps;
  Account user1;
  Account user2;

  @BeforeSuite(groups = "active")
  public void chooseDataStorage() {
    int input = 1;
    AccountData data = null;

    switch (input) {
      case 1:
        data = new AccountCsvImpl();
        break;

      case 2:
        data = new AccountXmlImpl();
        break;

      case 3:
        data = new AccountDBImpl();
        break;

      default:
        throw new IllegalArgumentException("Not implemented data input: " + input);
    }
    setAccounts(data);
  }

  private void setAccounts(AccountData data) {
    ArrayList<Account> accounts = data.getAccounts();
    user1 = accounts.get(0);
    user2 = accounts.get(1);
  }

  @BeforeClass(groups = "active")
  public void beforeMethod() {
    steps = new Steps();
    steps.initDriver();

  }

  @AfterClass(groups = "active")
  public void afterMethod() {
    steps.closeDriver();
  }

  @BeforeMethod(alwaysRun = true)
  public void logTestStart(Method m) {
    Log.info("Start logging: " + m.getName());
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    Log.info("Stop logging: " + m.getName());
  }

  @AfterMethod
  public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
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
