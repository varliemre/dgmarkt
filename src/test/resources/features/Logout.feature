Feature: User Logout Test
  @wip
  Scenario Outline: Successfully Logout
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    And The user clicks My Account dropdown button and clicks Logout button
    And The user clicks continue button for Logout
    Then The user verifies that user is logged out
    Examples:
      | email                  | password   |
      | sdetkosovali@gmail.com | Bosnali123 |
  @wip
  Scenario Outline: Back Button After Successfully Logout
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    And The user clicks My Account dropdown button and clicks Logout button
    And The user clicks continue button for Logout
    And The user clicks back button
    Then The user verifies that user is logged out
    Examples:
      | email                  | password   |
      | sdetkosovali@gmail.com | Bosnali123 |
  @wip
  Scenario Outline: Twice Back Button After Successfully Logout
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    And The user clicks My Account dropdown button and clicks Logout button
    And The user clicks continue button for Logout
    And The user clicks back button
    And The user clicks back button
    Then The user verifies that user is logged out
    Examples:
      | email                  | password   |
      | sdetkosovali@gmail.com | Bosnali123 |