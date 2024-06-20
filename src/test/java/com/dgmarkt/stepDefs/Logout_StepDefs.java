package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout_StepDefs {
    LoginPage loginPage = new LoginPage();

    @When("The user clicks My Account dropdown button and clicks Logout button")
    public void the_user_clicks_my_account_dropdown_button_and_clicks_Logout_button() {
        loginPage.navigateMyAccount("Logout");
    }

    @When("The user clicks continue button for Logout")
    public void the_user_clicks_continue_button_for_logout() {

    }
    @Then("The user verifies that user is logged out")
    public void the_user_verifies_that_user_is_logged_out() {

    }


}
