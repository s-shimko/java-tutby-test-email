package by.test.runner;

import by.test.logger.Log;
import org.testng.annotations.Test;

public class TutbyEmailTest extends TestBase {

  @Test(groups = "active")
  public void test1() {
    Log.info("LoL info");
    Log.error("LoL error");
    steps.loginTutBy(user1.getLogin(), user1.getPassword());
//    steps.loginTutBy(user2.getLogin(), user2.getPassword());
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


}

