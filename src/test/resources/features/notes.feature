Feature: Verify that user can interact with Notes field

  Background:
    Given user opens hotel application
    And user navigates to Article > New > Hotel
    And "Notes" textarea is displayed in Data section

  Scenario: Verify that user can edit Notes field
    Then "Notes" textarea is editable

  Scenario: Verify it's possible to save empty field
    Given "Notes" textarea is empty
    And user clicks "Save" button
    Then validation message is not displayed near field

  Scenario: Verify it's possible to save field with valid value
    Given user enters alphanumeric characters to "Notes" textarea
    And user clicks "Save" button
    Then validation message is not displayed near field