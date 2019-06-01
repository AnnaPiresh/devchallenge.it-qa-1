Feature: Verify that user can open New Hotel page

  Background:
    Given user opens hotel application
    And user navigates to Article > New > Hotel

  Scenario: Verify Register new Hotel page is displayed
    Then header of the page is "Register new Hotel"
    And data section is displayed
    And "Save" button is displayed


