package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class Logout_StepDefs extends BasePage {
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();
    CartPage cartPage = new CartPage();
    @When("The user clicks My Account dropdown button and clicks Logout button")
    public void the_user_clicks_my_account_dropdown_button_and_clicks_Logout_button() {
        loginPage.navigateMyAccount("Logout");
    }
    @When("The user clicks continue button for Logout")
    public void the_user_clicks_continue_button_for_logout() {
        logoutPage.logoutContinueBtn.click();
        newsletterCloseBtn.click();
    }
    @When("The user clicks back button")
    public void the_user_clicks_back_button() {
        Driver.get().navigate().back();
        BrowserUtils.waitFor(3);
        newsletterCloseBtn.click();
    }
    @And("The user clicks back button once more")
    public void the_user_clicks_back_button_once_more() {
        Driver.get().navigate().back();
        BrowserUtils.waitFor(3);
    }
    @And("The user clicks on the {string} from the category page")
    public void the_user_clicks_on_the_from_the_category_page(String str) {
        cartPage.select_Category("Health & Beauty");
    }
    @And("The user clicks continue button on existing page for Logout")
    public void theUserClicksContinueButtonOnExistingPageForLogout() {
        logoutPage.logoutContinueBtn2.click();
        newsletterCloseBtn.click();
    }
    @Then("The user verifies that user is logged out")
    public void the_user_verifies_that_user_is_logged_out() {
        loginPage.navigateMyAccount("Login");
        String expectedLoginMsg="Login or create an account";
        String actualLoginMsg= logoutPage.loginMessage.getText();
        Assert.assertEquals(expectedLoginMsg,actualLoginMsg);
    }


    @Then("The user verifies that user is logged out on existing page")
    public void theUserVerifiesThatUserIsLoggedOutOnExistingPage() {
        loginPage.navigateMyAccount("Login");
        Assert.assertTrue(logoutPage.loginMessage2.isDisplayed());
    }
}
