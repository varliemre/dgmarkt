package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.ComparePage;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Compare_StepDefs {
    ComparePage comparePage=new ComparePage();

    @Given("User adds {string} item in his her compare page")
    public void user_adds_item_in_his_her_compare_page(String productName) {
        comparePage.addProductToCompare(productName);

    }
    @And("The user clicks the product comparison button and navigate to product comparison page")
    public void the_user_clicks_the_product_comparison_button_and_navigate_to_product_comparison_page() {
        comparePage.productCompareButton.click();
    }
    @Then("The user should see product comparison text on the page")
    public void the_user_should_see_product_comparison_text_on_the_page() {
        comparePage.verifyProductText();

    }
    @Then("The user should see the products on the comparison page")
    public void the_user_should_see_the_products_on_the_comparison_page() {
        comparePage.comparePageProductVerify("Cello C3220G 32\" LED-backlit LCD TV");

    }
    @And("The user clicks the Remove button to remove products")
    public void the_user_clicks_the_remove_button_to_remove_products() throws InterruptedException {
        comparePage.theUserClicksTheRemoveButtonToRemoveProducts();

    }
    @Then("The user should not see any products in the page")
    public void the_user_should_not_see_any_products_in_the_page() {
        comparePage.verifyThereisNoProductAfterRemove();

    }

}
