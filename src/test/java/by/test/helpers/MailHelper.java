package by.test.helpers;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static by.test.driver.Driver.BROWSER;

public class MailHelper {

  public static void main(String[] args) throws MessagingException {
    // Recipient's email ID needs to be mentioned.
    String to = "sergey1shimko@gmail.com";

    // Sender's email ID needs to be mentioned
//    String from = "testaccountfortestmail1@tut.by";
    String from = "testAccountForTestMail1@yandex.ru";
    final String username = "testAccountForTestMail1";//change accordingly
    final String password = "passwordForAccount1";//change accordingly


    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.yandex.ru");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
              @Override
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
              }
            });

    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//    message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to));
//    message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to));
    message.setSubject("To Subject");
    message.setText("Browser: " + BROWSER + ", Date: " + DateHelper.getDateTimeNow("yyyy.MM.dd_hh:mm:ss"));

    Transport.send(message);

//    // Assuming you are sending email through relay.jangosmtp.net
//    String host = "smtp.yandex.ru";
//
//    Properties props = new Properties();
//    props.put("mail.smtp.auth", "true");
//    props.put("mail.smtp.starttls.enable", "true");
//    props.put("mail.smtp.host", host);
//    props.put("mail.smtp.port", "465");
//
//    // Get the Session object.
//    Session session = Session.getInstance(props,
//            new javax.mail.Authenticator() {
//              protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//              }
//            });
//
//    try {
//      // Create a default MimeMessage object.
//      Message message = new MimeMessage(session);
//
//      // Set From: header field of the header.
//      message.setFrom(new InternetAddress(from));
//
//      // Set To: header field of the header.
//      message.setRecipients(Message.RecipientType.TO,
//              InternetAddress.parse(to));
//
//      // Set Subject: header field
//      message.setSubject("Testing Subject");
//
//      // Now set the actual message
//      message.setText("Hello, this is sample for to check send " +
//              "email using JavaMailAPI ");
//
//      // Send message
//        Transport.send(message);
//
//      System.out.println("Sent message successfully....");
//
//    } catch (MessagingException e) {
//      throw new RuntimeException(e);
//    }
  }
}


