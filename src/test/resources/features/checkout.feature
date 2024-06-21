Feature: Checkout

  @B13DGMRAU-6-SC:2
  Scenario: view cart
    Given The user logged in with valid credentials "ertan986@gmail.com" and "123456" and is on the home page
    When The user selects a "Networking"
    And The user selects a "Bose ControlSpace WP22B-D Dante" from the categories
    And The User clicks add to cart
    When User clicks on the cart
    Then verifies that the basket was imaged
    Then User verifies the amount 1 and quantity 1 of products in the cart

  @B13DGMRAU-6-SC:3
  Scenario: Checkout with default info items for items in the cart
    Given The user logged in with valid credentials "ertan986@gmail.com" and "123456" and is on the home page
    When The user selects a "Networking"
    And The user selects a "Belkin Secure Flip KVM Switch" from the categories
    And User clicks on the cart
    And The user sees the shipping costs by entering the country address information
    And User clicks the Checkout icon
    And User the existing address as the billing address and clicks Continue
    And User the existing address as the delivery address and clicks Continue
    And Click continue with the fixed price delivery option
    And clicks I have read and accept the Terms and Conditions and clicks Continue
    And Clicks Confirm Order after reviewing the order details
    Then  Your order has been placed! verifies confirmation


  @B13DGMRAU-6-SC:4
  Scenario Outline: With valid information Pay with a new and different billing address and delivery address

    Given The user logged in with valid credentials "ertan986@gmail.com" and "123456" and is on the home page
    When The user selects a "Networking"
    And The user selects a "Trust Halyx Aluminium USB-C to 4-Port USB-A 3.2 Hub" from the categories
    When User clicks on the cart
    And User clicks the Checkout icon
    And The user clicks I want to use a new billing address
    And Fill in the billing address form "<First Name>"  "<Last Name>","<Address 1>" ,"<City>" ,"<Post Code>"  on the page that opens and click continue
    And The user clicks I want to use a new delivery address
    And Fill in the delivery address form "<First Name>"  "<Last Name>","<Address 1>" ,"<City>" ,"<Post Code>"  on the page that opens and click continue
    And Click continue with the fixed price delivery option
    And clicks I have read and accept the Terms and Conditions and clicks Continue
    And Clicks Confirm Order after reviewing the order details
    Then  Your order has been placed! verifies confirmation
    Examples:
      | First Name | Last Name | Address 1   | City     | Post Code |
      | Ahmet      | Yanbasar  | ankara cad. | Istanbul | 34843     |


  #@B13DGMRAU-6-SC:5
  #Scenario Outline: With not valid information Pay with a new and different billing address and delivery address

   # Given The user logged in with valid credentials "ertan986@gmail.com" and "123456" and is on the home page
    #When The user selects a "Networking"
    #And The user selects a "Trust Halyx Aluminium USB-C to 4-Port USB-A 3.2 Hub" from the categories
    #When User clicks on the cart
    #And User clicks the Checkout icon
    #And The user clicks I want to use a new billing address
    #Fill in the billing address form "<First Name>"  "<Last Name>","<Address 1>" ,"<City>" ,"<Post Code>"  on the page that opens and click continue
    #And The user clicks I want to use a new delivery address
    # Fill in the delivery address form "<First Name>"  "<Last Name>","<Address 1>" ,"<City>" ,"<Post Code>"  on the page that opens and click continue
    #And Click continue with the fixed price delivery option
    #And clicks I have read and accept the Terms and Conditions and clicks Continue
    #And Clicks Confirm Order after reviewing the order details
   # Then  Your order has been placed! verifies confirmation
   # Examples:
    #  | First Name | Last Name | Company | Address 1 | City | Post Code | Region / State |
     # | rr         | gfh       | fdg     | ddd       | dfds | fgh       | ztz            |

  #@B13DGMRAU-6-SC:6
  #Scenario: Continue Shopping







    #Scenario: empty shopping cart
