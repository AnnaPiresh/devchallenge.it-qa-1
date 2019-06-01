package pages;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class HomePage extends BasePage {

  private WebDriverWait wait;
  private Actions actions;

  public HomePage(WebDriver driver){
    super(driver);
    wait = new WebDriverWait(driver, 15);
    actions = new Actions(driver);
  }

  @FindBy(xpath = "//span[text()='Article']/ancestor::li")
  private WebElement articleTab;

  @FindBy(xpath = "//span[text()='New']")
  private WebElement newItem;

  @FindBy(xpath = "//span[text()='Hotel']")
  private WebElement hotelItem;

  public void open(){
    driver.navigate().to("http://localhost:8080/article/faces/welcome.xhtml");
    log.info("Homepage is opened");
  }

  public HomePage hoverArticleTab(){
    actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(articleTab))).perform();

    log.info("Hovered over Article tab");
    return this;
  }

  public HomePage hoverOverNewItem(){
    actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(newItem))).perform();

    log.info("Hovered over New menu item");
    return this;
  }

  public void clickHotelItem(){
    actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(hotelItem))).click().perform();

    wait.until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor) driver)
        .executeScript("return document.readyState")
        .equals("complete"));

    log.info("Hotel menu item is clicked");
  }

}
