Feature: Category Module

  Scenario: Verify that the user can navigate the Sub-Category Page
    Given The user is on the home page
    When The user hovers over the Category tab
    And The user hovers over the Sub-Category tab
    And The user clicks on a Sub-Category tab
    Then The Sub-Category Page should be displayed


  Scenario: User can hover over Category and click on a specific Sub-Category tab
    Given The user is on the home page
    When The user hovers over the Category tab
    And The user clicks on the "Networking" Sub-Category tab
    Then The "Networking" Sub-Category page is displayed
