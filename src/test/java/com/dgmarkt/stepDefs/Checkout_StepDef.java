package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.CheckoutPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class Checkout_StepDef {
    LoginPage loginPage = new LoginPage();
    LoginPanel loginPanel = new LoginPanel();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();


    @When("User clicks on the cart")
    public void user_clicks_on_the_cart_and_displays_the_cart() {
        checkoutPage.click_cart_Ikon();

    }

    @Then("verifies that the basket was imaged")
    public void verifies_that_the_basket_was_imaged() {
        String expectedText_Shopping_Cart = "Shopping Cart";
        String actaul_Url = Driver.get().getCurrentUrl();
        String expected_Url = "https://dgmarkt.com/index.php?route=checkout/cart";
        System.out.println("actaul_Url = " + actaul_Url);
        System.out.println("expected_Url = " + expected_Url);
        Assert.assertEquals(expected_Url, actaul_Url);

    }


    @Then("User verifies the amount {int} and quantity {int} of products in the cart")
    public void user_verifies_the_and_of_products_in_the_cart(int amount, int quantityy) {
        checkoutPage.produkt_list_in_Checkout(amount, quantityy);

    }
///////////////////////////////////////////////////////////////////

    @When("The user sees the shipping costs by entering the country address information")
    public void the_user_sees_the_shipping_costs_by_entering_the_country_address_information() {
        checkoutPage.shipping_l.click();
        BrowserUtils.waitFor(5);
        Select select = new Select(checkoutPage.country_l);
        select.selectByVisibleText("Turkey");
        BrowserUtils.waitFor(10);

        Select select1 = new Select(checkoutPage.inputZone_l);
        select1.selectByVisibleText("Adana");

        checkoutPage.postcode_l.clear();
        checkoutPage.postcode_l.sendKeys("12345");
        checkoutPage.button_quote_l.click();
        checkoutPage.flat_radioBtn_l.click();
        checkoutPage.apply_shipping_btn_l.click();
        String actualMsg = checkoutPage.allert_succes_l.getText();
        String expectedMsg = "Success: Your shipping estimate has been applied!";
        Assert.assertTrue(actualMsg.contains(expectedMsg));

    }

    @When("User clicks the Checkout icon")
    public void user_clicks_the_checkout_icon() {


        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.checkout_btn_l);
        BrowserUtils.waitFor(30);
        BrowserUtils.clickWithJS(checkoutPage.checkout_btn_l);
        //checkoutPage.checkout_btn_l.click();
        BrowserUtils.waitForClickablility(checkoutPage.checkout_btn_l, 60);

    }

    @When("User the existing address as the billing address and clicks Continue")
    public void user_the_existing_address_as_the_billing_address_and_clicks_continue() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        Select select = new Select(checkoutPage.adress_konteyner_billing_l);//mevcut adreslerden birisi secildi
        BrowserUtils.waitFor(10);
        select.selectByIndex(1);
        BrowserUtils.waitFor(10);

        //jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.billing_continue_btn_l);
        BrowserUtils.waitFor(20);
        ;
        //checkoutPage.flat_radioBtn_l.click();
        // checkoutPage.billing_continue_btn_l.click();

        BrowserUtils.clickWithJS(checkoutPage.billing_continue_btn_l);

    }

    @When("User the existing address as the delivery address and clicks Continue")
    public void user_the_existing_address_as_the_delivery_address_and_clicks_continue() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        Select select = new Select(checkoutPage.adress_konteyner_delivery_l);//mevcut adreslerden birisi secildi
        BrowserUtils.waitFor(10);
        select.selectByIndex(1);
        BrowserUtils.waitFor(10);


        BrowserUtils.waitFor(20);
        ;


        BrowserUtils.clickWithJS(checkoutPage.delivery_continue_btn_l);

    }

    @When("Click continue with the fixed price delivery option")
    public void click_continue_with_the_fixed_price_delivery_option() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.order_comment_l);
        checkoutPage.order_comment_l.sendKeys("Cargomun komsuma birakilmasini istiyorum");
        BrowserUtils.waitFor(15);
        BrowserUtils.clickWithJS(checkoutPage.delivery_method_continue_l);
        BrowserUtils.waitFor(15);


    }

    @When("clicks I have read and accept the Terms and Conditions and clicks Continue")
    public void clicks_i_have_read_and_accept_the_terms_and_conditions_and_clicks_continue() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.term_condition_btn_l);
        BrowserUtils.clickWithJS(checkoutPage.term_condition_btn_l);

        BrowserUtils.waitForClickablility(checkoutPage.term_condition_btn_l, 55);
        BrowserUtils.clickWithJS(checkoutPage.payment_continue_l);


    }

    @When("Clicks Confirm Order after reviewing the order details")
    public void clicks_confirm_order_after_reviewing_the_order_details() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.confirm_oreder_btn_l);
        BrowserUtils.waitForClickablility(checkoutPage.confirm_oreder_btn_l, 55);
        BrowserUtils.clickWithJS(checkoutPage.confirm_oreder_btn_l);


    }

    @Then("Your order has been placed! verifies confirmation")
    public void your_order_has_been_placed_verifies_confirmation() {
        String expectedMsg = "Your Order Has Been Placed!";
        System.out.println("expectedMsg = " + expectedMsg);
        String actualMsg = checkoutPage.ceckout_confirmation_msg_l.getText();
        System.out.println("actualMsg = " + actualMsg);
        BrowserUtils.waitFor(10);
        Assert.assertTrue(actualMsg.contains(expectedMsg));


    }

    @When("The user clicks I want to use a new billing address")
    public void the_user_clicks_i_want_to_use_a_new_billing_address() {
        BrowserUtils.waitFor(5);
        BrowserUtils.clickWithJS(checkoutPage.I_want_to_use_a_new_billing_address_l);
        BrowserUtils.waitFor(5);
    }


    @And("Fill in the billing address form {string}  {string},{string} ,{string} ,{string}  on the page that opens and click continue")
    public void fillInTheBillingAddressFormOnThePageThatOpensAndClickContinue(String firstName, String lastName, String Address1,
                                                                              String City, String PostCode) {
        checkoutPage.billing_adress_list_fill(firstName, lastName, Address1, City, PostCode);
    }

    @When("The user clicks I want to use a new delivery address")
    public void the_user_clicks_i_want_to_use_a_new_delivery_address() {
        BrowserUtils.waitFor(5);
        BrowserUtils.clickWithJS(checkoutPage.I_want_to_use_a_new_delivery_address_l);
        BrowserUtils.waitFor(10);
    }

    @And("Fill in the delivery address form {string}  {string},{string} ,{string} ,{string}  on the page that opens and click continue")
    public void fillInTheDeliveryAddressFormOnThePageThatOpensAndClickContinue(String firstName, String lastName, String Address1,
                                                                               String City, String PostCode) {
        checkoutPage.delivery_adress_list_fill(firstName, lastName, Address1, City, PostCode);
    }

    @And("Fill in the billing address form {string}  {string},{string} ,{string} ,{string} and {string}  on the page that opens and click continue")
    public void fillInTheBillingAddressFormAndOnThePageThatOpensAndClickContinue(String firstName, String lastName, String Address1,
                                                                                 String City, String PostCode,String warnungMesg) {
        checkoutPage.invalid_billing_adress_list_fill(firstName, lastName, Address1, City, PostCode, warnungMesg);
    }

    @And("Fill in the delivery address form {string}  {string},{string} ,{string} ,{string} and {string} on the page that opens and click continue")
    public void fillInTheDeliveryAddressFormAndOnThePageThatOpensAndClickContinue(String firstName, String lastName, String Address1,
                                                                                  String City, String PostCode,String warnungMesg) {
        checkoutPage.invalid_delivery_adress_list_fill(firstName, lastName, Address1, City, PostCode, warnungMesg);
    }
}