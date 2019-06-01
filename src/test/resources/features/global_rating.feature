Feature: Verify that user can interact with Global Rating value

  Background:
    Given user opens hotel application
    And user navigates to Article > New > Hotel
    And "Global Rating" select is displayed in Data section

  Scenario: Verify that user can set Global Rating of the hotel 0-5 stars
    Then "Global Rating" field allows to enter rating of the hotel

  Scenario: Verify it's possible to save hotel without selecting Global Rating
    Given "Global Rating" field value is not selected
    And user clicks "Save" button
    Then validation message is not displayed near field

  Scenario: Verify it's possible to save hotel with valid value of Global Rating
    Given "Global Rating" field value is selected
    And user clicks "Save" button
    Then validation message is not displayed near field