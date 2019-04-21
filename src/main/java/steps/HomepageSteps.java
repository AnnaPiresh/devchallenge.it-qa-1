package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomepageSteps {

  private WebDriver driver = Setup.driver;

  private HomePage homepage = new HomePage(driver);

  @Given("^user opens Google homepage$")
  public void open_google_homepage(){
    driver.navigate().to("https://www.google.com/");
  }

  @Given("^user enters search term \"(.+)\"$")
  public void enter_search_term(String term){
    homepage.enterSearchTerm(term);
  }

  @And("^presses Enter on keyboard$")
  public void press_enter(){
    homepage.clickEnterKey();
  }
}
