@Regression-Us-7
Feature: Cart Icon function

  As a user, I should be able to manage the cart by clicking the cart icon.

  Users Story:
  - User logs in with valid credentials.
  - Selects categories from product categories.
  - Adds the product from the list to the cart.
  - Verify that the user can see the products added to the cart by clicking the cart icon.
  - Verify that the user can delete items from the cart.
  - Verify that the user should be able to access the cart from the view cart button.
  - Verify that the user should be able to go to the Checkout page from the cart icon and complete the checkout.
  - Verify that the user can enter a different Shipping address during checkout.
  - Verify that the user can enter another billing address during checkout.

  @B13DGMRAU-6-SC:1
  Scenario Outline: Add products to cart
    Given The user logged in with valid credentials "<email>" and "<password>" and is on the home page
    When The user selects a "<subcategory>"
    And The user selects a "<product>" from the categories
    And The User clicks add to cart
    Then Verifies the "<message>" that the relevant product has been added to the cart
    Examples:
      | email              | password | subcategory     | product                                                  | message                 |
      | ertan986@gmail.com | 123456   | Televisions     | Samsung QE55Q70AATXXU 55\" Smart 4K Ultra HD HDR QLED TV | Success: You have added |
      | ertan986@gmail.com | 123456   | TV Accessories  | C2G 3m Select High Speed HDMI Cable with Ethernet        | Success: You have added |
      | ertan986@gmail.com | 123456   | Networking      | Transcend HUB3 - Hub                                     | Success: You have added |
      | ertan986@gmail.com | 123456   | Health & Beauty | Wahl De Luxe Hair Clipper Gift Set                       | Success: You have added |

  @B13DGMRAU-6-SC:2
  Scenario: Empty the basket
    Given The user logged in with valid credentials "ertan986@gmail.com" and "123456" and is on the home page
    When User clicks on the cart
    And The user removes items from cart
    Then  user verifies that the basket is empty




