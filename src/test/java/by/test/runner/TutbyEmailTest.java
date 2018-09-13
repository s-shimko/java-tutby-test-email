package by.test.runner;

import by.test.models.Account;
import by.test.dataStorage.csv.AccountCsvImpl;
import by.test.dataStorage.db.AccountDBImpl;
import by.test.dataStorage.xml.AccountXmlImpl;
import by.test.steps.Steps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TutbyEmailTest {

  private Steps steps;
  private ArrayList<Account> accounts;
  private Account user1;
  private Account user2;

  @BeforeSuite(groups = "active")
  public void chooseDataStorage() {
//    printMenu();
    int input = 2;

    do {
//        input = readUserInput();

      switch (input) {
        case 1:
          AccountCsvImpl csv = new AccountCsvImpl();
          accounts = csv.getAccounts();
          break;

        case 2:
          AccountXmlImpl xml = new AccountXmlImpl();
          accounts = xml.getAccounts();
          break;

        case 3:
          AccountDBImpl db = new AccountDBImpl();
          accounts = db.getAccounts();
          break;

        default:
          System.out.println("Input not implemented");
      }
    } while (input < 0 && input > 3);
    user1 = accounts.get(0);
    user2 = accounts.get(1);
  }

  @BeforeClass(groups = "active")
  public void beforeMethod() {
    steps = new Steps();
    steps.initDriver();

  }

  @Test(groups = "active")
  public void test1() {
    steps.loginTutBy(user1.getLogin(), user1.getPassword());
    steps.loginTutBy(user2.getLogin(), user2.getPassword());
  }

//  @Test(groups = "postponed")
//  public void test2() {
//    System.out.println("Start test2");
//    SoftAssert s = new SoftAssert();
//    s.assertEquals(2 * 2, 5, "five");
//    s.assertEquals(2 * 2, 4, "four");
//    s.assertAll();
//  }
//
  @AfterClass(groups = "active")
  public void afterMethod() {
    steps.closeDriver();
  }


}

