package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage{


    @FindBy(xpath = "//*[@id='top-links']")
    public WebElement myAccountDropbox;

    @FindBy(xpath = "//*[@id='top-links']/ul/li/ul/li[1]")
    public WebElement myAccountDropboxButton;

    @FindBy(xpath = "//*[@id='column-right']/div/div/a[4]")
    public WebElement AddressBookButton;

    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]")
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

    @FindBy(xpath = "//*[@id='content']/form/fieldset/div[10]/div/label[1]/input")
    public WebElement defaultAddressRadioButton;

    @FindBy(xpath = "//*[@id='content']/form/div/div[2]")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id='account-address']/div[1]/text()")
    public WebElement createdNewAddressMessage;





}
