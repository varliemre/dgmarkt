package com.dgmarkt.pages;

import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddressPage extends BasePage{


    @FindBy(xpath = "//*[@id=\"top-links\"]")
    public WebElement myAccountDropbox;

    @FindBy(id = "pt-login-link")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li/ul/li[1]")
    public WebElement myAccountDropboxButton;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/div/a[4]")
    public WebElement AddressBookButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]")
    public WebElement newAddressButton;

    @FindBy(id = "input-firstname")
    public WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    public WebElement inputLastName;

    @FindBy(id = "input-company")
    public WebElement inputCompany;

    @FindBy(id = "input-address-1")
    public WebElement inputAddress1;

    @FindBy(id = "input-address-2")
    public WebElement inputAddress2;

    @FindBy(id = "input-city")
    public WebElement inputCity;

    @FindBy(id = "input-postcode")
    public WebElement inputPostcode;

    @FindBy(id = "input-postcode")
    public WebElement inputPostCode;

    @FindBy(id = "input-country")
    public WebElement inputDropboxCountry;


    @FindBy(id = "input-zone")
    public WebElement inputDropboxZone;


    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div[10]/div/label[1]/input")
    public WebElement defaultAddressRadioButton;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]")
    public WebElement continueButton;

    @FindBy(xpath = "//*[text()=' Your address has been successfully added']")
    public WebElement createdNewAddressMessage;

    @FindBy(xpath = "//a[text()='Edit']")
    public WebElement editButton;






    public WebElement warningMessage(String message)
    {
        return Driver.get().findElement(By.xpath("//div[text()='"+message+"']"));

    }

    public static WebElement inputBox(String inputName) {

        return Driver.get().findElement(By.xpath("//input[@placeholder='" + inputName + "']"));
    }

    public static void enterData(String firstName, String lastName, String company, String address1, String city, String postcode) {
        inputBox("First Name").sendKeys(firstName);
        inputBox("Last Name").sendKeys(lastName);
        inputBox("Company").sendKeys(company);
        inputBox("Address 1").sendKeys(address1);
        inputBox("City").sendKeys(city);
        inputBox("Post Code").sendKeys(postcode);
    }


}