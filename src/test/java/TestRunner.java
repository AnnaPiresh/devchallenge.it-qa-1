import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import steps.Setup;

import java.util.concurrent.TimeUnit;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {"pretty", "html:target/cucumber-html-report"})

public class TestRunner extends AbstractTestNGCucumberTests {

  @BeforeSuite
  public void init(){
    WebDriverManager.chromedriver().setup();
    Setup.driver = new ChromeDriver();
    Setup.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterSuite
  public void close(){
    Setup.driver.quit();
  }
}
