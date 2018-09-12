package by.test.dao.db;

import by.test.models.Account;
import by.test.dao.AccountInfo;

import java.util.ArrayList;

public class AccountDBImpl implements AccountInfo {


  public ArrayList<Account> getAccounts() {
    System.out.println("DB impl");
    return null;
  }
}
