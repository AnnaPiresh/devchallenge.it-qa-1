package pages;

import helpers.BrowserDataHelper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class HomePage extends BasePage {

  private WebDriverWait wait;

  @FindBy(name = "q")
  private WebElement searchField;

  public HomePage(WebDriver driver){
    super(driver);
    wait = new WebDriverWait(driver, 15);
  }

  public HomePage enterSearchTerm(String term){
    wait.until(ExpectedConditions.elementToBeClickable(searchField));
    searchField.sendKeys(term);

    BrowserDataHelper.browserData.put("search_term", term);
    log.info("Search term '{}' was enetered into search field", term);

    return this;
  }

  public HomePage clickEnterKey(){
    searchField.sendKeys(Keys.ENTER);
    log.info("'Enter' button is clicked");

    return this;
  }
}
