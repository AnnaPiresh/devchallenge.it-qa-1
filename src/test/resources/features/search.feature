Feature: Verify user can search using Google

  Background:
    Given user opens Google homepage

  Scenario: Verify user can search for a search term
    Given user enters search term "Epam"
    And presses Enter on keyboard
    Then title of page is "Google Search"
    And search results are matching the search term