package by.test.steps;

import by.test.driver.Driver;
import by.test.pages.LoginPage;
import by.test.pages.MailPage;
import by.test.pages.MenuPage;
import org.openqa.selenium.WebDriver;

import static by.test.driver.Driver.BROWSER;
import static by.test.helpers.WaitHelper.waitForPageTitle;
import static by.test.helpers.WaitHelper.waitPageLoading;
import static org.testng.Assert.assertTrue;

public class Steps {

  private WebDriver driver;

  public void initDriver()
  {
    driver = Driver.init(System.getProperty("browser", BROWSER));
  }

  public void closeDriver()
  {
    Driver.close();
  }

  public void login(String username, String password) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.open();
    loginPage.login(username, password);
    waitForPageTitle("Яндекс.Паспорт");
    MenuPage menuPage = new MenuPage(driver);
    menuPage.open();
    waitPageLoading();
  }

  public void menuPagelogout() {
    MenuPage menuPage = new MenuPage(driver);
    menuPage.logout();
    waitForPageTitle("Авторизация");
  }

  public void mailPagelogout() {
    MailPage mailPage = new MailPage(driver);
    mailPage.logout();
    waitForPageTitle("Яндекс");
  }

  public void checkEmail(String subject){
    MailPage mailPage = new MailPage(driver);
    assertTrue(mailPage.verifyMailPresent(subject));
  }

}
