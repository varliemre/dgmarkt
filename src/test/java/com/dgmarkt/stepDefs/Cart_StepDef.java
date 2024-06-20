package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Cart_StepDef {
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();
    LoginPanel loginPanel = new LoginPanel();

    @Given("The user logged in with valid credentials {string} and {string} and is on the home page")
    public void the_user_is_on_the_home_page(String email, String password) {
        loginPanel.loginPanel();
        loginPage.navigateMyAccount("Login");
        BrowserUtils.waitForClickablility(loginPage.loginEmail, 2);
        BrowserUtils.waitForClickablility(loginPage.loginPassword, 2);
        loginPage.login(email, password);
        loginPage.loginBtn.click();


    }

    @When("The user selects a {string}")
    public void the_user_selects_a(String categoryName) {

        cartPage.select_Category(categoryName);
    }

    @When("The user selects a {string} from the categories")
    public void the_user_selects_a_from_the_categories(String product) {

        cartPage.select_product(product);


    }
    @When("The User clicks add to cart")
    public void the_user_clicks_add_to_cart() throws InterruptedException {
     cartPage.add_to_cart();

    }
    @Then("Verifies the {string} that the relevant product has been added to the cart")
    public void verifies_the_that_the_relevant_product_has_been_added_to_the_cart(String expectesMessage) {
        String actualMessage= cartPage.success_add_to_Cart_Msg.getText();
        BrowserUtils.waitFor(10);
        System.out.println("expectesMessage = " + expectesMessage);
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertTrue(actualMessage.contains(expectesMessage));
cartPage.navigateMyAccount("Logout");


    }



}