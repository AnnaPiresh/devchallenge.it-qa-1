package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.HomePage;

public class HomepageSteps {

  private HomePage homepage;

  public HomepageSteps() {
    homepage = new HomePage(Setup.driver);
  }

  @Given("^user opens hotel application$")
  public void open_application(){
    homepage.open();
  }

  @And("^user navigates to Article > New > Hotel$")
  public void open_new_hotel(){
    homepage.hoverArticleTab()
            .hoverOverNewItem()
            .clickHotelItem();
  }
}
