@B13DGMRAU-US-11
Feature: My Account-User can Modify wish list
    #As a user, I should be able to modify My wish list by clicking the Wish List tab under the My Account module.

  Background: Login page
    Given The user logged in with valid credentials "muller@gmail.com" and "012345678" and is on the home page


  Scenario Outline: Verify that the user should be able to reach wish list on My wish list page and the user should be able to reach wish list from pop-up message after adding the product to the wish list.
    And The user hover overs to "Category" menu headers and clicks "<moduleName>" sub menu headers
    And User adds "<productName>" item in his her wish list
    Then User validates the success message adding to wish list "<productNamesInSuccessMessages>"
    And User clicks "Wish List"
    Then User verifies that the user can see the product "<productNamesInSuccessMessages>" in the wish list
    Examples: Product names & Module Names
      | productName     | productNamesInSuccessMessages | moduleName  |
      | CELLO C3220G 32 | Cello C3220G 32               | Televisions |


  Scenario Outline: Verify that the user should be able to add the products from wish list to cart
    And The user hover overs to "Category" menu headers and clicks "<moduleName>" sub menu headers
    And User adds "<productName>" item in his her wish list
    And User clicks "Wish List"
    And User adds product "<productNamesInSuccessMessages>" from wish list to cart
    Then User validates the success message adding to cart "<productNamesInSuccessMessages>"
    And User clicks to cart button
    Then User validates that the item is in cart "<cartProductName>"
    Examples: Product names & Module Names
      | productName        | productNamesInSuccessMessages | moduleName      | cartProductName    |
      | CAPSULE PLATE 6PCS | Capsule Plate 6pcs            | Health & Beauty | Capsule Plate 6pcs |


  Scenario Outline: Verify that the User should be able to delete the products from wish list
    And The user hover overs to "Category" menu headers and clicks "<moduleName>" sub menu headers
    And User adds "<productName>" item in his her wish list
    Then User validates the success message adding to wish list "<productNamesInSuccessMessages>"
    And User clicks "Wish List"
    And User clicks remove button "<productNamesInSuccessMessages>"
    Then User validates that the item is not on the wish list anymore "<productNamesInSuccessMessages>"
    Examples: Product names & Module Names
      | productName        | productNamesInSuccessMessages | moduleName      |
      | CAPSULE PLATE 6PCS | Capsule Plate 6pcs            | Health & Beauty |





