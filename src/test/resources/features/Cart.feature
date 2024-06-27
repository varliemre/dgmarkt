@B13DGMRAU-6
Feature:As a user, I should be able to manage the cart by clicking the cart icon.
Acception Criteria;
  1- Verify that the user can select products from the relevant category and add them to the cart.
  2 - Verify that the user can see the products added to the cart by clicking the cart.
  3- Verify that the user can delete items from the cart.
  4- Verify that the user should be able to access the cart from the view cart button.
  5 - Verify that the user should be able to go to the Checkout page from the cart icon and complete the checkout.
  6- Verify that the user can enter a new Shipping address during checkout.
  7 - Verify that the user can enter a new billing address during checkout.
  8 - Verify that the user can continue shopping from the cart.

  Background:
    Given The user is on the login page
    And The user enters a valid "ertan986@gmail.com" and "123456"
    And The user clicks on the login button

  @B13DGMRAU-25
  Scenario Outline: Add products to cart
    When The user selects a "<subcategory>"
    And The user selects a "<product>" from the categories
    And The User clicks add to cart
    Then Verifies the "<message>" that the relevant product has been added to the cart
    Examples:
      | subcategory     | product                                                  | message                 |
      | Televisions     | Samsung QE55Q70AATXXU 55\" Smart 4K Ultra HD HDR QLED TV | Success: You have added |
      | TV Accessories  | C2G 3m Select High Speed HDMI Cable with Ethernet        | Success: You have added |
      | Networking      | Transcend HUB3 - Hub                                     | Success: You have added |
      | Health & Beauty | Wahl De Luxe Hair Clipper Gift Set                       | Success: You have added |

  @B13DGMRAU-52
  Scenario: Empty the basket
    When User clicks on the cart
    And The user removes items from cart
    Then  user verifies that the basket is empty




