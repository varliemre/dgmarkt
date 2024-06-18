Feature: Cart Icon function

  @B13DGMRAU-6
  Scenario Outline: Add products to cart
    Given The user logged in with valid credentials "<email>" and "<password>" and is on the home page
    When The user selects a "<subcategory>"
   # And The user selects a "<product>" from the categories
#And The User clicks add to cart
#Then Verifies the "<message>" that the relevant product has been added to the cart
    Examples:
      | email                | password   | subcategory | product                              | message                 |
      | adminlast9@gmail.com | admin98765 | Health & Beauty | Cello C1920FS 19" LED-backlit LCD TV | Success: You have added |