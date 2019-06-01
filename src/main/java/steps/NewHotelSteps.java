package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import pages.NewHotelPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class NewHotelSteps {

  private NewHotelPage newHotel;

  public NewHotelSteps() {
    newHotel = new NewHotelPage(Setup.driver);
  }


  @Given("^\"(.+)\" field is displayed in Data section$")
  public void verify_field_is_displayed_by_name(String fieldName){
    assertTrue(newHotel.isFieldDisplayed(fieldName));
  }

  @Given("^\"(.+)\" field is empty$")
  public void empty_field_by_name(String fieldName){
    newHotel.emptyField(fieldName);
  }

  @Given("^\"(.+)\" textarea is empty$")
  public void empty_notes_field(String areaName){
    newHotel.emptyNotesField(areaName);
  }

  @Given("^user enters alphanumeric characters to \"(.+)\" field$")
  public void enter_alphanumeric_to_field_by_name(String fieldName){
    newHotel.enterRandomValueToField(fieldName);
  }

  @Given("^user enters alphanumeric characters to \"(.+)\" textarea$")
  public void enter_alphanumeric_to_notes(String areaName){
    newHotel.enterRandomToTextArea(areaName);
  }

  @Given("^user enters incorrect data format to \"(.+)\" field$")
  public void enter_invalid_date(String fieldName){
    newHotel.enterInvalidDate(fieldName);
  }

  @Given("^user enters correct data format to \"(.+)\" field$")
  public void enter_valid_date(String fieldName){
    newHotel.enterValidDate(fieldName);
  }

  @Given("^\"Global Rating\" field value is not selected$")
  public void clear_global_field_value(){
    newHotel.clearGlobalRating();
  }

  @Given("^\"Global Rating\" field value is selected$")
  public void select_global_rating_value(){
    newHotel.selectGlobalRating();
  }

  @Given("^value of \"(.+)\" field is not selected$")
  public void not_select_dropdown_value(String dropdownName){
    newHotel.notSelectDropdownValue(dropdownName);
  }

  @Given("^value of \"(.+)\" field is selected: \"(.+)\"$")
  public void select_dropdown_value(String dropdownName, String value){
    newHotel.selectDropdownValue(dropdownName, value);
  }

  @And("^data section is displayed$")
  public void verify_data_section_display() {
    assertTrue(newHotel.isDataSectionDisplayed());
  }

  @And("^\"Save\" button is displayed$")
  public void verify_save_button_display() {
    assertTrue(newHotel.isSaveButtonDisplayed());
  }

  @And("^\"(.+)\" field is marked with asterisk$")
  public void verify_field_has_asterisk_by_name(String fieldName){
    assertTrue(newHotel.isRequiredField(fieldName));
  }

  @And("^\"(.+)\" field is editable$")
  public void is_field_editable_by_name(String fieldName){
    assertTrue(newHotel.isFieldEditable(fieldName));
  }

  @And("^user clicks \"Save\" button$")
  public void click_save_button(){
    newHotel.clickSaveButton();
  }

  @And("^\"Global Rating\" select is displayed in Data section$")
  public void check_global_rating_display(){
    assertTrue(newHotel.isGlobalRatingDisplayed());
  }

  @And("^\"(.+)\" dropdown is displayed in Data section$")
  public void check_dropdown_is_displayed(String dropdownName){
    assertTrue(newHotel.isDropdownDisplayed(dropdownName));
  }

  @And("^\"(.+)\" textarea is displayed in Data section$")
  public void check_notes_field(String areaName){
    assertTrue(newHotel.isNotesFieldDisplayed(areaName));
  }

  @Then("^\"(.+)\" textarea is editable$")
  public void check_notes_editable(String areaName){
    assertTrue(newHotel.isNotesEditable(areaName));
  }

  @Then("^header of the page is \"(.+)\"")
  public void check_page_header(String header) {
    assertEquals(newHotel.getPageHeader(), header);
  }

  @Then("^validation error message is displayed: \"(.+)\"$")
  public void check_validation_message_present(String message){
    assertTrue(newHotel.isValidationDisplayed());
    assertTrue(StringUtils.containsIgnoreCase(newHotel.getValidationMessage(), message));
  }

  @Then("^validation message is not displayed near field$")
  public void check_no_validation_message(){
    assertFalse(newHotel.isValidationDisplayed());
  }

  @Then("^message contains field title: \"(.+)\"$")
  public void check_validation_contain_field_name(String fieldName){
    assertTrue(newHotel.getValidationMessage().contains(fieldName));
  }

  @Then("^\"Global Rating\" field allows to enter rating of the hotel$")
  public void check_possible_to_enter_rating(){
    assertTrue(newHotel.isPossibleToSetRating());
  }
}
