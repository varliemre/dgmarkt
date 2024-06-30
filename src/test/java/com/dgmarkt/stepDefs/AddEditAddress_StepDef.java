package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.AddressPage;
import com.dgmarkt.pages.EditAddressPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Add_Edit_Address_StepDef {

    AddressPage addressPage = new AddressPage();
   EditAddressPage editAddressPage = new EditAddressPage();

    @Given("The user clicks on the MyAccount dropbox and clicks on the login button.")
    public void the_user_clicks_on_the_my_account_dropbox_and_clicks_on_the_login_button() {
        addressPage.myAccountDropbox.click();
        addressPage.loginButton.click();
    }
    @Then("The user clicks on the MyAccount dropbox and clicks on the myaccount button.")
    public void the_user_clicks_on_the_my_account_dropbox_and_clicks_on_the_myaccount_button() {

        addressPage.myAccountDropbox.click();
        BrowserUtils.waitFor(1);
        addressPage.myAccountDropboxButton.click();
    }
    @Then("The user clicks the Address Book button.")
    public void the_user_clicks_the_address_book_button() {
        addressPage.AddressBookButton.click();
    }
    @Then("The user clicks the New Address button.")
    public void the_user_clicks_the_new_address_button() {
        addressPage.newAddressButton.click();
    }
    @Then("The user enter valid {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_enter_valid_and_and_and_and_and_and(String firstName, String lastName, String company, String address1, String address2, String city, String postCode) {
        addressPage.inputFirstName.sendKeys(firstName);
        addressPage.inputLastName.sendKeys(lastName);
        addressPage.inputCompany.sendKeys(company);
        addressPage.inputAddress1.sendKeys(address1);
        addressPage.inputAddress2.sendKeys(address2);
        addressPage.inputCity.sendKeys(city);
        addressPage.inputPostCode.sendKeys(postCode);
    }
    @Then("The user click on the country dropbox and select country")
    public void the_user_click_on_the_country_dropbox_and_select_country() {
        WebElement dropboxSelect = addressPage.inputDropboxCountry;
        Select dropdown = new Select(dropboxSelect);

        dropdown.selectByIndex(2);

    }
    @Then("The user click on the region dropbox and select state")
    public void the_user_click_on_the_region_dropbox_and_select_state() {
        WebElement dropboxSelect = addressPage.inputDropboxZone;
        Select dropdown = new Select(dropboxSelect);
        BrowserUtils.waitFor(1);
        dropdown.selectByIndex(3);

    }
    @Then("The user select default address on the radio button to Yes")
    public void the_user_select_default_address_on_the_radio_button_to_yes() {
        addressPage.defaultAddressRadioButton.click();
    }
    @Then("The user click on the Continue button")
    public void the_user_click_on_the_continue_button() {
        addressPage.continueButton.click();
    }
    @Then("The user should see the message that Your address has been successfully added")
    public void the_user_should_see_the_message_that_your_address_has_been_successfully_added() {
        String actualResult = " Your address has been successfully added";
        String expectedResult = addressPage.createdNewAddressMessage.getText();
        System.out.println("Expected Result : "+ expectedResult);
        System.out.println("Actual Result : " + actualResult);
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


    @When("The user fills the Add Address form with data {string} and {string} and {string} and {string} and {string} and {string}")
    public void theUserFillsTheAddAddressFormWithInvalidFirstnameAndAndAndAndAnd(String firstName, String lastName, String company, String address1, String city, String postcode) {
        AddressPage.enterData(firstName, lastName,company, address1, city,postcode);

    }
    @And("The user selects country as {string}")
    public void theUserSelectsCountryAs(String country) {
        Select select = new Select(addressPage.inputDropboxCountry);
        select.selectByVisibleText(country);
    }

    @And("The user selects {string} as RegionState")
    public void the_user_selects_as_region_state(String region) {
        Select select =new Select(addressPage.inputDropboxZone);
        select.selectByVisibleText(region);

    }

    @Then("The user clicks continue button and see warning {string}")
    public void theUserClicksContinueButtonAndSeeWarning(String message) {
        addressPage.continueButton.click();
        Assert.assertTrue(addressPage.warningMessage(message).isDisplayed());
    }



    @When("The user does not select any country")
    public void the_user_does_not_select_any_country() {
        Select select = new Select(addressPage.inputDropboxCountry);
        select.selectByIndex(0);

    }

    @And("The user does not select any region and state")
    public void theUserDoesNotSelectAnyRegionAndState() {
        Select select =new Select(addressPage.inputDropboxZone);
        select.selectByIndex(0);
    }


 @And("The user clicks Edit button and navigates to Edit Address page")
    public void theUserClicksEditButtonAndNavigatesToEditAddressPage() {
        addressPage.editButton.click();
        Assert.assertTrue(editAddressPage.editAddressHeader.isDisplayed());
    }

    @When("The user fills the Address form with data {string} and {string} and {string} and {string} and {string} and {string}")
    public void theUserFillsTheAddressFormWithDataAndAndAndAndAnd(String firstName, String lastName, String company, String address1, String city, String postcode) {
        editAddressPage.clearData();
        AddressPage.enterData(firstName, lastName,company, address1, city,postcode);
}


}