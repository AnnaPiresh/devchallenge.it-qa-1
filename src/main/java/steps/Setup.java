package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {

  static WebDriver driver;

  @Before
  public void init(){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--lang=en-GB");

    driver = new ChromeDriver(chromeOptions);
  }

  @After
  public void close(){
    driver.close();
  }
}
