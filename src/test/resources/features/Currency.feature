Feature: User Currency Test

  @ass
  Scenario Outline: Currency Selected By The User Matches The Currency On The Products
    Given The user is on the login page
    When The user enters a valid "<email>" and "<password>"
    And The user clicks on the login button
    And The user navigates to the currency selection dropdown and click "<Currency>" currency
      | € Euro | £ Pound Sterling | $ US Dollar |
    Then The user verifies that the prices of products are displayed in the "<Currency>" currency
      | € Euro | £ Pound Sterling | $ US Dollar |
    Examples:
      | email                  | password   |
      | sdetkosovali@gmail.com | Bosnali123 |