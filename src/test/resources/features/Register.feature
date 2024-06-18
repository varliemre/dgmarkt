Feature: As a user, I should be able to register on the website.

  Background:
    Given The user is on the Home page
    When The user navigates to the Register page

  Scenario Outline: Positive Register Test
    And The user register with "<First Name>" und "<Last Name>" und "<E-Mail>" "<Telephone>" und "<Password>" und "<Password Confirm>"
    Then User should see a registration confirmation message
    Examples:
      | First Name | Last Name | E-Mail               | Telephone   | Password   | Password Confirm |
      | admin9     | last      | adminlast9@gmail.com | 01798659885 | admin98765 | admin98765       |


  Scenario:  Registration with all fields left blank
    And The user clicks on the continue without filling in the required fields.
    Then Verify that the user cannot register

  @wip
  Scenario Outline:  Register by leaving one of the required fields blank
    And The user register with "<First Name>" und "<Last Name>" und "<E-Mail>" "<Telephone>" und "<Password>" und "<Password Confirm>"
    Then Verify that error message "<error message>"
    Examples:
      | First Name | Last Name | E-Mail               | Telephone   | Password   | Password Confirm | error message                                   |
      |            | last      | adminlast9@gmail.com | 01798659885 | admin98765 | admin98765       | First Name must be between 1 and 32 characters! |
      | admin9     |           | adminlast9@gmail.com | 01798659885 | admin98765 | admin98765       | Last Name must be between 1 and 32 characters!  |
      | admin9     | last      |                      | 01798659885 | admin98765 | admin98765       | E-Mail Address does not appear to be valid!     |
      | admin9     | last      | adminlast9@gmail.com |             | admin98765 | admin98765       | Telephone must be between 3 and 32 characters!  |
      | admin9     | last      | adminlast9@gmail.com | 01798659885 |            | admin98765       | Password must be between 4 and 20 characters!   |
      | admin9     | last      | adminlast9@gmail.com | 01798659885 | admin98765 |                  | Password confirmation does not match password!  |




