
Feature: Search Icon Function
  Background:
    Given The user is on the Home page

  Scenario: Product is displayed when the user searches for the item on the website
    Given The user clicks to "Search button"
    Then The user clicks the "Search area"
    Then The user should write "TV" at searching area and click "Search Button"
    And Verify that "Search TV" screen is displayed
    And Verify that displayed "Product" contains TV

  Scenario: The message "product not found" is displayed when the user searches for the item that is not on the website
    Given The user clicks to "Search button"
    Then The user clicks the "Search area"
    Then The user can write "apple" at searching area and click "Search Button"
    And Verify that "There is no product that matches the search criteria" message is displayed


