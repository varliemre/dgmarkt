Feature: Cart Icon function

  @B13DGMRAU-6-SC:1
  Scenario Outline: Add products to cart
    Given The user logged in with valid credentials "<email>" and "<password>" and is on the home page
    When The user selects a "<subcategory>"
    And The user selects a "<product>" from the categories
    And The User clicks add to cart
    Then Verifies the "<message>" that the relevant product has been added to the cart
    Examples:
      | email              | password | subcategory     | product                                     | message                 |
      | ertan986@gmail.com | 123456   | Health & Beauty | Wahl De Luxe Hair Clipper Gift Set         | Success: You have added |
      | ertan986@gmail.com | 123456   | Televisions     | Cello C4020DVB 40\" LED-backlit LCD TV      | Success: You have added |
      | ertan986@gmail.com | 123456   | TV Accessories  | Belkin High Speed HDMI Cable with Ethernet  | Success: You have added |
      | ertan986@gmail.com | 123456   | Networking      | ASUS ZenWiFi XD6 - Wi-Fi system (2 routers) | Success: You have added |




