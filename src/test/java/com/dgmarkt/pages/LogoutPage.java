package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
    @FindBy(xpath = "(//button[@class='button'])[2]/*")
    public WebElement logoutContinueBtn;
    @FindBy(xpath = "(//h2[text()='Login or create an account'])[1]")
    public WebElement loginMessage;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement logoutContinueBtn2;
    @FindBy(xpath = "//h2[text()='Returning Customer']")
    public WebElement loginMessage2;
}

