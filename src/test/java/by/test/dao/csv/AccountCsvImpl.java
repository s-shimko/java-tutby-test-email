package by.test.dao.csv;

import by.test.models.Account;
import by.test.dao.AccountInfo;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static by.test.driver.Driver.PATH;

public class AccountCsvImpl implements AccountInfo {

  public ArrayList<Account> getAccounts() {
    final String csvFile = PATH + "/src/test/resources/account_data.csv";

    CSVReader reader;

    ArrayList<Account> accountList = new ArrayList<Account>();
    try {
      reader = new CSVReader(new FileReader(csvFile));
      String[] line;
      while ((line = reader.readNext()) != null) {
        accountList.add(new Account(line[0], line[1]));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return accountList;
  }
}

