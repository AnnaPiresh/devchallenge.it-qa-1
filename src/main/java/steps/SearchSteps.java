package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.BrowserDataHelper;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

import static org.testng.Assert.assertTrue;


public class SearchSteps{

  private WebDriver driver = Setup.driver;

  private SearchPage searchPage = new SearchPage(driver);

  @And("^search results are matching the search term$")
  public void compare_search_results(){
    String term = BrowserDataHelper.browserData.get("search_term").toString();

    searchPage.getSearchTitles().forEach(title -> assertTrue(title.toLowerCase().contains(term.toLowerCase())));
  }

  @Then("^title of page is \"(.+)\"$")
  public void compare_page_title(String title){
    assertTrue(searchPage.getPageTitle().contains(title));
  }
}
