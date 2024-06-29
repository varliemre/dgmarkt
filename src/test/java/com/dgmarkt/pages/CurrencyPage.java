package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyPage extends BasePage{
    @FindBy(xpath = "(//span[@class='hidden-xs'])[1]")
    public WebElement currencyDropDown;
    public void navigateCurrency (String currencyName){
        BrowserUtils.waitForClickablility(currencyDropDown,10);
        currencyDropDown.click();
        Driver.get().findElement(By.xpath("//li/button[contains(text(),"+currencyName+")]")).click();
    }
}
