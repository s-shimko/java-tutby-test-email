package by.test.pages;

import by.test.logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MailPage extends AbstractPage {

  @FindBy(xpath = "//span[@id='recipient-1']")
  private WebElement accountMailIcon;

  @FindBy(xpath = "//a[@data-metric='Выйти из сервисов Яндекса']")
  private WebElement logoutYandex;

  @FindBy(xpath = "//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']")
  private List<WebElement> mailList;

  @Override
  public void open() {
  }

  public MailPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  public void logout() {
    accountMailIcon.click();
    logoutYandex.click();
  }

  public boolean verifyMailPresent(String subject) {
    int flag = 0;
    for (WebElement m : mailList) {
      if (m.getText().equals(subject)) {
        flag = 1;
      }
    }
    if (flag > 0) {
      Log.info("Mail is present: " + subject);
      return true;
    } else {
      Log.error("Mail is not present: " + subject);
      return false;
    }
  }
}
