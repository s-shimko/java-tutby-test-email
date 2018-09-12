package by.test.dao.xml;

import by.test.models.Account;
import by.test.dao.AccountInfo;

import java.util.ArrayList;

public class AccountXmlImpl implements AccountInfo {

  public ArrayList<Account> getAccounts() {
    System.out.println("XML impl");
    return null;
  }
}
