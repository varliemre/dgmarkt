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
}
