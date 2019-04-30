package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class Setup {

  static WebDriver driver;

  @Before
  public void init() throws Throwable{
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName("chrome");
    capabilities.setVersion("latest");
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", false);
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--lang=en-GB");

    driver = new RemoteWebDriver(
        URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
        capabilities
    );
  }

  @After
  public void close(){
    driver.close();
  }
}
