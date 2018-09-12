package by.test.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

  protected WebDriver driver;

  public abstract void open();

  public AbstractPage(WebDriver driver)
  {
    this.driver = driver;
  }
}
