package by.test.models;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

  @Id
  @Column(name = "id")
  @Type(type = "int")
  public int id;

  @Column(name = "login")
  @Type(type = "text")
  private String login;

  @Column(name = "password")
  @Type(type = "text")
  private String password;

  @Column(name = "email")
  @Type(type = "text")
  private String email;

  public Account() {
  }

  public Account(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public Account(String login, String password, String email) {
    this.login = login;
    this.password = password;
    this.email = email;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Account{" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
