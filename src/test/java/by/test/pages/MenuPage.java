package by.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends AbstractPage {

  @FindBy(xpath = "//div[@class='user-pic user-account__pic']")
  private WebElement accountMenuIcon;

  @FindBy(xpath = "//a[@class='menu__item user2__menu-item user2__menu-item_type_link user2__menu-item_action_mail menu__item menu__item_type_link']")
  private WebElement emailMenuLink;

  @FindBy(xpath = "//a[@class='menu__item user2__menu-item user2__menu-item_type_link user2__menu-item_action_exit menu__item menu__item_type_link']")
  private WebElement logoutYandex;

  @Override
  public void open(){
    accountMenuIcon.click();
    emailMenuLink.click();
  }

  public MenuPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  public void logout() {
    accountMenuIcon.click();
    logoutYandex.click();
  }

}
