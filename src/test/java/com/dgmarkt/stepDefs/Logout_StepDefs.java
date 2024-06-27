package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.BasePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class Logout_StepDefs extends BasePage {
    LoginPage loginPage = new LoginPage();
    @When("The user clicks My Account dropdown button and clicks Logout button")
    public void the_user_clicks_my_account_dropdown_button_and_clicks_Logout_button() {
        loginPage.navigateMyAccount("Logout");
    }
    @When("The user clicks continue button for Logout")
    public void the_user_clicks_continue_button_for_logout() {
        logoutContinueBtn.click();
       // newsletterCloseBtn.click();
    }
    @When("The user clicks back button")
    public void the_user_clicks_back_button() {
        Driver.get().navigate().back();
        BrowserUtils.waitFor(3);
        //newsletterCloseBtn.click();
    }
    @Then("The user verifies that user is logged out")
    public void the_user_verifies_that_user_is_logged_out() {
        loginPage.navigateMyAccount("Login");
        String expectedLoginMsg="Login or create an account";
        String actualLoginMsg= loginMessage.getText();
        Assert.assertEquals(expectedLoginMsg,actualLoginMsg);
    }
}
