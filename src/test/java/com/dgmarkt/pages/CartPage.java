package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;





public class CartPage extends BasePage {
    @FindBy(xpath = "//button[text()='Add to Cart']")
    public WebElement add_to_cart_Btn;
    @FindBy(xpath = "//div[text()='Success: You have added ']")
    public WebElement success_add_to_Cart_Msg;




    public void select_Category(String subCatagoryName){

        WebElement catagoryHover = Driver.get().findElement(By.xpath("//*[.='Category']"));
        BrowserUtils.waitForClickablility(catagoryHover,20);
        Actions actions = new Actions(Driver.get());
        BrowserUtils.waitFor(20);
        actions.moveToElement(catagoryHover).perform();
        BrowserUtils.waitFor(200);

        //Driver.get().findElement(By.xpath("//a[contains(@class, 'a-mega-second-link') and text()='"+subCatagoryName+"']")).click();
         WebElement submenuWebElement = Driver.get().findElement(By.xpath("//a[contains(@class, 'a-mega-second-link') and text()='" + subCatagoryName + "']"));
       BrowserUtils.clickWithJS(submenuWebElement);
        BrowserUtils.waitForClickablility(submenuWebElement,200);
//a[contains(@class, 'a-mega-second-link') and text()='Health & Beauty']
    }
    public void select_product(String productName){
       // Driver.get().findElement(By.xpath("//*[.='"+productName+"']")).click();
    }
}
