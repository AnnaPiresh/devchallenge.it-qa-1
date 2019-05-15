package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

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
      Map<String, Object> prefs = new HashMap<>();
      prefs.put("intl.accept_languages", "en-GB");
      chromeOptions.setExperimentalOption("prefs", prefs);

      driver = new RemoteWebDriver(
        URI.create("http://172.17.0.4:4444/wd/hub").toURL(),
        capabilities
    );
  }

  @After
  public void close(){
    driver.close();
  }
}
