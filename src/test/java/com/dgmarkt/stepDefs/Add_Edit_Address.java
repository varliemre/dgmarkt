package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.AddressPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class Add_Edit_Address {

    AddressPage addressPage = new AddressPage();

    @Given("The user clicks on the MyAccount dropbox and clicks on the login button.")
    public void the_user_clicks_on_the_my_account_dropbox_and_clicks_on_the_login_button() {
        addressPage.myAccountDropbox.click();
        addressPage.loginButton.click();
    }
    @Then("The user clicks on the MyAccount dropbox and clicks on the myaccount button.")
    public void the_user_clicks_on_the_my_account_dropbox_and_clicks_on_the_myaccount_button() {
        BrowserUtils.waitFor(2);
        addressPage.myAccountDropbox.click();
        BrowserUtils.waitFor(2);
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
        dropdown.selectByIndex(2);

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
        String actualResoult = "Your address has been successfully added";
        String expectedResult = addressPage.createdNewAddressMessage.getText();
        Assert.assertEquals(actualResoult,expectedResult);
    }

}
