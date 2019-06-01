Feature: Verify that user can interact with Description field

  Background:
    Given user opens hotel application
    And user navigates to Article > New > Hotel
    And "Description" field is displayed in Data section

  Scenario: Verify that user can edit Description field
    Then "Description" field is marked with asterisk
    And "Description" field is editable

  Scenario: Verify it's not possible to save empty field
    Given "Description" field is empty
    And user clicks "Save" button
    Then validation error message is displayed: "Validation Error: Value is required."
    And message contains field title: "Description"

  Scenario: Verify it's possible to save field with valid value
    Given user enters alphanumeric characters to "Description" field
    And user clicks "Save" button
    Then validation message is not displayed near field