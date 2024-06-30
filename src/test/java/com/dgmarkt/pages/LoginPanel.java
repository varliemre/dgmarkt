package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPanel extends BasePage {

    @FindBy(xpath = "//input[@name='email']")
    public WebElement loginPanelEmail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement loginPanelPassword;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginPanelBtn;



    public void loginPanel() {
        Driver.get().get(ConfigurationReader.get("url"));
        String email = ConfigurationReader.get("loginpanelemail");
        String password = ConfigurationReader.get("loginpanelpasswword");

        loginPanelEmail.sendKeys(email);
        loginPanelPassword.sendKeys(password);
        loginPanelBtn.click();
        BrowserUtils.waitFor(2);
        dontShowAgain.click();
        newsletterCloseBtn.click();

    }
}
