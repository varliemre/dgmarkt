Feature: User Edit Address
  @B13DGMRAU-69
  Scenario Outline: Successful create a Edit with valid credentials
    Given The user is on the Home page
    And The user clicks on the MyAccount dropbox and clicks on the login button.
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    Then The user should see the message that you have successfully logged in
    And The user clicks on the MyAccount dropbox and clicks on the myaccount button.
    Then The user clicks the Address Book button.
    And The user clicks Edit button and navigates to Edit Address page
    When The user fills the Address form with data "<First Name>" and "<Last Name>" and "<Company>" and "<Address 1>" and "<City>" and "<Post Code>"
    And The user selects country as "Germany"
    And The user selects "Nordrhein-Westfalen" as RegionState
    Then The user clicks continue button and see warning "<Message>"

    Examples:
      | First Name | Last Name | Company | Address 1 | City | Post Code | Message                                         | email                     | password   |
      |            | Sahan     | BMW     | Eichen 10 | Ulm  | 75321     | First Name must be between 1 and 32 characters! | fatmasoytas81@hotmail.com |Fatma2024.|