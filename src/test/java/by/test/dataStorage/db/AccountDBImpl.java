package by.test.dataStorage.db;

import by.test.models.Account;
import by.test.dataStorage.AccountInfo;

import java.util.ArrayList;

public class AccountDBImpl implements AccountInfo {


  public ArrayList<Account> getAccounts() {
    System.out.println("DB impl");
    return null;
  }
}
