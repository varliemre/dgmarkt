@B13DGMRAU-US-16
Feature: Cat-Subcategory - Product Compare function
    #As a user, I should be able to compare the features of the products I want.

  Background: Login page
    Given The user logged in with valid credentials "muller@gmail.com" and "012345678" and is on the home page


Scenario: Verify that the User should be able to navigate the Product Compare Page when the User clicks on the Product Compare sub-Tab.
    And The user hover overs to "Category" menu headers and clicks "Televisions" sub menu headers
    And User adds "CELLO C3220G 32" item in his her wish list
    Then User validates the success message adding to wish list "Cello C3220G 32"



