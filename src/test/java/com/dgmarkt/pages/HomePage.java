package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[text()='Wish List']")
    public WebElement wishListBtn;

    public void clcikToWishList(){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", wishListBtn);
        wishListBtn.click();
    }

    public void clickWishListIcon(){
        WebElement wishlistIcon = Driver.get().findElement(By.id("wishlist-total"));
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", wishlistIcon);

    }

}
