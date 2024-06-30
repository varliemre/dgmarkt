@B13DGMRAU-13
Feature:As a user, I should be able to bring the products in the price range I want on the Sub-Category Page by using the PRICE slider.
  Acceptance Criteria :

  1-Verifying that there is a Price silider display within categories
  2- Verify that the user can scroll the price slider
  3- Verify that when the price slider is scrolled, the user can bring the products in the desired price range

  Background:
    Given The user is on the login page
    And The user enters a valid "ertan986@gmail.com" and "123456"
    And The user clicks on the login button

  @B13DGMRAU-61
  Scenario Outline: Verify that the price slider is displayed in categories
    When The user selects a "<subcategory>"
    Then Verify price silder display

    Examples:
      | subcategory     |
      | Televisions     |
      | TV Accessories  |
      | Networking      |
      | Health & Beauty |

  @B13DGMRAU-62
  Scenario Outline: Sliding the price slider and controlling prices
    When The user selects a "<subcategory>"
    Then user can change min  "<minValue>" and  and max values "<maximumValue>"
    Examples:
      | subcategory     | minValue | maximumValue |
      | TV Accessories  | 160      | 306          |
      | Networking      | 125      | 480          |
      | Televisions     | 250      | 350          |
      | Health & Beauty | 299     | 399        |

  @B13DGMRAU-66

  Scenario Outline: Price slider validates default values
    When The user selects a "<subcategory>"
    Then Verifies default values "<defaultMinumumVaulues>"  and "<defaultMaxValues>"
    Examples:
      | subcategory     | defaultMinumumVaulues | defaultMaxValues |
      | Health & Beauty | 102                   | 485              |
      | Televisions     | 103                   | 500              |
      | TV Accessories  | 104                   | 498              |
      | Networking      | 105                   | 499              |

