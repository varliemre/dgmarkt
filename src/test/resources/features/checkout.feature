@B13DGMRAU-Regression
Feature: Checkout

  @B13DGMRAU-6-SC:2
    Scenario: view cart
      Given The user logged in with valid credentials "ertan986@gmail.com" and "123456" and is on the home page
      When User clicks on the cart
      Then verifies that the basket was imaged
      Then User verifies the amount 5 and quantity 14 of products in the cart
  @B13DGMRAU-6-SC:3
Scenario: Checkout with default info items for items in the cart
  Given The user logged in with valid credentials "ertan986@gmail.com" and "123456" and is on the home page
  When User clicks on the cart
  And The user sees the shipping costs by entering the country address information
  And User clicks the Checkout icon
  And User the existing address as the billing address and clicks Continue
  And Click continue with the fixed price delivery option
  And clicks I have read and accept the Terms and Conditions and clicks Continue
  And Clicks Confirm Order after reviewing the order details
  Then  Your order has been placed! verifies confirmation
