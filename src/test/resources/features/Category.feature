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

  @wip

  Background:
    Given The user is on the Home page

  Scenario: User can go to the Category button to see the Sub-Category page without clicking
    Given The user moves to Category button
    When The user can see the sub categories

  Scenario: User can click on the 'Health & Beauty' sub-button under the Category button
    Given The user moves to Category button
    When The user clicks on the 'Health & Beauty' sub-button
    Then The user is on the Health & Beauty page

  Scenario: User can click on the 'Televisions' sub-button under the Category button
    Given The user moves to Category button
    When The user clicks on the 'Televisions' sub-button
    Then The user is on the Televisions page

  Scenario: User can click on the 'TV Accessories' sub-button under the Category button
    Given The user moves to Category button
    When The user clicks on the 'TV Accessories' sub-button
    Then The user is on the TV Accessories page

  Scenario: User can click on the 'Networking' sub-button under the Category button
    Given The user moves to Category button
    When The user clicks on the 'Networking' sub-button
    Then The user is on the Networking page

