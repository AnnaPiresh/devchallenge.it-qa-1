package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.Date;
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
    capabilities.setCapability("enableVideo", true);
    capabilities.setCapability("videoName", "video"+ new Date().toString());
    capabilities.setCapability("enableLog", true);
    capabilities.setCapability("logName", "log"+ new Date().toString());
    ChromeOptions chromeOptions = new ChromeOptions();
      Map<String, Object> prefs = new HashMap<>();
      prefs.put("intl.accept_languages", "en-GB");
      chromeOptions.setExperimentalOption("prefs", prefs);
      chromeOptions.merge(capabilities);

      driver = new RemoteWebDriver(
        URI.create("http://172.17.0.4:4444/wd/hub").toURL(),
        chromeOptions
    );
  }

  @After
  public void close(){
    driver.close();
  }
}
