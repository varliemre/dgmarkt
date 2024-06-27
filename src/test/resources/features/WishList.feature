@B13DGMRAU-US-11
Feature: My Account-User can Modify wish list
    #As a user, I should be able to modify My wish list by clicking the Wish List tab under the My Account module.

  Background: Login page
    Given The user logged in with valid credentials "muller@gmail.com" and "012345678" and is on the home page


  Scenario: Verify that the user should be able to reach wish list on My wish list page
    When The user clicks wish list link
    Then The user verifies that the user should see wish list text


  Scenario: Verify that the user should be able to reach wish list by clicking the Add to Wish List icon.
    When The user clicks wish list icon
    Then The user verifies that the user should see wish list text

  @wish
  Scenario: Verify that the user should not be able to access to wish list when logged out.
    When The user clicks wish list link
    And The user clicks My Account dropdown button and clicks Logout button
    And The user clicks wish list icon
    Then The user should see a message after trying to navigate to wish list











