Feature: User Currency Test

  @ass
  Scenario Outline: Currency Selected By The User Matches The Currency On The Products
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    And The user navigates to the currency selection dropdown and click "<currencyName>" currency
    Then The user verifies that the prices of products are displayed in the "<currencySymbol>" currency
    Examples:
      | email                  | password   | currencyName | currencySymbol |
      | sdetkosovali@gmail.com | Bosnali123 | Euro         | €              |
      | sdetkosovali@gmail.com | Bosnali123 | Pound        | £              |
      | sdetkosovali@gmail.com | Bosnali123 | Dollar       | $              |

  @wips
  Scenario Outline: User Is Able To Complete Their Purchase With The Currency Of Their Choice
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    And The user navigates to the currency selection dropdown and click "Dollar" currency
    And The user navigates to TV Accessories page and add the first product to cart
    And The user navigates to checkout page
    And The user fills the checkout form
    Then Verify that the order summary displays prices in the selected currency
    Examples:
      | email                  | password   |
      | sdetkosovali@gmail.com | Bosnali123 |

  @wipo
  Scenario Outline: User Should Be Able To Change Currency At The Checkout Stage
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    And The user navigates to the currency selection dropdown and click "Euro" currency
    And The user navigates to TV Accessories page and add the first product to cart
    And The user navigates to checkout page
    And The user fills the checkout form
    Then Verify that the order summary displays prices in the selected currency
    When The user navigates to the currency selection dropdown and click "US Dollar" currency
    And The user fills the checkout form
    Then Verify that the order summary displays prices in the selected currency
    Examples:
      | email                  | password   |
      | sdetkosovali@gmail.com | Bosnali123 |