
Feature: As a user, I should be able to login with VALID credentials
  Background:
    Given The user is on the Home page
    And The user is on the login page
  @A
  Scenario Outline: Successful login with valid credentials
    Given The user enters a valid "<email>" and "<password>"
    When The user clicks on the login button
    Then The user should see the message that you have successfully logged in
    Examples:
      | email              | password |
      | ertan986@gmail.com | 123456   |


  Scenario: Record with all fields left blank
    When The user clicks the login button without filling in the required fields.
    Then verify that the user cannot log in


  Scenario Outline: Login by leaving one of the required fields blank
    When The user enters a valid "<email>" and "<password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail                | Password   | error message                                         |
      |                       | admin98765 | Warning: No match for E-Mail Address and/or Password. |
      | admin-last9@gmail.com |            | Warning: No match for E-Mail Address and/or Password. |



  Scenario Outline: The user should be able to enter the password field between 4 and 20 characters.
    When The user enters a valid "<email>" and "<password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail                 | Password                                           | error message                                         |
      | saulberenson@gmail.com | 12                                                 | Warning: No match for E-Mail Address and/or Password. |
      | saulberenson@gmail.com | ab                                                 | Warning: No match for E-Mail Address and/or Password. |
      | saulberenson@gmail.com | ab1                                                | Warning: No match for E-Mail Address and/or Password. |
      | saulberenson@gmail.com | ,.                                                 | Warning: No match for E-Mail Address and/or Password. |
      | saulberenson@gmail.com | 1a,                                                | Warning: No match for E-Mail Address and/or Password. |
      #| saulberenson@gmail.com | 0123456789 | Password must be between 4 and 20 characters! |
      | saulberenson@gmail.com | ThisIsAVeryLongPasswordThatExceedsTwentyCharacters | Warning: No match for E-Mail Address and/or Password. |
      #The maximum character limit is 36, not 20.


  Scenario Outline: The user should be able to enter the email field between 4 and 20 characters.
    When The user enters a valid "<email>" and "<password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail                     | Password | error message                                         |
      | *                          | John123  | Warning: No match for E-Mail Address and/or Password. |
      | 12                         | John123  | Warning: No match for E-Mail Address and/or Password. |
      | a1,                        | John123  | Warning: No match for E-Mail Address and/or Password. |
      | #.                         | John123  | Warning: No match for E-Mail Address and/or Password. |
      | $,12                       | John123  | Warning: No match for E-Mail Address and/or Password. |
      | <>*/-                      | John123  | Warning: No match for E-Mail Address and/or Password. |
      | abcdefghıijklmoöprsştuuvyz | John123  | Warning: No match for E-Mail Address and/or Password. |



  Scenario Outline: Login with different email formats
    When The user enters a valid "<email>" and "<password>"
    Then The user should see an error message "<errorMessage>"
    Examples:
      | E-Mail                     | Password | errorMessage                                          |
      | plainaddress               | John123  | Warning: No match for E-Mail Address and/or Password. |
      | @missingusername.com       | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@.com              | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@com               | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@domain..com       | John123  | Warning: No match for E-Mail Address and/or Password. |
      #| username@domain.c         | John123  |  Warning: No match for E-Mail Address and/or Password. |
      | username@-domain.com       | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@domain.com-       | John123  | Warning: No match for E-Mail Address and/or Password. |
      | .username@domain.com       | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@domain.com.       | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@domain@domain.com | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@domain.c_m        | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@.domain.com       | John123  | Warning: No match for E-Mail Address and/or Password. |
      #| username@domain.com.a     | John123  |  Warning: No match for E-Mail Address and/or Password.|
      | username@domain.co_m       | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@domain.com..      | John123  | Warning: No match for E-Mail Address and/or Password. |
      | username@gmail,com         | John123  | Warning: No match for E-Mail Address and/or Password. |

  @A
  Scenario: The user can see the password in a form of dots by default
    When The user enters valid username into "email" inputbox
    And The user enters valid password into "password" inputbox
    Then Password should be entered in a form of "dots" by default



  Scenario Outline: Login function is not vulnerable to SQL injection attacks.
    When The user enters a valid "<email>" and "<password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail               | Password    | error message                                         |
      | ' OR '1'='1          | admin98765  | Warning: No match for E-Mail Address and/or Password. |
      | adminlast9@gmail.com | ' OR '1'='1 | Warning: No match for E-Mail Address and/or Password. |
      | ' OR '1'='1          | ' OR '1'='1 | Warning: No match for E-Mail Address and/or Password. |

  Scenario Outline: The application is not vulnerable to XSS attacks.
    When The user enters a valid "<email>" and "<password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail                        | Password                      | error message                                         |
      | <script>alert('XSS')</script> | admin98765                    | Warning: No match for E-Mail Address and/or Password. |
      | adminlast9@gmail.com          | <script>alert('XSS')</script> | Warning: No match for E-Mail Address and/or Password. |
      | ' OR '1'='1                   | <script>alert('XSS')</script> | Warning: No match for E-Mail Address and/or Password. |



  Scenario: Navigating through controls using the "Tab" key on the login field
    When The user clicks on the email field
    And The user presses the Tab key on the login field
    Then Verify that the cursor is in the email field with the "password" id on the login field


  







