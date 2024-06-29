package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{


    @FindBy(xpath = "//a[text()='Wish List']")
    public WebElement wishListBtn;
  
    @FindBy(xpath = "//span[text()='Category']")
    public WebElement categoryNav;

     @FindBy(css = ".cbk_newsletter")
    public WebElement dontShowAgain;
    @FindBy(css = ".cbk_newsletter")
    public List<WebElement> dontShowAgain_l;

    @FindBy()
    public WebElement closePopupBtn;
  
    @FindBy(xpath = "//h2[text()='Returning Customer']")
    public WebElement loginMessageNewLoginStepl;

    public void clcikToWishList(){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", wishListBtn);
        wishListBtn.click();
    }

    public void clickWishListIcon(){
        WebElement wishlistIcon = Driver.get().findElement(By.id("wishlist-total"));
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", wishlistIcon);

    }
  
    

    public void loginMessageNewLoginStep(){
        String actualMessage="Returning Customer";
        Assert.assertEquals(loginMessageNewLoginStepl.getText(),actualMessage);
    }



    public void hoverOverToMenuHeadersAndSubMenuHeaders(String menuHeader, String subMenuHeader) {
        BrowserUtils.waitFor(2);
        new Actions(Driver.get()).moveToElement(Driver.get().findElement(By.xpath("//span[text()='" + menuHeader + "']"))).perform();


        Driver.get().findElement(By.xpath("//*[text()='" + subMenuHeader + "']")).click();
        BrowserUtils.waitFor(1);

    }


    public void navigateToCategory(String categoryName) {
        //hovering over to category navigator
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(categoryNav).perform();

        //clicking to the category
        Driver.get().findElement(By.xpath("//a[text()='" + categoryName + "']")).click();
    }


    public void closePopupButton(){
        BrowserUtils.waitFor(1);
        if (dontShowAgain_l.size()>0){
            dontShowAgain.click();
        }
        closePopupBtn.click();

    };

}
