package by.test.runner;

import by.test.helpers.DateHelper;
import by.test.helpers.MailHelper;
import by.test.helpers.RecipientType;
import by.test.logger.Log;
import by.test.models.Mail;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static by.test.driver.Driver.BROWSER;

public class TutbyEmailTest extends TestBase {

  @Test(groups = "active")
  public void testEmailSending(Method method) {
    String messageSubject = BROWSER + " - " + DateHelper.getDateTimeNow("yyyy.MM.dd_hh:mm:ss");
    Log.info("Start test: " + method.getName());
    Mail mail = new Mail.Builder()
            .withFrom(user2.getEmail())
            .withTo(user1.getEmail())
            .withMessageText(messageSubject)
            .withSubject(messageSubject)
            .withUsername(user2.getLogin())
            .withPassword(user2.getPassword())
            .withRecipientType(RecipientType.TO)
            .build();
    MailHelper.sendMailSmtp(mail);
    steps.login(user1.getLogin(), user1.getPassword());
    steps.checkEmail(messageSubject);
    steps.mailPagelogout();
    Log.info("Test successfully finished: " + method.getName());
  }

}

