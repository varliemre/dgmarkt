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
  @wipe
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
  @wipt
  Scenario Outline: Twice Back Button After Successfully Logout
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    And The user clicks on the "Health & Beauty" from the category page
    And The user clicks My Account dropdown button and clicks Logout button
    And The user clicks continue button on existing page for Logout
    And The user clicks back button once more
    And The user clicks back button once more
    Then The user verifies that user is logged out on existing page
    Examples:
      | email                  | password   |
      | sdetkosovali@gmail.com | Bosnali123 |