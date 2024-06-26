package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyPage extends BasePage{
    @FindBy(xpath = "(//span[@class='hidden-xs'])[1]")
    public WebElement currencyDropDown;
    @FindBy(xpath = "(//*[@class='price'])[1]")
    public WebElement firstProductPrice;
    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[3]")
    public WebElement cartButton;
    @FindBy(xpath = "(//p/a/*)[2]")
    public WebElement checkoutButton;
    @FindBy(xpath = "((//*[@name='payment_address'])[1])")
    public WebElement I_want_to_use_an_existing_billing_address;
    @FindBy(css = "[id='button-shipping-method']")
    public WebElement deliveryMethodContinueButton;
    @FindBy(css = "[name='shipping_method']")
    public WebElement flatShippingRateButton;
    @FindBy(css = "[id='button-shipping-method']")
    public WebElement deliveryMethodContinueButton2;
    @FindBy(css = "[id='button-payment-method']")
    public WebElement deliveryMethodContinueButton3;

    @FindBy(css = "[name='payment_method']")
    public WebElement cashOnDeliveryButton;
    @FindBy(xpath = "//table/tfoot/tr/td[2]")
    public WebElement confirmationTable;

    public void navigateCurrency (String currencyName){
        BrowserUtils.waitForClickablility(currencyDropDown,10);
        currencyDropDown.click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//button[@name='"+currencyName+"']")).click();
    }
}
