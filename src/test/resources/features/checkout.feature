Feature: Checkout

  @B13DGMRAU-6-SC:2
    Scenario: view cart
      Given The user logged in with valid credentials "ertan986@gmail.com" and "123456" and is on the home page
      When User clicks on the cart
      Then verifies that the basket was imaged
      Then User verifies the amount 5 and quantity 9 of products in the cart


