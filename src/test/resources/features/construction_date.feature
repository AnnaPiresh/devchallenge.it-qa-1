Feature: Verify that user can add Date of Construction of new hotel

  Background:
    Given user opens hotel application
    And user navigates to Article > New > Hotel
    And "Date of Construction" field is displayed in Data section

  Scenario: Verify that user can edit Name field
    Then "Date of Construction" field is marked with asterisk
    And "Date of Construction" field is editable

  Scenario: Verify it's not possible to save empty field
    Given "Date of Construction" field is empty
    And user clicks "Save" button
    Then validation error message is displayed: "Validation Error: Value is required."
    And message contains field title: "Date of Construction"

  Scenario: Verify it's not possible to save field with invalid value
    Given user enters incorrect data format to "Date of Construction" field
    And user clicks "Save" button
    Then validation error message is displayed: "could not be understood as a date."
    And message contains field title: "Date of Construction"

  Scenario: Verify it's possible to save field with valid value
    Given user enters correct data format to "Date of Construction" field
    And user clicks "Save" button
    Then validation message is not displayed near field