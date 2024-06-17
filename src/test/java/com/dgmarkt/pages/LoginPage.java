package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement loginEmail;

    @FindBy(id = "input-password")
    public WebElement loginPassword;

    @FindBy(xpath = "//span[normalize-space()='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[text()=' Congratulation! Login Successfully']")
    public WebElement successMsg;

    public void login(String email,String password){
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);

    }

}
