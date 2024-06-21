Feature: Category Module
  @wip
  Scenario: Verify that the user can navigate the Sub-Category Page
    Given The user is on the Category Page
    When The user hovers over the Category tab
    And The user hovers over the Sub-Category tab
    And The user clicks on a Sub-Category tab
    Then The Sub-Category Page should be displayed