package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Password']")
    public WebElement passwordMenu;

    @FindBy(id = "input-password")
    public WebElement passwordField;

    @FindBy(id = "input-confirm")
    public WebElement passwordConfirmField;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@class='text-danger']")
    public WebElement errorMessages;

}
