Feature: Verify that user can interact with Country field

  Background:
    Given user opens hotel application
    And user navigates to Article > New > Hotel
    And "City" dropdown is displayed in Data section

  Scenario: Verify that user can edit Name field
    Then "City" field is marked with asterisk
    And "City" field is editable

  Scenario: Verify it's not possible to save empty field
    Given value of "City" field is not selected
    And user clicks "Save" button
    Then validation error message is displayed: "Validation Error: Value is required."
    And message contains field title: "City"

  Scenario: Verify it's possible to save field with valid value
    Given value of "Country" field is selected: "Ukraine"
    When value of "City" field is selected: "Kharkiv"
    And user clicks "Save" button
    Then validation message is not displayed near field