package com.dgmarkt.pages;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@class='a-close-newsletter']")
    public WebElement newsletterCloseBtn;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    public WebElement myAccountDropDown;

    @FindBy(xpath = "(//button[@class='button'])[2]/*")
    public WebElement logoutContinueBtn;
    @FindBy(xpath = "(//h2[text()='Login or create an account'])[1]")
    public WebElement loginMessage;


    public void navigateMyAccount(String menuName){
        BrowserUtils.waitForClickablility(myAccountDropDown,10);
        myAccountDropDown.click();
        Driver.get().findElement(By.xpath("//a[text()='"+ menuName+ "']")).click();
    }





}

