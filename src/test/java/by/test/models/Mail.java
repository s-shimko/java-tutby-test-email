package by.test.models;

import by.test.helpers.RecipientType;

public class Mail {
//  private String to = "sergey1shimko@gmail.com";
//  private String from = "testAccountForTestMail1@yandex.ru";
//  private String username = "testAccountForTestMail1";
//  private String password = "passwordForAccount1";
//  private String subject = "To Subject";
//  private String message_text = "Browser: " + BROWSER + ", Date: " + DateHelper.getDateTimeNow("yyyy.MM.dd_hh:mm:ss");
//  private RecipientType recipientType = TO;

  private String to;
  private String from;
  private String username;
  private String password;
  private String subject;
  private String messageText;
  private RecipientType recipientType;

  public static class Builder {
    private Mail newMail;

    public Builder() {
      newMail = new Mail();
    }

    public Builder withTo(String to) {
      newMail.to = to;
      return this;
    }

    public Builder withFrom(String from) {
      newMail.from = from;
      return this;
    }

    public Builder withUsername(String username) {
      newMail.username = username;
      return this;
    }

    public Builder withPassword(String password) {
      newMail.password = password;
      return this;
    }

    public Builder withSubject(String subject) {
      newMail.subject = subject;
      return this;
    }

    public Builder withMessageText(String messageText) {
      newMail.messageText = messageText;
      return this;
    }

    public Builder withRecipientType(RecipientType recipientType) {
      newMail.recipientType = recipientType;
      return this;
    }

    public Mail build() {
      return newMail;
    }
  }

  public String getTo() {
    return to;
  }

  public String getFrom() {
    return from;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getSubject() {
    return subject;
  }

  public String getMessageText() {
    return messageText;
  }

  public RecipientType getRecipientType() {
    return recipientType;
  }

  @Override
  public String toString() {
    return "Mail{" +
            "to='" + to + '\'' +
            ", from='" + from + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", subject='" + subject + '\'' +
            ", messageText='" + messageText + '\'' +
            ", recipientType=" + recipientType +
            '}';
  }
}
