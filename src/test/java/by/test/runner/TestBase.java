package by.test.runner;

import by.test.dataStorage.AccountData;
import by.test.dataStorage.csv.AccountCsvImpl;
import by.test.dataStorage.db.AccountDBImpl;
import by.test.dataStorage.xml.AccountXmlImpl;
import by.test.models.Account;
import by.test.steps.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class TestBase {
  Logger logger = LoggerFactory.getLogger(TutbyEmailTest.class);

  Steps steps;
  Account user1;
  Account user2;

  @BeforeSuite(groups = "active")
  public void chooseDataStorage() {
    int input = 3;
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
        System.out.println("Not implemented");
    }

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
  public void logTestStart(Method m, Object[] p){
    logger.info("Start test" + m.getName() + "with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop test" + m.getName());
  }

}
