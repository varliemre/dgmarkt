@dilek

Feature: Update User Account Information

  Background:
    Given The user is on the Home page
    And The user clicks on the My Account button
    #And The user clicks on the MyAccount dropbox and clicks on the myaccount button.

    When The user clicks on the login button
    When  The user enters valid credentials for the Edit Account login
    And The user click on the Continue button

     # Then The user should see the message that you have successfully logged in

   # Given The user clicks on the My Account button
    When The user clicks on the Edit Account button



  Scenario: User can update their account with valid First Name, Last Name, E-Mail and Telephone Number
    Given The user updates the First Name as "Dilek"
    When The user updates the Last Name as "Aba"
    Given The user updates the email as "dilekttest@gmail.com"
    When The user updates the telephone number as "12345678901234"
    And The user clicks on the Continue button
    Then The user updates their account successfully
    And Change the default credentials for the Edit Account


  Scenario: User can turn back without update their account
    Given The user updates the First Name as "Dilek"
    When The user updates the Last Name as "Test"
    Given The user updates the email as "dilek@gmail.com"
    When The user updates the telephone number as "12345678901234"
    And The user clicks on the Back button
    Then The user can see the Edit Account without changes


  Scenario: User can't update their account with blank First Name
    Given The user updates the First Name as blank
    When The user updates the Last Name as "Aba"
    Given The user updates the email as "dilekttest@gmail.com"
    When The user updates the telephone number as "1234567890123"
    And The user clicks on the Continue button
    Then The user should not be able to update their Edit Account with blank First Name


  Scenario: User can't update their account with blank Last Name
    Given The user updates the First Name as "Dilek"
    When The user updates the Last Name as blank
    Given The user updates the email as "dilekttest@gmail.com"
    When The user updates the telephone number as "12345678901234"
    And The user clicks on the Continue button
    Then The user should not be able to update their Edit Account with blank Last Name


  Scenario: User can't update their account with blank E-Mail
    Given The user updates the First Name as "AsdfghjkL"
    When The user updates the Last Name as "TTTTT"
    Given The user updates the email as blank
    When The user updates the telephone number as "12345678901234"
    And The user clicks on the Continue button
    Then The user should not be able to update their Edit Account with blank email


  Scenario: User can't update their account with invalid E-Mail
    Given The user updates the First Name as "asdfghjkl Asdfghjklmn"
    When The user updates the Last Name as "TTTTT"
    Given The user updates the email as "dilek%$ttest@gmail.com"
    When The user updates the telephone number as "12345678"
    And The user clicks on the Continue button
    Then The user should not be able to update their Edit Account with invalid E-Mail

  Scenario: User can't update their account with invalid (boundry) First Name
    Given The user updates the First Name as "ertetsdffgdfgdfhdg hredsxbghjkuzt"
    When The user updates the Last Name as "A"
    Given The user updates the email as "dilekttest@gmail.com"
    When The user updates the telephone number as "12345678"
    And The user clicks on the Continue button
    Then The user should not be able to update their Edit Account with invalid First Name

  Scenario: User can't update their account with invalid (boundry) Last Name
    Given The user updates the First Name as "Be"
    When The user updates the Last Name as "ertetsdffgdfgdfhdg hredsxbghjkuzt"
    Given The user updates the email as "dilekttest@gmail.com"
    When The user updates the telephone number as "12345678"
    And The user clicks on the Continue button
    Then The user should not be able to update their Edit Account with invalid Last Name


  Scenario: User can't update their account with invalid (boundry) Telephone
    Given The user updates the First Name as "Be"
    When The user updates the Last Name as "LOL"
    Given The user updates the email as "dilekttest@gmail.com"
    When The user updates the telephone number as "123456789012345678901234567890123"
    And The user clicks on the Continue button
    Then The user should not be able to update their Edit Account with invalid Telephone

