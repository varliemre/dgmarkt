package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.ChangePasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChangePassword_StepDefs {
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @When("The user navigates to the {string} page")
    public void theUserNavigatesToThePage(String menuName) {
        changePasswordPage.navigateMyAccount(menuName);
    }

    @And("The user goes to the Password tab")
    public void theUserGoesToThePasswordTab() {
        changePasswordPage.passwordMenu.click();
    }

    @Given("The user enters the {string} in the password field")
    public void theUserEntersTheInThePasswordField(String newPassword) {
        changePasswordPage.passwordField.sendKeys(newPassword);

    }

    @When("The user enters the {string} in the password confirm field")
    public void theUserEntersTheInThePasswordConfirmField(String confirmPassword) {
        changePasswordPage.passwordConfirmField.sendKeys(confirmPassword);
    }


    @And("The user clicks the continue button")
    public void theUserClicksTheContinueButton() {
        changePasswordPage.continueBtn.click();

    }

    @Then("Verify that the successful {string}")
    public void verifyThatTheSuccessful(String expectedMessage) {
        String actualMessage = changePasswordPage.successMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        System.out.println("expectedMessage = " + expectedMessage);

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Then("The user should see an {string} in Password Page")
    public void theUserShouldSeeAnInPasswordPage(String expectedErrorMessage) {
        String actualErrorMessage = changePasswordPage.errorMessages.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
