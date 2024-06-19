package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.CheckoutPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Checkout_StepDef {
    LoginPage loginPage=new LoginPage();
    LoginPanel loginPanel=new LoginPanel();
    CartPage cartPage=new CartPage();
    CheckoutPage checkoutPage=new CheckoutPage();


    @When("User clicks on the cart")
    public void user_clicks_on_the_cart_and_displays_the_cart() {
        checkoutPage.click_cart_Ikon();

    }
    @Then("verifies that the basket was imaged")
    public void verifies_that_the_basket_was_imaged() {
        String expectedText_Shopping_Cart="Shopping Cart";
        String actaul_Url= Driver.get().getCurrentUrl();
        String expected_Url="https://dgmarkt.com/index.php?route=checkout/cart";
        System.out.println("actaul_Url = " + actaul_Url);
        System.out.println("expected_Url = " + expected_Url);
        Assert.assertEquals(expected_Url,actaul_Url);

    }



    @Then("User verifies the amount {int} and quantity {int} of products in the cart")
    public void user_verifies_the_and_of_products_in_the_cart(int  amount , int  quantityy) {
        checkoutPage.produkt_list_in_Checkout(amount,quantityy);

    }
}
