@B13DGMRAU-8
Feature: As a user, I should be able to change the password by clicking the Password tab under the My Account module.
  Acceptance Criteria :
  1- Verifies that the user can change the password.
  2- Verifies error message when user can't confirm password

  Background:
    Given The user logged in with valid credentials "adminlast11@gmail.com" and "admin12345678901" and is on the home page
    When The user navigates to the "My Account" page
    And The user goes to the Password tab

  @B13DGMRAU-48
  Scenario Outline:  The user changes password successfully
    Given The user enters the "<new password>" in the password field
    When The user enters the "<confirm password>" in the password confirm field
    And The user clicks the continue button
    Then Verify that the successful "<message>"
    Examples:
      | new password     | confirm password | message                                               |
      | admin12345678901 | admin12345678901 | Success: Your password has been successfully updated. |
      # NOT: Bu testi run etmeden önce new Password'u degitirmeyi unutma !!

  @B13DGMRAU-50
  Scenario Outline: The user enters different new password and confirm password
    Given The user enters the "<new password>" in the password field
    When The user enters the "<confirm password>" in the password confirm field
    And The user clicks the continue button
    Then The user should see an "<error message>" in Password Page
    Examples:
      | new password | confirm password | error message                                  |
      | 123456       | 123              | Password confirmation does not match password! |
      | 123456       |                  | Password confirmation does not match password! |
      |              | 123456           | Password must be between 4 and 20 characters!  |
      |              |                  | Password must be between 4 and 20 characters!  |

  @B13DGMRAU-51
  Scenario Outline: Verify that the password change process has a minimum length requirement
    Given The user enters the "<new password>" in the password field
    When The user enters the "<confirm password>" in the password confirm field
    And The user clicks the continue button
    Then The user should see an "<error message>" in Password Page
    Examples:
      | new password | confirm password | error message                                 |
      | 1            | 1                | Password must be between 4 and 20 characters! |
      | 12           | 12               | Password must be between 4 and 20 characters! |
      | 123          | 123              | Password must be between 4 and 20 characters! |
      | a            | a                | Password must be between 4 and 20 characters! |
      | ab           | ab               | Password must be between 4 and 20 characters! |
      | abc          | abc              | Password must be between 4 and 20 characters! |













