package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @When("The user clicks the login button without filling in the required fields.")
    public void the_user_clicks_the_login_button_without_filling_in_the_required_fields() {
        BrowserUtils.waitFor(2);
        loginPage.loginBtn.click();
        String expectedMsg = " Warning: No match for E-Mail Address and/or Password.";
        System.out.println("expectedMsg = " + expectedMsg);
        String actualMsg = loginPage.errorMsg.getText();
        System.out.println("actualMsg = " + actualMsg);
        Assert.assertEquals(expectedMsg, actualMsg);
    }
    @Then("verify that the user cannot log in")
    public void verify_that_the_user_cannot_log_in() {
        BrowserUtils.waitForVisibility(loginPage.errorMsg,20);
        String expectedMsg = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.\n" +
                "×";
        System.out.println("expectedMsg = " + expectedMsg);
        String actualMsg = loginPage.errorMsg.getText();
        System.out.println("actualMsg = " + actualMsg);
        Assert.assertEquals(expectedMsg,actualMsg);

    }
    @When("The user enters valid username into {string} inputbox")
    public void the_user_enters_valid_username_into_inputbox(String email) {
        BrowserUtils.waitFor(2);
        loginPage.loginEmail.sendKeys(email);


    }
    @When("The user enters valid password into {string} inputbox")
    public void the_user_enters_valid_password_into_inputbox(String password) {
        loginPage.loginPassword.sendKeys(password);
    }
    @Then("Password should be entered in a form of {string} by default")
    public void password_should_be_entered_in_a_form_of_by_default(String string) {



    }
    @When("The user clicks on the email field")
    public void the_user_clicks_on_the_email_field() {
        loginPage.loginEmail.click();

    }

    @And("The user presses the Tab key on the login field")
    public void theUserPressesTheTabKeyOnTheLoginField() {
        WebElement activeElement = Driver.get().switchTo().activeElement();
        activeElement.sendKeys(Keys.TAB);

    }

    @Then("Verify that the cursor is in the email field with the {string} id on the login field")
    public void verifyThatTheCursorIsInTheEmailFieldWithTheIdOnTheLoginField(String expectedID) {
        WebElement activeElement = Driver.get().switchTo().activeElement();
        String actualID = activeElement.getAttribute("id");
        Assert.assertEquals(expectedID, actualID);


    }

    @When("The user clicks on the login button just")
    public void theUserClicksOnTheLoginButtonWithoutFillingInTheFields() {
        BrowserUtils.waitFor(2);
        loginPage.loginBtn.click();

    }

    @Then("Verify that login error message {string}")
    public void verifyThatLoginErrorMessage(String expectedWarningMessage) {
        BrowserUtils.waitForVisibility(loginPage.errorMsg,20);
        boolean isWarningMsgDisplayed = false;
        boolean isErrorMsgDisplayed = false;

        try {
            isWarningMsgDisplayed = loginPage.warningMsg.isDisplayed();
        } catch (Exception e) {
            // Do nothing, as the element might not be present
        }

        try {
            isErrorMsgDisplayed = loginPage.errorMsg.isDisplayed();
        } catch (Exception e) {
            // Do nothing, as the element might not be present
        }

        Assert.assertTrue("Expected one of the warning messages to be displayed", isWarningMsgDisplayed || isErrorMsgDisplayed);
    }



    @Then("Verify that error message login {string}")
    public void verifyThatErrorMessageLogin(String expectedErrorMsg) {
        BrowserUtils.waitForVisibility(loginPage.warningMsg,20);
        String expectedMsg = "//*[text()=' Warning: No match for E-Mail Address and/or Password.']\n" +
                "×";
        System.out.println("expectedMsg = " + expectedMsg);
        String actualMsg = loginPage.warningMsg.getText();
        System.out.println("actualMsg = " + actualMsg);
        Assert.assertEquals(expectedMsg,actualMsg);
    }

    @Then("Password should be entered in a form of by default")
    public void passwordShouldBeEnteredInAFormOfByDefault() {
        String passwordInputType = loginPage.getPasswordInputType();
        Assert.assertEquals("password", passwordInputType);
    }

    @Then("The user should see an error message")
    public void theUserShouldSeeAnErrorMessage() {
        Assert.assertTrue(loginPage.warningMsg.isDisplayed());
        String warningMessage= loginPage.warningMsg.getText();
        System.out.println("warningMessage = " + warningMessage);
    }}
