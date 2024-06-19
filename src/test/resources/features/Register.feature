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


  Scenario Outline: The user should be able to enter the password field between 4 and 20 characters.
    And The user register with "<First Name>" und "<Last Name>" und "<E-Mail>" "<Telephone>" und "<Password>" und "<Password Confirm>"
    Then Verify that error message "<error message>"
    Examples:
      | First Name | Last Name | E-Mail                 | Telephone  | Password                                           | Password Confirm                                  | error message                                 |
      | Saul       | Berenson  | saulberenson@gmail.com | 0123456789 | 12                                                 | 12                                                | Password must be between 4 and 20 characters! |
      | Saul       | Berenson  | saulberenson@gmail.com | 0123456789 | ab                                                 | ab                                                | Password must be between 4 and 20 characters! |
      | Saul       | Berenson  | saulberenson@gmail.com | 0123456789 | ab1                                                | ab1                                               | Password must be between 4 and 20 characters! |
      | Saul       | Berenson  | saulberenson@gmail.com | 0123456789 | .,#                                                | .,#                                               | Password must be between 4 and 20 characters! |
      | Saul       | Berenson  | saulberenson@gmail.com | 0123456789 | 1a,                                                | 1a,                                               | Password must be between 4 and 20 characters! |
      #| Saul       | Berenson  | saulberenson@gmail.com | 0123456789 | 01234567890123456789012345123456789                | 01234567890123456789012345123456789               | Password must be between 4 and 20 characters! |
      | Saul       | Berenson  | saulberenson@gmail.com | 0123456789 | ThisIsAVeryLongPasswordThatExceedsTwentyCharacters | hisIsAVeryLongPasswordThatExceedsTwentyCharacters | Password must be between 4 and 20 characters! |

      #The maximum character limit is 36, not 20.

  Scenario: The User Registration Password Security
    And The user enters the password "MySecretPassword"
    And The user enters the same password "MySecretPassword" in the confirm password field
    Then The password should be encrypted and displayed as "***" in the input fields


  Scenario Outline:  Registering with an already used email
    And The user register with "<First Name>" und "<Last Name>" und "<E-Mail>" "<Telephone>" und "<Password>" und "<Password Confirm>"
    Then Verify that Email already registered error message "<error message>"
    Examples:
      | First Name | Last Name | E-Mail               | Telephone  | Password | Password Confirm | error message                                  |
      | admin8     | last      | adminlast8@gmail.com | 0123456789 | admin123 | admin123         | Warning: E-Mail Address is already registered! |


  Scenario Outline: User Registration with Different Password and Confirm Password
    And The user register with "<First Name>" und "<Last Name>" und "<E-Mail>" "<Telephone>" und "<Password>" und "<Password Confirm>"
    Then Verify that error message "<error message>"
    Examples:
      | First Name | Last Name | E-Mail              | Telephone  | Password | Password Confirm | error message                                  |
      | Johny      | Depp      | johnydepp@gmail.com | 0123456789 | John123  | abc123           | Password confirmation does not match password! |

  @wip
  Scenario Outline:  Registering with different email formats
    And The user register with "<First Name>" und "<Last Name>" und "<E-Mail>" "<Telephone>" und "<Password>" und "<Password Confirm>"
    Then The user should see an error message "<errorMessage>"
    Examples:
      | First Name | Last Name | E-Mail                     | Telephone  | Password | Password Confirm | errorMessage                                |
      | Johny      | Dep       | plainaddress               | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | @missingusername.com       | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@.com              | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@com               | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@domain..com       | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      #| Johny      | Dep       | username@domain.c          | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@-domain.com       | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@domain.com-       | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | .username@domain.com       | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@domain.com.       | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@domain@domain.com | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@domain.c_m        | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@.domain.com       | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      #| Johny      | Dep       | username@domain.com.a      | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@domain.co_m       | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@domain.com..      | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |
      | Johny      | Dep       | username@gmail,com         | 0123456789 | John123  | John123          | E-Mail Address does not appear to be valid! |









