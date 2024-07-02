
Feature: As a user, I should be able to login with VALID credentials
  Background:
    Given The user is on the login page
    #And The user is on the login page
  @B13DGMRAU-104
  Scenario Outline: Successful login with valid credentials
    Given The user enters a valid "<email>" and "<password>"
    When The user clicks on the login button
    Then The user should see the message that you have successfully logged in
    Examples:
      | email              | password |
      | ertan986@gmail.com | 123456   |

  @B13DGMRAU-106
  Scenario: Record with all fields left blank
    When The user clicks on the login button just
    Then verify that the user cannot log in


  @B13DGMRAU-107
  Scenario Outline: Login by leaving one of the required fields blank
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button just
    Then Verify that login error message "<error message>"
    Examples:
      | email                 | password   | error message                                         |
      |                       | admin98765 | Warning: No match for E-Mail Address and/or Password. |
      | admin-last9@gmail.com |            | Warning: No match for E-Mail Address and/or Password. |


  @B13DGMRAU-108
  Scenario Outline: Login with different email formats
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button just
    Then The user should see an error message
    Examples:
      | email                         | password                      |
      | Betsi@gmail.com               | *1234                         |
      | Betsi@gmailcom                | *123                          |
      | betltestabc1@gmail.com        | *123                          |
      | Betsi@gmail.com               | 1                             |
      | ' OR '1'='1                   | admin98765                    |
      | adminlast9@gmail.com          | ' OR '1'='1                   |
      | ' OR '1'='1                   | ' OR '1'='1                   |
      | <script>alert('XSS')</script> | admin98765                    |
      | adminlast9@gmail.com          | <script>alert('XSS')</script> |
      | ' OR '1'='1                   | <script>alert('XSS')</script> |

  @B13DGMRAU-109
  Scenario: The user can see the password in a form of dots by default
    When The user enters valid username into "email" inputbox
    And The user enters valid password into "password" inputbox
    Then Password should be entered in a form of by default


  @B13DGMRAU-110
  Scenario: Navigating through controls using the "Tab" key on the login field
    When The user clicks on the email field
    And The user presses the Tab key on the login field
    Then Verify that the cursor is in the email field with the "input-password" id on the login field










