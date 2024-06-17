package com.dgmarkt.pages;
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

    public void navigateMyAccount(String menuName){
        myAccountDropDown.click();
        Driver.get().findElement(By.xpath("//a[text()='"+ menuName+ "']")).click();
    }





}

