package by.test.steps;

import by.test.driver.Driver;
import by.test.pages.LoginPage;
import by.test.pages.MenuPage;
import org.openqa.selenium.WebDriver;

import static by.test.driver.Driver.BROWSER;
import static by.test.helpers.WaitHelper.waitForPageTitle;
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
    waitForPageTitle("Яндекс.Почта");
  }

  public void checkEmail(String subject){
    MenuPage menuPage = new MenuPage(driver);
    assertTrue(menuPage.verifyMailPresent(subject));
  }

  public void logout() {
    MenuPage menuPage = new MenuPage(driver);
    menuPage.logout();
    waitForPageTitle("Яндекс");
  }
}
