package by.test.dataStorage.db;

import by.test.dataStorage.AccountData;
import by.test.models.Account;

import java.util.ArrayList;

public class AccountDBImpl extends AccountData {


  public ArrayList<Account> getAccounts() {
    System.out.println("DB impl");
    return null;
  }
}
