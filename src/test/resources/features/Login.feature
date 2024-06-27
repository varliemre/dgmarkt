
Feature: User Login Test

  Scenario Outline: Successful login with valid credentials
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    Then The user should see the message that you have successfully logged in
    Examples:
      | email              | password |
      | ertan986@gmail.com | 123456   |




