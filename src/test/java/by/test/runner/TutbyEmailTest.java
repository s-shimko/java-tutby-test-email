package by.test.runner;

import by.test.helpers.DateHelper;
import by.test.logger.Log;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static by.test.driver.Driver.BROWSER;

public class TutbyEmailTest extends TestBase {

  @Test(groups = "active")
  public void testEmailSending(Method method) {
    String messageSubject = BROWSER + " - " + DateHelper.getDateTimeNow("yyyy.MM.dd_hh:mm:ss");
    Log.info("Start test: " + method.getName());
//    Mail mail = new Mail.Builder()
//            .withFrom(user2.getEmail())
//            .withTo(user1.getEmail())
//            .withMessageText(messageSubject)
//            .withSubject(messageSubject)
//            .withUsername(user2.getLogin())
//            .withPassword(user2.getPassword())
//            .withRecipientType(RecipientType.TO)
//            .build();
//    MailHelper.sendMailSmtp(mail);

//    steps.login(user2.getLogin(), user2.getPassword());

    steps.login(user1.getLogin(), user1.getPassword());
    steps.checkEmail("chrome - 2018.10.27_05:37:11");
    steps.logout();
    Log.info("Finish log test: " + method.getName());
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

