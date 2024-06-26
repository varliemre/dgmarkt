Feature: Category Module

  Background:
    Given The user is on the Home page

  @B13DGMRAU-46
  Scenario: Navigate to Sub-Category
    When The user navigates to the "Category Name" category
    And The user selects the "Sub-Category Name" sub-category
    Then The user should see the Sub-Category page

  Scenario: Navigate through Sub-Category Tabs
    When The user navigates to the "Category Name" category
    And The user selects the "Sub-Category Name" sub-category
    And The user navigates through the following tabs:
      | Tab Name  |
      |  Health & Beauty  |
      | Televisions     |
      | Tv Accessories    |
      | Networking        |
    Then Each tab should display the correct content

  Scenario: Click buttons and verify navigation
    When The user navigates to the "Category Name" category
    And The user selects the "Sub-Category Name" sub-category
    And The user clicks on the following buttons:
      | Button Name  |
      | Health & Beauty  |
      | Televisions     |
      | Tv Accessories    |
      | Networking    |
    Then Each button should navigate to the correct page

