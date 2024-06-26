package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    LoginPanel loginPanel = new LoginPanel();

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPanel.loginPanel();
        loginPage.navigateMyAccount("Login");

    }

    @When("The user enters a valid {string} and {string}")
    public void theUserEntersAValidAnd(String email, String password) {
        loginPage.login(email, password);
    }

    @And("The user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        BrowserUtils.waitFor(2);
        loginPage.loginBtn.click();
        BrowserUtils.waitForVisibility(loginPage.successMsg,2);
        
    }

    @Then("The user should see the message that you have successfully logged in")
    public void theUserShouldSeeTheMessageThatYouHaveSuccessfullyLoggedIn() {
        String expectedMsg = "Congratulation! Login Successfully";
        System.out.println("expectedMsg = " + expectedMsg);
        String actualMsg = loginPage.successMsg.getText();
        System.out.println("actualMsg = " + actualMsg);
        Assert.assertTrue(actualMsg.contains(expectedMsg));

    }
    @When("The user login with {string} and {string}")
    public void the_user_login_with_and(String email, String password) {
            loginPage.login(email, password);
        }
    @When("The user clicks the login button without filling in the required fields.")
    public void the_user_clicks_the_login_button_without_filling_in_the_required_fields() {
        BrowserUtils.waitFor(2);
        loginPage.loginBtn.click();
        BrowserUtils.waitForVisibility(loginPage.successMsg,2);

    }
    @Then("verify that the user cannot log in")
    public void verify_that_the_user_cannot_log_in() {


    }
    @When("The user enters valid username into {string} inputbox")
    public void the_user_enters_valid_username_into_inputbox(String string) {


    }
    @When("The user enters valid password into {string} inputbox")
    public void the_user_enters_valid_password_into_inputbox(String string) {


    }
    @Then("Password should be entered in a form of {string} by default")
    public void password_should_be_entered_in_a_form_of_by_default(String string) {


    }
    @When("The user clicks on the email field")
    public void the_user_clicks_on_the_email_field() {


    }
}
