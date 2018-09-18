package by.test.runner;

import org.testng.annotations.Test;

public class TutbyEmailTest extends TestBase {


  @Test(groups = "active")
  public void test1() {
    logger.info("Start test1");
    steps.loginTutBy(user1.getLogin(), user1.getPassword());
    steps.loginTutBy(user2.getLogin(), user2.getPassword());
    logger.info("Stop test1");

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

