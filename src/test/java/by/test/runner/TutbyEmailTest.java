package by.test.runner;

import by.test.helpers.DateHelper;
import by.test.logger.Log;
import org.testng.annotations.Test;

import static by.test.driver.Driver.BROWSER;

public class TutbyEmailTest extends TestBase {

  @Test(groups = "active")
  public void testEmailSending() {
    String messageSubject = BROWSER + " - " + DateHelper.getDateTimeNow("yyyy.MM.dd_hh:mm:ss");
    Log.info("Log info");
    Log.error("Log error");
//    Mail mail = new Mail.Builder()
//            .withFrom(user1.getEmail())
//            .withTo(user2.getEmail())
//            .withMessageText(messageSubject)
//            .withSubject(messageSubject)
//            .withUsername(user1.getLogin())
//            .withPassword(user1.getPassword())
//            .withRecipientType(RecipientType.TO)
//            .build();
    steps.loginTutBy(user1.getLogin(), user1.getPassword());
    System.out.println(user1.getEmail());
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

