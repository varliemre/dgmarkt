@US-09
Feature: As a user, I should be able to change the password by clicking the Password tab under the My Account module.

  Background:
    Given The user logged in with valid credentials "adminlast11@gmail.com" and "admin1212" and is on the home page
    When The user navigates to the "My Account" page
    And The user goes to the Password tab

  Scenario Outline:  The user changes password successfully
    Given The user enters the "<new password>" in the password field and password confirm field
    When The user clicks the continue button
    Then Verify that the successful "<message>"
    Examples:
      | new password | message                                               |
      | admin12345   | Success: Your password has been successfully updated. |








