@B13DGMRAU-US-16
Feature: Cat-Subcategory - Product Compare function
    #As a user, I should be able to compare the features of the products I want.

  Background: Login page
    Given The user logged in with valid credentials "muller@gmail.com" and "012345678" and is on the home page


  Scenario: Verify that the User should be able to navigate the Product Compare Page when the User clicks on the Product Compare sub-Tab.
    When The user hover overs to "Category" menu headers and clicks "Televisions" sub menu headers
    And User adds "CELLO C3220G 32" item in his her compare page
    Then User validates the success message adding to wish list "Cello C3220G 32"
    And The user clicks the product comparison button and navigate to product comparison page
    Then The user should see product comparison text on the page


  Scenario: Verify that the user should be able to see the Products they want to compare on the Product Comparison page
    When The user hover overs to "Category" menu headers and clicks "Televisions" sub menu headers
    And User adds "CELLO C3220G 32" item in his her compare page
    Then User validates the success message adding to wish list "Cello C3220G 32"
    And The user clicks the product comparison button and navigate to product comparison page
    Then The user should see the products on the comparison page

  Scenario: Verify that the user can ADD the compared products to the cart separately
    When The user hover overs to "Category" menu headers and clicks "Televisions" sub menu headers
    And User adds "CELLO C3220G 32" item in his her compare page
    Then User validates the success message adding to wish list "Cello C3220G 32"
    And The user clicks the product comparison button and navigate to product comparison page
    Then The user should see the products on the comparison page


  Scenario: Verify that the user can REMOVE the compared products separately
    When The user hover overs to "Category" menu headers and clicks "Televisions" sub menu headers
    And User adds "CELLO C3220G 32" item in his her compare page
    Then User validates the success message adding to wish list "Cello C3220G 32"
    And The user clicks the product comparison button and navigate to product comparison page
    Then The user should see the products on the comparison page
    And The user clicks the Remove button to remove products
    Then The user should not see any products in the page




