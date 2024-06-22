Feature: User Create New Address
  @Address
    Scenario Outline: Successful create a new address with valid credentials
      Given The user is on the Home page
      And The user clicks on the MyAccount dropbox and clicks on the myaccount button.
      Then The user clicks the Address Book button.
      And The user clicks the New Address button.
      Then The user enter valid "<firstName>" and "<lastName>" and "<company>" and "<address1>" and "<address2>" and "<city>" and "<postCode>"
      And The user click on the country dropbox and select country
      Then The user click on the region dropbox and select state
      And The user select default address on the radio button to Yes
      And The user click on the Continue button
      Then The user should see the message that Your address has been successfully added
      Examples:
        | firstName | lastName | company       | address1      | address2 | city | postCode |
        | Fatma     | Soytas   | Sahan Holding | Mörikerstr. 2 | k2       | Ulm  | 71011    |