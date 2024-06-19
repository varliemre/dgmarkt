package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "input-firstname")
    public WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    public WebElement lastNameInput;

    @FindBy(id = "input-register-email")
    public WebElement emailInput;

    @FindBy(id = "input-telephone")
    public WebElement telephoneInput;

    @FindBy(id = "input-register-password")
    public WebElement registerPasswordInput;

    @FindBy(id = "input-confirm")
    public WebElement registerConfirmPasswordInput;

    @FindBy(css = "input[value='1'][name='newsletter']")
    public WebElement subscribeYesBtn;

    @FindBy(css = "input[value='0'][name='newsletter']")
    public WebElement subscribeNoBtn;


    @FindBy(xpath = "//input[@name='agree']")
    public WebElement privacyPolicyCheckBoxBtn;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "(//span[text()='Continue'])[1]")
    public WebElement afterRegisterContinueBtn;

    @FindBy(xpath = "//h2[text()='Your Account Has Been Created!']")
    public WebElement successRegisterMsg;

    @FindBy(xpath = "//span[text()=' Warning: You must agree to the Privacy Policy!']")
    public WebElement privacyPolicyErrorMsg;

    @FindBy(xpath = "//span[normalize-space()='Warning: E-Mail Address is already registered!']")
    public WebElement registeredEmailErrorMsg;

    @FindBy(xpath = "//div[contains(@class, 'text-danger')]")
    public WebElement errorMessage;



    public void register(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(telephone);
        registerPasswordInput.sendKeys(password);
        registerConfirmPasswordInput.sendKeys(confirmPassword);
        subscribeNoBtn.click();
        privacyPolicyCheckBoxBtn.click();
        continueBtn.click();

    }


}
