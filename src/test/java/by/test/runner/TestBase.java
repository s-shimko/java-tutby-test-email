package by.test.runner;

import by.test.dataStorage.AccountData;
import by.test.dataStorage.csv.AccountCsvImpl;
import by.test.dataStorage.db.AccountDBImpl;
import by.test.dataStorage.xml.AccountXmlImpl;
import by.test.helpers.ScreenshotHelper;
import by.test.listeners.TestListener;
import by.test.logger.Log;
import by.test.models.Account;
import by.test.steps.Steps;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;

@Listeners(TestListener.class)
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
  public void beforeMethod(ITestContext context) {
    Log.info("Start logging");
    steps = new Steps();
    steps.initDriver();
    Log.info("Driver initialized");
  }

  @AfterClass(groups = "active")
  public void afterMethod() {
    steps.closeDriver();
    Log.info("Driver is closed");
    Log.info("Stop logging");
  }

  @AfterMethod
  public void ifFailure(ITestResult testResult) throws IOException {
    ScreenshotHelper.takeScreenShotOnFailure(testResult);
  }
}
