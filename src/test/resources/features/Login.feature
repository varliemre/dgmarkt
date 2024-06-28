@betul1
Feature: As a user, I should be able to login with VALID credentials
  Background:
    Given The user is on the Home page
    And The user navigates to the Login page

  Scenario Outline: Successful login with valid credentials
    Given The user enters a valid "<email>" and "<password>"
    When The user clicks on the login button
    Then The user should see the message that you have successfully logged in
    Examples:
      | email              | password |
      | ertan986@gmail.com | 123456   |

  @betul2
  Scenario: Record with all fields left blank
    When The user clicks the login button without filling in the required fields.
    Then verify that the user cannot log in

  @betul3
  Scenario Outline: Login by leaving one of the required fields blank
    When The user login with "<E-Mail>" and "<Password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail               | Password   | error message                                         |
      |                      | admin98765 | Warning: No match for E-Mail Address and/or Password. |
      | admin-last9@gmail.com |            | Warning: No match for E-Mail Address and/or Password. |


  @B@betul4
  Scenario Outline: The user should be able to enter the password field between 4 and 20 characters.
    When The user login with "<E-Mail>" and "<Password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail                 | Password                                           | error message                                 |
      | saulberenson@gmail.com | 12                                                 | Password must be between 4 and 20 characters! |
      | saulberenson@gmail.com | ab                                                 | Password must be between 4 and 20 characters! |
      | saulberenson@gmail.com | ab1                                                | Password must be between 4 and 20 characters! |
      | saulberenson@gmail.com | .,                                                 | Password must be between 4 and 20 characters! |
      | saulberenson@gmail.com | 1a,                                                | Password must be between 4 and 20 characters! |
      #| saulberenson@gmail.com | 0123456789 | Password must be between 4 and 20 characters! |
      | saulberenson@gmail.com | ThisIsAVeryLongPasswordThatExceedsTwentyCharacters | Password must be between 4 and 20 characters! |
      #The maximum character limit is 36, not 20.


  Scenario Outline: The user should be able to enter the email field between 4 and 20 characters.
    When The user login with "<E-Mail>" and "<Password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail                     | Password | error message                               |
      | *                          | John123  | error message                               |
      | 12                         | John123  | E-Mail Address does not appear to be valid! |
      | a1,                        | John123  | E-Mail Address does not appear to be valid! |
      | #.                         | John123  | E-Mail Address does not appear to be valid! |
      | $,12                       | John123  | E-Mail Address does not appear to be valid! |
      | <>*/-                      | John123  | John123                                     |
      | abcdefghıijklmoöprsştuuvyz | John123  | E-Mail Address does not appear to be valid! |



  Scenario Outline: Login with invalid email and password lengths and characters
    When The user login with "<E-Mail>" and "<Password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail               | Password   | error message                                         |
      |                      | admin98765 | Warning: No match for E-Mail Address and/or Password. |
      | adminlast9@gmail.com |            | Warning: No match for E-Mail Address and/or Password. |



  Scenario Outline: Login with different email formats
    When The user login with "<E-Mail>" and "<Password>"
    Then The user should see an error message "<errorMessage>"
    Examples:
      | E-Mail                     | Password | errorMessage                                |
      | plainaddress               | John123  | E-Mail Address does not appear to be valid! |
      | @missingusername.com       | John123  | E-Mail Address does not appear to be valid! |
      | username@.com              | John123  | E-Mail Address does not appear to be valid! |
      | username@com               | John123  | E-Mail Address does not appear to be valid! |
      | username@domain..com       | John123  | E-Mail Address does not appear to be valid! |
      #| username@domain.c         | John123  | E-Mail Address does not appear to be valid! |
      | username@-domain.com       | John123  | E-Mail Address does not appear to be valid! |
      | username@domain.com-       | John123  | E-Mail Address does not appear to be valid! |
      | .username@domain.com       | John123  | E-Mail Address does not appear to be valid! |
      | username@domain.com.       | John123  | E-Mail Address does not appear to be valid! |
      | username@domain@domain.com | John123  | E-Mail Address does not appear to be valid! |
      | username@domain.c_m        | John123  | E-Mail Address does not appear to be valid! |
      | username@.domain.com       | John123  | E-Mail Address does not appear to be valid! |
      #| username@domain.com.a     | John123  | E-Mail Address does not appear to be valid! |
      | username@domain.co_m       | John123  | E-Mail Address does not appear to be valid! |
      | username@domain.com..      | John123  | E-Mail Address does not appear to be valid! |
      | username@gmail,com         | John123  | E-Mail Address does not appear to be valid! |

  @betul50
  Scenario: The user can see the password in a form of dots by default
    When The user enters valid username into "username" inputbox
    And The user enters valid password into "password" inputbox
    Then Password should be entered in a form of "dots" by default



  Scenario Outline: Login function is not vulnerable to SQL injection attacks.
    When The user login with "<E-Mail>" and "<Password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail               | Password    | error message                                         |
      | ' OR '1'='1          | admin98765  | Warning: No match for E-Mail Address and/or Password. |
      | adminlast9@gmail.com | ' OR '1'='1 | Warning: No match for E-Mail Address and/or Password. |
      | ' OR '1'='1          | ' OR '1'='1 | Warning: No match for E-Mail Address and/or Password. |

  Scenario Outline: The application is not vulnerable to XSS attacks.
    When The user login with "<E-Mail>" and "<Password>"
    Then Verify that error message "<error message>"
    Examples:
      | E-Mail                        | Password                      | error message                                         |
      | <script>alert('XSS')</script> | admin98765                    | Warning: No match for E-Mail Address and/or Password. |
      | adminlast9@gmail.com          | <script>alert('XSS')</script> | Warning: No match for E-Mail Address and/or Password. |
      | ' OR '1'='1                   | <script>alert('XSS')</script> | Warning: No match for E-Mail Address and/or Password. |


  @betul51
  Scenario: Navigating through controls using the "Tab" key
    When The user clicks on the email field
    And The user presses the Tab key
    Then Verify that the cursor is in the email field with the "password" id


  







