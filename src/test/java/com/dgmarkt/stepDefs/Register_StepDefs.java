package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.pages.RegisterPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Register_StepDefs {

    LoginPanel loginPanel = new LoginPanel();
    RegisterPage registerPage = new RegisterPage();

    @Given("The user is on the Home page")
    public void theUserIsOnTheHomePage() {
        loginPanel.loginPanel();

    }

    @When("The user navigates to the Register page")
    public void theUserNavigatesToTheRegisterPage() {
        registerPage.navigateMyAccount("Register");

    }

    @And("The user register with {string} und {string} und {string} {string} und {string} und {string}")
    public void theUserRegisterWithUndUndUndUnd(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        registerPage.register(firstName, lastName, email, telephone, password, confirmPassword);

    }

    @Then("User should see a registration confirmation message")
    public void userShouldSeeARegistrationConfirmationMessage() {

        String expectedResult = "Your Account Has Been Created!";
        BrowserUtils.waitForVisibility(registerPage.successRegisterMsg,2);
        String actualResult = registerPage.successRegisterMsg.getText();
        System.out.println("actualResult = " + actualResult);
        Assert.assertEquals(expectedResult, actualResult);
        registerPage.afterRegisterContinueBtn.click();
    }

    @And("The user clicks on the continue without filling in the required fields.")
    public void theUserClicksOnTheContinueWithoutFillingInTheRequiredFields() {
        registerPage.continueBtn.click();

    }

    @Then("Verify that the user cannot register")
    public void verifyThatTheUserCannotRegister() {
        String expectedWarningMessage = "Warning: You must agree to the Privacy Policy!";
        String actaulWarningMessage = registerPage.subWarningMsg.getText();
        System.out.println("actaulWarningMessage = " + actaulWarningMessage);
        Assert.assertEquals(expectedWarningMessage,actaulWarningMessage);

    }

    @Then("Verify that error message {string}")
    public void verifyThatErrorMessage(String expectedErrorMsg) {
        String actualErrorMsg = registerPage.errorMessage.getText();
        System.out.println("actualErrorMsg = " + actualErrorMsg);
        System.out.println("expectedErrorMsg = " + expectedErrorMsg);
        Assert.assertEquals(expectedErrorMsg,actualErrorMsg);

    }
}
