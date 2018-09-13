package by.test.dataStorage.xml;

import by.test.models.Account;
import by.test.dataStorage.AccountInfo;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import static by.test.driver.Driver.PATH;

public class AccountXmlImpl implements AccountInfo {

  private final String xmlFile = PATH + "/src/test/resources/accounts_data.xml";

  public ArrayList<Account> getAccounts() {
    ArrayList<Account> accountList = new ArrayList<Account>();

    DOMParser parser = new DOMParser();

    try {
      parser.parse(xmlFile);
      Document document = parser.getDocument();
      accountList = parseDocument(document);
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return accountList;
  }

  private ArrayList<Account> parseDocument(Document document) {
    ArrayList<Account> accountList = new ArrayList<Account>();
    Element root = document.getDocumentElement();
    String login;
    String password;

    NodeList nodes = root.getElementsByTagName("user");
    for (int i = 0; i < nodes.getLength(); i++) {
       Element currentNode = (Element) nodes.item(i);
      login = currentNode.getElementsByTagName("login").item(0).getTextContent().trim();
      password = currentNode.getElementsByTagName("password").item(0).getTextContent().trim();
      Account account = new Account(login, password);
      accountList.add(account);
    }

    return accountList;
  }

}