package by.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class Driver {

  public static final String BROWSER = BrowserType.CHROME;
  public static final String PATH = System.getProperty("user.dir");

  private static WebDriver driver;
  private static final String GECKODRIVER = "webdriver.gecko.driver";
  private static final String GECKODRIVER_PATH = PATH + "/src/test/resources/webdrivers/geckodriver/0210/geckodriver";

  private static final String CHROMEDRIVER = "webdriver.chrome.driver";
  private static final String CHROMEDRIVER_PATH = PATH + "/src/test/resources/webdrivers/chromedriver/241/chromedriver";

  private Driver() {
  }

  public static WebDriver init(String browser) {
    if (null == driver) {
      if (browser.equals(BrowserType.FIREFOX)) {
        System.setProperty(GECKODRIVER, GECKODRIVER_PATH);
        driver = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
        System.setProperty(CHROMEDRIVER, CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
      }
      driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void close() {
    driver.quit();
    driver = null;
  }

  public static WebDriver getDriver() {
    return driver;
  }
}
