Feature: As a user, I should be able to change the password by clicking the Password tab under the My Account module.
  Acceptance Criteria :
  1-Verifies that the user can change the password.
  2-Verifies error message when user can't confirm password
  3-Verify error message when is given the same password
  4-Verify error message with blank input boxes
  5-Verify error message when is password out of boundary

  Background:
    Given The user logged in with valid credentials "adminlast11@gmail.com" and "admin1234567890" and is on the home page
    When The user navigates to the "My Account" page
    And The user goes to the Password tab


  Scenario Outline:  The user changes password successfully
    Given The user enters the "<new password>" in the password field
    When The user enters the "<confirm password>" in the password confirm field
    And The user clicks the continue button
    Then Verify that the successful "<message>"
    Examples:
      | new password    | confirm password | message                                               |
      | admin1234567890 | admin1234567890  | Success: Your password has been successfully updated. |
      # NOT: Bu testi run etmeden önce new Password'u degitirmeyi unutma !!



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

  @US-09
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













