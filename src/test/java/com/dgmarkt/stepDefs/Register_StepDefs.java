package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.pages.RegisterPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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
        BrowserUtils.waitForVisibility(registerPage.successRegisterMsg, 2);
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
        String actaulWarningMessage = registerPage.privacyPolicyErrorMsg.getText();
        System.out.println("actaulWarningMessage = " + actaulWarningMessage);
        Assert.assertEquals(expectedWarningMessage, actaulWarningMessage);

    }

    @Then("Verify that error message {string}")
    public void verifyThatErrorMessage(String expectedErrorMsg) {
        String actualErrorMsg = registerPage.errorMessage.getText();
        System.out.println("actualErrorMsg = " + actualErrorMsg);
        System.out.println("expectedErrorMsg = " + expectedErrorMsg);
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);

    }

    @And("The user enters the password {string}")
    public void theUserEntersThePassword(String password) {
        registerPage.registerPasswordInput.sendKeys(password);

    }

    @And("The user enters the same password {string} in the confirm password field")
    public void theUserEntersTheSamePasswordInTheConfirmPasswordField(String confirmPassword) {
        registerPage.registerConfirmPasswordInput.sendKeys(confirmPassword);
    }

    @Then("The password should be encrypted and displayed as {string} in the input fields")
    public void thePasswordShouldBeEncryptedAndDisplayedAsInTheInputFields(String expectedDisplay) {
        String actualPasswordType = registerPage.registerPasswordInput.getAttribute("type");
        System.out.println("actualPasswordType = " + actualPasswordType);

        Assert.assertEquals("password", actualPasswordType);   // Tarayıcı, bir input alanının type özniteliği "password" olduğunda bu alanı yıldız karakterleri ile gösterir.

        String actualConfirmPasswordType = registerPage.registerConfirmPasswordInput.getAttribute("type");
        System.out.println("actualConfirmPasswordType = " + actualConfirmPasswordType);

        Assert.assertEquals("password", actualConfirmPasswordType); // Tarayıcı, bir input alanının type özniteliği "password" olduğunda bu alanı yıldız karakterleri ile gösterir.
    }


    @Then("Verify that Email already registered error message {string}")
    public void verifyThatEmailAlreadyRegisteredErrorMessage(String expectedErrorMsg) {
        String actualErrorMsg = registerPage.registeredEmailErrorMsg.getText();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);

    }

    @Then("The user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String expectedInvalidEmailErrorMsg) {
        String actualInvalidEmailErrorMsg = registerPage.errorMessage.getText();
        System.out.println("actualInvalidEmailErrorMsg = " + actualInvalidEmailErrorMsg);
        System.out.println("expectedInvalidEmailErrorMsg = " + expectedInvalidEmailErrorMsg);
        Assert.assertEquals(expectedInvalidEmailErrorMsg, actualInvalidEmailErrorMsg);
    }

    @When("The user fills out the registration form without accepting the privacy policy {string} und {string} und {string} {string} und {string} und {string}")
    public void theUserFillsOutTheRegistrationFormWithoutAcceptingThePrivacyPolicyUndUndUndUnd(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {

        registerPage.registerWithoutPrivacyPolicy(firstName, lastName, email, telephone, password, confirmPassword);
    }

    @Then("The user should see an Privacy Policy Error Message {string}")
    public void theUserShouldSeeAnPrivacyPolicyErrorMessage(String expectedPrivacyPolicyErrorMsg) {
        String actualPrivacyPolicyErrorMsg = registerPage.privacyPolicyErrorMsg.getText();
        System.out.println("actualPrivacyPolicyErrorMsg = " + actualPrivacyPolicyErrorMsg);
        Assert.assertEquals(expectedPrivacyPolicyErrorMsg, actualPrivacyPolicyErrorMsg);

    }

    @When("The user clicks on the First Name field")
    public void theUserClicksOnTheFirstNameField() {
        registerPage.firstNameInput.click();
    }

    @And("The user presses the Tab key")
    public void theUserPressesTheTabKey() {
        WebElement activeElement = Driver.get().switchTo().activeElement();
        activeElement.sendKeys(Keys.TAB);
    }


    @Then("Verify that the cursor is in the email field with the {string} id")
    public void verifyThatTheCursorIsInTheEmailFieldWithTheId(String expectedID) {
        WebElement activeElement = Driver.get().switchTo().activeElement();
        String actualID = activeElement.getAttribute("id");
        Assert.assertEquals(expectedID, actualID);
    }
}
