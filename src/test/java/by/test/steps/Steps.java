package by.test.steps;

import by.test.driver.Driver;
import by.test.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static by.test.driver.Driver.BROWSER;
import static by.test.helpers.WaitHelper.waitForPageTitle;

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

  public void loginTutBy(String username, String password) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.open();
    loginPage.login(username, password);
    waitForPageTitle("Яндекс.Почта");
  }
}
