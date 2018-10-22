package by.test.helpers;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static by.test.driver.Driver.BROWSER;
import static by.test.helpers.RecipientType.TO;

public class MailHelper {

  public static void main(String[] args) throws MessagingException {
    String to = "sergey1shimko@gmail.com";
    String from = "testAccountForTestMail1@yandex.ru";
    final String username = "testAccountForTestMail1";
    final String password = "passwordForAccount1";
    final String subject = "To Subject";
    final String message_text = "Browser: " + BROWSER + ", Date: " + DateHelper.getDateTimeNow("yyyy.MM.dd_hh:mm:ss");
    final RecipientType recipientType = TO;

    sendMailSmtp(username, password, to, from, subject, message_text, recipientType);
  }

  private static void sendMailSmtp(final String username, final String password, String to, String from, String subject, String message_text, RecipientType recipientType) throws MessagingException {
    Properties props = new Properties();
    props.put("mail.smtp.host", DataHelper.get("smpt_host"));
    props.put("mail.smtp.auth", DataHelper.get("smpt_auth"));
    props.put("mail.smtp.port", DataHelper.get("smpt_port"));
    props.put("mail.smtp.socketFactory.port", DataHelper.get("smpt_socketFactory_port"));
    props.put("mail.smtp.socketFactory.class", DataHelper.get("smpt_socketFactory_class"));

    Session session = Session.getDefaultInstance(props,
            new Authenticator() {
              @Override
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
              }
            });

    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));

    switch (recipientType) {
      case TO:
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        break;
      case BCC:
        message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to));
        break;
      case CC:
        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to));
      default:
        System.out.println("Wrong recipient type!");

    }
    message.setSubject(subject);
    message.setText(message_text);
    Transport.send(message);
  }
}


