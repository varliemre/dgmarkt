@B13DGMRAU-6-Regression
Feature: Cart Icon function

  @B13DGMRAU-6-SC:1

  Scenario Outline: Add products to cart
    Given The user logged in with valid credentials "<email>" and "<password>" and is on the home page
    When The user selects a "<subcategory>"
    And The user selects a "<product>" from the categories
    And The User clicks add to cart
    Then Verifies the "<message>" that the relevant product has been added to the cart
    Examples:
      | email              | password | subcategory     | product                                                  | message                 |
      | ertan986@gmail.com | 123456   | Health & Beauty | WAHL 7061-117 Lithium Lifeproof Mens Electric Shaver     | Success: You have added |
      | ertan986@gmail.com | 123456   | Televisions     | Samsung QE55Q70AATXXU 55\" Smart 4K Ultra HD HDR QLED TV | Success: You have added |
      | ertan986@gmail.com | 123456   | TV Accessories  | C2G 3m Select High Speed HDMI Cable with Ethernet        | Success: You have added |
      | ertan986@gmail.com | 123456   | Networking      | Transcend HUB3 - Hub                                     | Success: You have added |

  @B13DGMRAU-6-SC:2
    Scenario: Empty the basket
    Given The user logged in with valid credentials "ertan986@gmail.com" and "123456" and is on the home page
    When User clicks on the cart
    And The user removes items from cart
    Then  user verifies that the basket is empty


