package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.CheckoutPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

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
///////////////////////////////////////////////////////////////////

    @When("The user sees the shipping costs by entering the country address information")
    public void the_user_sees_the_shipping_costs_by_entering_the_country_address_information() {
        checkoutPage.shipping_l.click();
        BrowserUtils.waitFor(5);
        Select select=new Select(checkoutPage.country_l);
        select.selectByVisibleText("Turkey");
        BrowserUtils.waitFor(10);

        Select select1=new Select(checkoutPage.inputZone_l);
        select1.selectByVisibleText("Adana");

        checkoutPage.postcode_l.clear();
        checkoutPage.postcode_l.sendKeys("12345");
        checkoutPage.button_quote_l.click();
        checkoutPage.flat_radioBtn_l.click();
        checkoutPage.apply_shipping_btn_l.click();
        String actualMsg=checkoutPage.allert_succes_l.getText();
        String expectedMsg="Success: Your shipping estimate has been applied!";
        Assert.assertTrue(actualMsg.contains(expectedMsg));

    }
    @When("User clicks the Checkout icon")
    public void user_clicks_the_checkout_icon() {


        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.checkout_btn_l);
        checkoutPage.checkout_btn_l.click();
        BrowserUtils.waitForClickablility(checkoutPage.checkout_btn_l,20);

    }
    @When("User the existing address as the billing address and clicks Continue")
    public void user_the_existing_address_as_the_billing_address_and_clicks_continue() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        BrowserUtils.waitForClickablility(checkoutPage.billing_continue_btn_l,20);
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.billing_continue_btn_l);
        checkoutPage.billing_continue_btn_l.click();
        BrowserUtils.waitForClickablility(checkoutPage.billing_continue_btn_l,20);
    }
    @When("Click continue with the fixed price delivery option")
    public void click_continue_with_the_fixed_price_delivery_option() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.delivery_continue_btn_l);
        BrowserUtils.waitForClickablility(checkoutPage.order_comment_l,20);
        checkoutPage.order_comment_l.sendKeys("Lütfen siparisimi komsuya birakin");
        checkoutPage.delivery_continue_btn_l.click();
        BrowserUtils.waitForClickablility(checkoutPage.delivery_continue_btn_l,20);

    }
    @When("clicks I have read and accept the Terms and Conditions and clicks Continue")
    public void clicks_i_have_read_and_accept_the_terms_and_conditions_and_clicks_continue() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.term_condition_btn_l);
        checkoutPage.term_condition_btn_l.click();
        BrowserUtils.waitForClickablility(checkoutPage.term_condition_btn_l,20);

    }
    @When("Clicks Confirm Order after reviewing the order details")
    public void clicks_confirm_order_after_reviewing_the_order_details() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.confirm_oreder_btn_l);
        checkoutPage.confirm_oreder_btn_l.click();
        BrowserUtils.waitForClickablility(checkoutPage.confirm_oreder_btn_l,20);
    }
    @Then("Your order has been placed! verifies confirmation")
    public void your_order_has_been_placed_verifies_confirmation() {
        String expectedMsg="Your order has been placed!";
        String actualMsg=checkoutPage.ceckout_confirmation_msg_l.getText();
        BrowserUtils.waitFor(10);
        Assert.assertTrue(actualMsg.contains(expectedMsg));


    }

}
