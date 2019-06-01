package pages;

import helpers.BrowserDataHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
public class NewHotelPage extends BasePage {

  private WebDriverWait wait;

  public NewHotelPage(WebDriver driver) {
    super(driver);
    wait = new WebDriverWait(driver, 15);
  }

  @FindBy(css = "h2")
  private WebElement header;

  @FindBy(id = "add_hotel")
  private WebElement dataSection;

  @FindBy(css = "button[id^='add_hotel']")
  private WebElement saveButton;

  @FindBy(css = ".ui-rating .ui-rating-star")
  private List<WebElement> ratingStars;

  @FindBy(className = "ui-rating-cancel")
  private WebElement clearRating;

  @FindBy(css = "[id='add_hotel:country_panel']")
  private WebElement countryDropdownValues;

  @FindBy(css = "[id='add_hotel:city_panel']")
  private WebElement cityDropdownValues;


  private WebElement fieldParent(String fieldName){
    return wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::tr", fieldName))));
  }

  private WebElement fieldInput(String fieldName){
    return fieldParent(fieldName).findElement(By.tagName("input"));
  }

  private WebElement fieldTextarea(String fieldName){
    return fieldParent(fieldName).findElement(By.tagName("textarea"));
  }

  public String getPageHeader() {
    String pageHeader = wait.until(ExpectedConditions.visibilityOf(header)).getText();

    log.info("Page header is {}", pageHeader);
    return pageHeader;
  }

  public boolean isDataSectionDisplayed(){
    return dataSection.isDisplayed();
  }

  public boolean isSaveButtonDisplayed() {
    return saveButton.isDisplayed();
  }

  public NewHotelPage clickSaveButton() {
    wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    return this;
  }

  public boolean isRequiredField(String fieldName){
    WebElement asterisks = fieldParent(fieldName).findElement(By.className("ui-outputlabel-rfi"));
    return asterisks.isDisplayed();
  }

  public boolean isFieldDisplayed(String fieldName){
    BrowserDataHelper.browserData.put("field", fieldName);
    return wait.until(ExpectedConditions.visibilityOf(fieldInput(fieldName))).isDisplayed();
  }

  public boolean isGlobalRatingDisplayed(){
    BrowserDataHelper.browserData.put("field", "Global Rating");
    return fieldParent("Global Rating").findElement(By.className("ui-rating")).isDisplayed();
  }

  public boolean isNotesFieldDisplayed(String areaName){
    BrowserDataHelper.browserData.put("field", areaName);
    return fieldTextarea(areaName).isDisplayed();
  }

  public boolean isFieldEditable(String fieldName){
    return fieldInput(fieldName).isEnabled();
  }

  public boolean isNotesEditable(String areaName){
    return fieldTextarea(areaName).isEnabled();
  }

  public NewHotelPage emptyField(String fieldName){
    wait.until(ExpectedConditions.elementToBeClickable(fieldInput(fieldName))).clear();
    return this;
  }

  public NewHotelPage emptyNotesField(String areaName){
    wait.until(ExpectedConditions.elementToBeClickable(fieldTextarea(areaName))).clear();
    return this;
  }

  public NewHotelPage enterRandomValueToField(String fieldName){
    int randomQty = new Random().nextInt(150);
    String randomAlphaNumeric = RandomStringUtils.randomAlphanumeric(randomQty);
    wait.until(ExpectedConditions.elementToBeClickable(fieldInput(fieldName))).sendKeys(randomAlphaNumeric);
    return this;
  }

  public NewHotelPage enterRandomToTextArea(String areaName){
    int randomQty = new Random().nextInt(150);
    String randomAlphaNumeric = RandomStringUtils.randomAlphanumeric(randomQty);
    wait.until(ExpectedConditions.elementToBeClickable(fieldTextarea(areaName))).sendKeys(randomAlphaNumeric);
    return this;
  }

  public boolean isValidationDisplayed(){
    String fieldName = BrowserDataHelper.browserData.get("field").toString();

    return fieldParent(fieldName).findElements(By.className("ui-message-error-icon")).size() > 0;
  }

  public String getValidationMessage(){
    String fieldName = BrowserDataHelper.browserData.get("field").toString();
    return fieldParent(fieldName).findElement(By.className("ui-message-error-detail")).getText();
  }

  public NewHotelPage enterInvalidDate(String fieldName) {
    Date date = new Date();
    wait.until(ExpectedConditions.elementToBeClickable(fieldInput(fieldName))).sendKeys(date.toString());
    return this;
  }

  public NewHotelPage enterValidDate(String fieldName) {
    SimpleDateFormat format = new SimpleDateFormat("M/dd/YY");
    String date = format.format(new Date());

    wait.until(ExpectedConditions.elementToBeClickable(fieldInput(fieldName))).sendKeys(date);
    return this;
  }

  public boolean isPossibleToSetRating(){
    boolean isEditable = false;

    for (WebElement star : ratingStars){
      star.click();
      isEditable = star.getAttribute("class").contains("ui-rating-star-on");
    }

    return isEditable;
  }

  public NewHotelPage clearGlobalRating(){
    wait.until(ExpectedConditions.elementToBeClickable(clearRating)).click();
    return  this;
  }

  public NewHotelPage selectGlobalRating(){
    int randomQty = new Random().nextInt(4);

    wait.until(ExpectedConditions.elementToBeClickable(ratingStars.get(randomQty))).click();
    return this;
  }

  public boolean isDropdownDisplayed(String dropdownName){
    return fieldParent(dropdownName).findElement(By.className("ui-selectonemenu")).isDisplayed();
  }

  public NewHotelPage notSelectDropdownValue(String dropdownName){
    WebElement element = dropdownName.contains("Country") ? countryDropdownValues : cityDropdownValues;
    BrowserDataHelper.browserData.put("field", dropdownName);

    wait.until(ExpectedConditions.elementToBeClickable(fieldParent(dropdownName))).click();
    wait.until(ExpectedConditions.visibilityOf(element));

    return this;
  }

  public NewHotelPage selectDropdownValue(String dropdownName, String value){
    WebElement element = dropdownName.contains("Country") ? countryDropdownValues : cityDropdownValues;
    BrowserDataHelper.browserData.put("field", dropdownName);
    String selector = String.format("[data-label='%s']", value);

    wait.until(ExpectedConditions.elementToBeClickable(fieldParent(dropdownName))).click();
    wait.until(ExpectedConditions.visibilityOf(element));
    element.findElement(By.cssSelector(selector)).click();
    wait.until(ExpectedConditions.textToBePresentInElement(fieldParent(dropdownName), value));

    return this;
  }
}
