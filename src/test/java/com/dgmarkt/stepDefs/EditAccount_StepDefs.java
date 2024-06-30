package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.BasePage;
import com.dgmarkt.pages.EditAccountPage;
import com.dgmarkt.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.dgmarkt.utilities.Driver.driver;

public class EditAccount_StepDefs {
    EditAccountPage editAccountPage = new EditAccountPage();
    HomePage homePage = new HomePage();


    @Given("The user clicks on the My Account button")
    public void theUserClicksOnTheMyAccountButton() {
        editAccountPage.myAccountFirstClick.click();
        editAccountPage.myAccountSecondClick.click();
    }

    @When("The user clicks on the Edit Account button")
    public void theUserClicksOnTheEditAccountButton() {
        editAccountPage.editAccount.click();
    }


    @When("The user updates the First Name as {string}")
    public void theUserUpdatesTheFirstNameAs(String firstName) {
        editAccountPage.editFirstName.clear();
        editAccountPage.editFirstName.sendKeys(firstName);
    }

    @When("The user updates the Last Name as {string}")
    public void theUserUpdatesTheLastNameAs(String lastName) {
        editAccountPage.editLastName.clear();
        editAccountPage.editLastName.sendKeys(lastName);
    }

    @Given("The user updates the email as {string}")
    public void theUserUpdatesTheEmailAs(String email) {
        editAccountPage.editEmailAddress.clear();
        editAccountPage.editEmailAddress.sendKeys(email);
    }

    @When("The user updates the telephone number as {string}")
    public void theUserUpdatesTheTelephoneNumberAs(String telephoneNum) {
        editAccountPage.editTelephoneNumber.clear();
        editAccountPage.editTelephoneNumber.sendKeys(telephoneNum);
    }

    @And("The user clicks on the Continue button")
    public void theUserClicksOnTheContinueButton() {
        editAccountPage.clickContinueButton.click();
    }

    @Then("The user updates their account successfully")
    public void theUserUpdatesTheirAccountSuccessfully() {
        Assert.assertTrue(editAccountPage.successfullyUpdate.isEnabled());
    }

    @And("The user clicks on the Back button")
    public void theUserClicksOnTheBackButton() {
        editAccountPage.clickBackButton.click();
        editAccountPage.editAccount.click();
    }

    @Then("The user can see the Edit Account without changes")
    public void theUserCanSeeTheEditAccountWithoutChanges() {
        Assert.assertEquals(editAccountPage.editFirstName.getAttribute("value"), "Dilek");
        Assert.assertEquals(editAccountPage.editLastName.getAttribute("value"), "Aba");
        Assert.assertEquals(editAccountPage.editEmailAddress.getAttribute("value"), "dilekttest@gmail.com");
        Assert.assertEquals(editAccountPage.editTelephoneNumber.getAttribute("value"), "9876543210");
    }

    @Given("The user updates the First Name as blank")
    public void theUserUpdatesTheFirstNameAsBlank() {
        editAccountPage.editFirstName.clear();
    }

    @When("The user enters valid credentials for the Edit Account login")
    public void theUserEntersValidCredentialsForTheEditAccountLogin() {

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("dilekttest@gmail.com");
        password.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();

       // WebElement driver = null;
       // WebElement editAccountButton = driver.findElement(By.xpath("//a[text()='Edit Account']"));
       // editAccountButton.click();

    }


    @When("The user updates the Last Name as blank")
    public void theUserUpdatesTheLastNameAsBlank() {
        editAccountPage.editLastName.clear();
    }

    @Then("The user should not be able to update their Edit Account with blank First Name")
    public void theUserShouldNotBeAbleToUpdateTheirEditAccountWithBlankFirstName() {
        Assert.assertEquals(editAccountPage.firstNameAlert.getText(), "First Name must be between 1 and 32 characters!");
    }

    @Then("The user should not be able to update their Edit Account with blank Last Name")
    public void theUserShouldNotBeAbleToUpdateTheirEditAccountWithBlankLastName() {
        Assert.assertEquals(editAccountPage.lastNameAlert.getText(), "Last Name must be between 1 and 32 characters!");
    }

    @Given("The user updates the email as blank")
    public void theUserUpdatesTheEmailAsBlank() {
        editAccountPage.editEmailAddress.clear();
    }

    @Then("The user should not be able to update their Edit Account with blank email")
    public void theUserShouldNotBeAbleToUpdateTheirEditAccountWithBlankEmail() {
        Assert.assertEquals(editAccountPage.emailAlert.getText(), "E-Mail Address does not appear to be valid!");
    }

    @Then("The user should not be able to update their Edit Account with invalid E-Mail")
    public void theUserShouldNotBeAbleToUpdateTheirEditAccountWithInvalidEMail() {
        Assert.assertEquals(editAccountPage.emailAlert.getText(), "E-Mail Address does not appear to be valid!");
    }

    @Then("The user should not be able to update their Edit Account with invalid First Name")
    public void theUserShouldNotBeAbleToUpdateTheirEditAccountWithInvalidFirstName() {
        Assert.assertEquals(editAccountPage.firstNameAlert.getText(), "First Name must be between 1 and 32 characters!");
    }

    @Then("The user should not be able to update their Edit Account with invalid Last Name")
    public void theUserShouldNotBeAbleToUpdateTheirEditAccountWithInvalidLastName() {
        Assert.assertEquals(editAccountPage.lastNameAlert.getText(), "Last Name must be between 1 and 32 characters!");
    }

    @Then("The user should not be able to update their Edit Account with invalid Telephone")
    public void theUserShouldNotBeAbleToUpdateTheirEditAccountWithInvalidTelephone() {
        Assert.assertEquals(editAccountPage.telephoneAlert.getText(), "Telephone must be between 3 and 32 characters!");
    }

    @And("Change the default credentials for the Edit Account")
    public void changeTheDefaultCredentialsForTheEditAccount() {
        editAccountPage.editAccount.click();
        editAccountPage.editFirstName.clear();
        editAccountPage.editFirstName.sendKeys("Dilek");
        editAccountPage.editLastName.clear();
        editAccountPage.editLastName.sendKeys("Aba");
        editAccountPage.editEmailAddress.clear();
        editAccountPage.editEmailAddress.sendKeys("dilekttest@gmail.com");
        editAccountPage.editTelephoneNumber.clear();
        editAccountPage.editTelephoneNumber.sendKeys("123456");
        editAccountPage.clickContinueButton.click();
    }

}