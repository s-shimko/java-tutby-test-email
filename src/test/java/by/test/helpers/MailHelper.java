package by.test.helpers;

import by.test.logger.Log;
import by.test.models.Mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHelper {

//  public static void main(String[] args) throws MessagingException {
//    String to = "sergey1shimko@gmail.com";
//    String from = "testAccountForTestMail1@yandex.ru";
//    final String username = "testAccountForTestMail1";
//    final String password = "passwordForAccount1";
//    final String subject = "To Subject";
//    final String message_text = "Browser: " + BROWSER + ", Date: " + DateHelper.getDateTimeNow("yyyy.MM.dd_hh:mm:ss");
//    final RecipientType recipientType = TO;
//
////    sendMailSmtp(username, password, to, from, subject, message_text, recipientType);
//  }


  public static void sendMailSmtp(Mail mail) {
    Properties props = new Properties();
    props.put("mail.smtp.host", DataHelper.get("smtp_host"));
    props.put("mail.smtp.auth", DataHelper.get("smtp_auth"));
    props.put("mail.smtp.port", DataHelper.get("smtp_port"));
    props.put("mail.smtp.socketFactory.port", DataHelper.get("smtp_socketFactory_port"));
    props.put("mail.smtp.socketFactory.class", DataHelper.get("smtp_socketFactory_class"));

    Session session = Session.getDefaultInstance(props,
            new Authenticator() {
              @Override
              public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mail.getUsername(), mail.getPassword());
              }
            });

    Message message = new MimeMessage(session);
    String subject = mail.getSubject();
    try {

      message.setFrom(new InternetAddress(mail.getFrom()));

      switch (mail.getRecipientType()) {
        case TO:
          message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getTo()));
          break;
        case BCC:
          message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(mail.getTo()));
          break;
        case CC:
          message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mail.getTo()));
        default:
          System.out.println("Wrong recipient type!");

      }
      message.setSubject(subject);
      message.setText(mail.getMessageText());
      Transport.send(message);

    } catch (MessagingException e) {
      e.printStackTrace();
    }
    Log.info("Email send from " + mail.getFrom() + " to " + mail.getTo());
    Log.info("Mail subject: " + subject);
  }
}


