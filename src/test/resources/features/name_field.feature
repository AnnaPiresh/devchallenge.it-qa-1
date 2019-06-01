Feature: Verify that user can interact with Name field

  Background:
    Given user opens hotel application
    And user navigates to Article > New > Hotel
    And "Name" field is displayed in Data section

  Scenario: Verify that user can edit Name field
    Then "Name" field is marked with asterisk
    And "Name" field is editable

  Scenario: Verify it's not possible to save empty field
    Given "Name" field is empty
    And user clicks "Save" button
    Then validation error message is displayed: "Validation Error: Value is required."
    And message contains field title: "Name"

  Scenario: Verify it's possible to save field with valid value
    Given user enters alphanumeric characters to "Name" field
    And user clicks "Save" button
    Then validation message is not displayed near field