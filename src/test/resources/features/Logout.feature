Feature: User Logout Test
  @wip
  Scenario Outline: Successful logout
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    And The user clicks My Account dropdown button and clicks Logout button
    And The user clicks continue button for Logout
    Then The user verifies that user is logged out
    Examples:
      | email                | password   |
      | adminlast9@gmail.com | admin98765 |
