@B13DGMRAU-6
Feature: As a user, I should be able to manage the cart by clicking the cart icon.

  Background:
    Given The user is on the login page
    And The user enters a valid "ertan986@gmail.com" and "123456"
    And The user clicks on the login button
    And The user selects a "Networking"
    And The user selects a "Bose ControlSpace WP22B-D Dante" from the categories
    And The User clicks add to cart
    And User clicks on the cart


  @B13DGMRAU-53
  Scenario: View cart
    Then verifies that the basket was imaged
    Then User verifies the amount 1 and quantity 1 of products in the cart


  @B13DGMRAU-56
  Scenario: Checkout by registered user address and billing address
    When The user sees the shipping costs by entering the country address information
    And User clicks the Checkout icon
    And User the existing address as the billing address and clicks Continue
    And User the existing address as the delivery address and clicks Continue
    And Click continue with the fixed price delivery option
    And clicks I have read and accept the Terms and Conditions and clicks Continue
    And Clicks Confirm Order after reviewing the order details
    Then  Your order has been placed! verifies confirmation


  @B13DGMRAU-57
  Scenario Outline: Billing and delivery address -Positive Test
    When User clicks the Checkout icon
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

  @B13DGMRAU-58
  Scenario Outline: Billling adresse-Negative Test
    When User clicks the Checkout icon
    And The user clicks I want to use a new billing address
    And Fill in the billing address form "<First Name>"  "<Last Name>","<Address 1>" ,"<City>" ,"<Post Code>"  on the page that opens and click continue
    Then Verify that the user cannot continue shopping with incorrect billing address information and verify the "<errorMessage>"
    Examples:
      | First Name                          | Last Name                                | Address 1                                                                                                                               | City                                                                                                                                          | Post Code | errorMessage                                    |
      |                                     | Yanbasar                                 | ankara cad.                                                                                                                             | Istanbul                                                                                                                                      | 34843     | First Name must be between 1 and 32 characters! |
      | AhmetAhmetAhmetAhmetAhmetAhmetAhmet | Yanbasar                                 | ankara cad.                                                                                                                             | Istanbul                                                                                                                                      | 34843     | First Name must be between 1 and 32 characters! |
      | Ahmet                               |                                          | ankara cad.                                                                                                                             | Istanbul                                                                                                                                      | 34843     | Last Name must be between 1 and 32 characters!  |
      | Ahmet                               | YanbasarYanbasarYanbasarYanbasarYanbasar | ankara cad.                                                                                                                             | Istanbul                                                                                                                                      | 34843     | Last Name must be between 1 and 32 characters!  |
      | Ahmet                               | Yanbasar                                 |                                                                                                                                         | Istanbul                                                                                                                                      | 34843     | Address 1 must be between 3 and 128 characters! |
      | Ahmet                               | Yanbasar                                 | an                                                                                                                                      | Istanbul                                                                                                                                      | 34843     | Address 1 must be between 3 and 128 characters! |
      | Ahmet                               | Yanbasar                                 | ankara cad. ankara cad. ankara cad. ankara cad.ankara cad.ankara cad.ankara cad.ankara cad.ankara cad.ankara cad.ankara cad.ankara cad. | Istanbul                                                                                                                                      | 34843     | Address 1 must be between 3 and 128 characters! |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                             |                                                                                                                                               | 34843     | City must be between 2 and 128 characters!      |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                             | a                                                                                                                                             | 34843     | City must be between 2 and 128 characters!      |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                             | istanbulll istanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulll | 34843     | City must be between 2 and 128 characters!      |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                             | Istanbul                                                                                                                                      |           | Postcode must be between 2 and 10 characters!   |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                             | Istanbul                                                                                                                                      | 34        | Postcode must be between 2 and 10 characters!   |


  @B13DGMRAU-59
  Scenario Outline: Delivery adresse-Negative Test
    When User clicks the Checkout icon
    And The user clicks I want to use a new delivery address address
    And Fill in the delivery address form "<First Name>"  "<Last Name>","<Address 1>" ,"<City>" ,"<Post Code>"  on the page that opens and click continue
    Then Verify that the user cannot continue shopping with incorrect delivery address information and verify the "<errorMessage>"

    Examples:
      | First Name                          | Last Name                                | Address 1                                                                                                                                       | City                                                                                                                                          | Post Code      | errorMessage                                    |
      |                                     | Yanbasar                                 | ankara cad.                                                                                                                                     | Istanbul                                                                                                                                      | 34843          | First Name must be between 1 and 32 characters! |
      | AhmetAhmetAhmetAhmetAhmetAhmetAhmet | Yanbasar                                 | ankara cad.                                                                                                                                     | Istanbul                                                                                                                                      | 34843          | First Name must be between 1 and 32 characters! |
      | Ahmet                               |                                          | ankara cad.                                                                                                                                     | Istanbul                                                                                                                                      | 34843          | Last Name must be between 1 and 32 characters!  |
      | Ahmet                               | YanbasarYanbasarYanbasarYanbasarYanbasar | ankara cad.                                                                                                                                     | Istanbul                                                                                                                                      | 34843          | Last Name must be between 1 and 32 characters!  |
      | Ahmet                               | Yanbasar                                 |                                                                                                                                                 | Istanbul                                                                                                                                      | 34843          | Address 1 must be between 3 and 128 characters! |
      | Ahmet                               | YanbasarY                                | an                                                                                                                                              | Istanbul                                                                                                                                      | 34843          | Address 1 must be between 3 and 128 characters! |
      | Ahmet                               | Yanbasar                                 | ankara cad. ankara cad. ankara cad. ankara cad. ankara cad. ankara cad. ankara cad. ankara cad. ankara cad. ankara cad. ankara cad. ankara cad. | Istanbul                                                                                                                                      | 34843          | Address 1 must be between 3 and 128 characters! |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                                     |                                                                                                                                               | 34843          | City must be between 2 and 128 characters!      |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                                     | a                                                                                                                                             | 34843          | City must be between 2 and 128 characters!      |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                                     | istanbulll istanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulllistanbulll | 34843          | City must be between 2 and 128 characters!      |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                                     | Istanbul                                                                                                                                      |                | Postcode must be between 2 and 10 characters!   |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                                     | Istanbul                                                                                                                                      | 34             | Postcode must be between 2 and 10 characters!   |
      | Ahmet                               | Yanbasar                                 | ankara cad.                                                                                                                                     | Istanbul                                                                                                                                      | 31455666555454 | Postcode must be between 2 and 10 characters!   |

  @B13DGMRAU-60
  Scenario: Continue Shopping
    When The User click Continue Shopping
    Then Verify The user is on the home page

