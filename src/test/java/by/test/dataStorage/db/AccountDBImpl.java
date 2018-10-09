package by.test.dataStorage.db;

import by.test.dataStorage.AccountData;
import by.test.helpers.SessionFactoryHelper;
import by.test.models.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class AccountDBImpl extends AccountData {

  private SessionFactory sessionFactory;

  public ArrayList<Account> getAccounts() {

    sessionFactory = SessionFactoryHelper.getSessionFactory();
    Session session = sessionFactory.openSession();

    session.beginTransaction();
    ArrayList<Account> result = (ArrayList<Account>) session.createQuery("from Account").list();
    for (Account account : result) {
      System.out.println(account);
    }
    session.getTransaction().commit();
    session.close();

    return result;
  }

}
