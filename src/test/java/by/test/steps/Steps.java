package by.test.steps;

import by.test.driver.Driver;
import by.test.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

public class Steps {

  private WebDriver driver;

  public void initDriver()
  {
    driver = Driver.init(BrowserType.CHROME);
  }

  public void closeDriver()
  {
    Driver.close();
  }

  public void loginTutBy(String username, String password) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.open();
    loginPage.login(username, password);
  }
}
