package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.CheckoutPage;
import com.dgmarkt.pages.CurrencyPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Currency_StepDefs {
    LoginPage loginPage = new LoginPage();
    CurrencyPage currencyPage = new CurrencyPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    @When("The user navigates to the currency selection dropdown and click {string} currency")
    public void the_user_navigates_to_the_currency_selection_dropdown_and_click_currency(String currencyName) {
        currencyPage.navigateCurrency(currencyName);
    }
    @Then("The user verifies that the prices of products are displayed in the {string} currency")
    public void the_user_verifies_that_the_prices_of_products_are_displayed_in_the_currency(String currencySymbol) {
    loginPage.newsletterCloseBtn.click();
    cartPage.select_Category("Health & Beauty");
    BrowserUtils.scrollToElement(currencyPage.firstProductPrice);
    BrowserUtils.waitFor(2);
    Assert.assertTrue(currencyPage.firstProductPrice.getText().contains(currencySymbol));
    }

    @When("The user navigates to TV Accessories page and add the first product to cart")
    public void the_user_navigates_to_tv_accessories_page_and_add_the_first_product_to_cart() {
        cartPage.select_Category("TV Accessories");
        BrowserUtils.scrollToElement(currencyPage.firstProductPrice);
        cartPage.select_product("Belkin adapter cable");
        Driver.get().findElement(By.id("button-cart")).click();
    }
    @When("The user navigates to checkout page")
    public void the_user_navigates_to_checkout_page() {
        currencyPage.cartButton.click();
        currencyPage.checkoutButton.click();
    }
    @When("The user fills the checkout form")
    public void the_user_fills_the_checkout_form() {
        checkoutPage.I_want_to_use_a_new_billing_address_l.click();
        checkoutPage.billing_adress_list_fill("ASD","asd","zxc","sss","qqq");
       // checkoutPage.billing_continue_btn_l.click();
//        checkoutPage.I_want_to_use_a_new_delivery_address_l.click();
//        checkoutPage.delivery_adress_list_fill("zz","ert","zxxc","kkk","ooo");
       // checkoutPage.delivery_continue_btn_l.click();
        currencyPage.I_want_to_use_an_existing_billing_address.click();
        checkoutPage.delivery_continue_btn_l.click();
        checkoutPage.flat_radioBtn_l.click();
        //checkoutPage.delivery_method_continue_l.click();
        currencyPage.deliveryMethodContinueButton.click();
        checkoutPage.term_condition_btn_l.click();
        checkoutPage.payment_continue_l.click();

    }
    @Then("Verify that the order summary displays prices in the selected currency")
    public void verify_that_the_order_summary_displays_prices_in_the_selected_currency() {

    }
}
