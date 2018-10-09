package by.test.pages;

import by.test.helpers.DataHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

  private final String BASE_URL = DataHelper.get("host");

  @FindBy(xpath = ".//input[@name='login']")
  private WebElement inputLogin;

  @FindBy(xpath = ".//input[@name='password']")
  private WebElement inputPass;

  @FindBy(xpath = ".//input[@type='submit']")
  private WebElement buttonSubmit;


  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  public void open() {
    driver.get(BASE_URL);
  }

  public void login(String login, String pass) {
    inputLogin.sendKeys(login);
    inputPass.sendKeys(pass);
    buttonSubmit.click();
  }
}
