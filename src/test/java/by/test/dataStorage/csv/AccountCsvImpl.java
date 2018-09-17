package by.test.dataStorage.csv;

import by.test.dataStorage.AccountData;
import by.test.models.Account;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static by.test.driver.Driver.PATH;

public class AccountCsvImpl extends AccountData {

  private final String csvFile = PATH + "/src/test/resources/accounts_data.csv";

  public ArrayList<Account> getAccounts() {


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

