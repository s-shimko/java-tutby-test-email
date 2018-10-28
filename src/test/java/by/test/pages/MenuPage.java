package by.test.pages;

import by.test.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends AbstractPage {

  @FindBy(xpath = "//span[@id='recipient-1']")
  private WebElement accountMenuIcon;

  @FindBy(xpath = "//a[@data-metric='Выйти из сервисов Яндекса']")
  private WebElement logoutYandex;

  @Override
  public void open(){}

  public MenuPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  public void logout() {
    accountMenuIcon.click();
    logoutYandex.click();
  }

  public boolean verifyMailPresent(String subject) {
    String xpath = "//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']/span[@title='" + subject + "']";
    driver.findElement(By.xpath(xpath));
    if(!driver.findElements(By.xpath(xpath)).isEmpty()){
      Log.info("Mail is present");
      return true;
    }else{
      Log.error("Mail is not present");
      return false;
    }
  }
}
