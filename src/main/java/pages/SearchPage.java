package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class SearchPage extends BasePage {

  private WebDriverWait wait;

  @FindBy(css = "a h3")
  private List<WebElement> results;

  public SearchPage(WebDriver driver){
    super(driver);
    wait = new WebDriverWait(driver, 15);
  }

  public String getPageTitle(){
    wait.until(ExpectedConditions.urlContains("search"));
    return driver.getTitle();
  }

  public List<String> getSearchTitles(){
    return results.stream().map(WebElement::getText).collect(Collectors.toList());
  }
}
