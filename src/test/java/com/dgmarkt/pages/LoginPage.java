package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath="//span[text()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath="//a[text()='Login']")
    public WebElement loginAccount;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement loginEmail;

    @FindBy(id = "input-password")
    public WebElement loginPassword;

    @FindBy(xpath = "//span[normalize-space()='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[text()=' Congratulation! Login Successfully']")
    public WebElement successMsg;
    @FindBy(xpath = "//*[text()=' Warning: No match for E-Mail Address and/or Password.']")
    public WebElement warningMsg;
    @FindBy(xpath="//*[text()=' Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.']")
    public WebElement errorMsg;
    @FindBy(xpath = "//div[contains(@class, 'alert alert-danger')]")
    public WebElement errorMessage;

    public String getPasswordInputType() {
        return loginPassword.getAttribute("type");
    }
    public void enterPassword(String password) {
        loginPassword.sendKeys(password);
    }
    public void enterEmail(String email){loginEmail.sendKeys(email);}

    public void login(String email,String password){
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);

    }



}
