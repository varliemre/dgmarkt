package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.CurrencyPage;
import com.dgmarkt.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Currency_StepDefs {
    LoginPage loginPage = new LoginPage();
    CurrencyPage currencyPage = new CurrencyPage();
    CartPage cartPage = new CartPage();
    @When("The user navigates to the currency selection dropdown and click {string} currency")
    public void the_user_navigates_to_the_currency_selection_dropdown_and_click_currency(String Currency) {
        currencyPage.navigateCurrency("Currency");
    }
    @Then("The user verifies that the prices of products are displayed in the {string} currency")
    public void the_user_verifies_that_the_prices_of_products_are_displayed_in_the_currency(String string) {
    loginPage.newsletterCloseBtn.click();
    cartPage.select_Category("Health & Beauty");
    }
}
