package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CartPage extends BasePage {

    JavascriptExecutor jse;

    @FindBy(css = "[type='button']")
    public WebElement add_to_cart_Btn;
    @FindBy(xpath = "//div[text()='Success: You have added ']")
    public WebElement success_add_to_Cart_Msg;

    @FindBy(id = "input-limit")
    public WebElement show_konteyner;


    public void select_Category(String subCatagoryName) {

        WebElement catagoryHover = Driver.get().findElement(By.xpath("//*[.='Category']"));
        BrowserUtils.waitForClickablility(catagoryHover, 5);
        Actions actions = new Actions(Driver.get());
        BrowserUtils.waitFor(5);
        actions.moveToElement(catagoryHover).perform();
        BrowserUtils.waitFor(10);


        WebElement submenuWebElement = Driver.get().findElement(By.xpath("//a[contains(@class, 'a-mega-second-link') and text()='" + subCatagoryName + "']"));
        BrowserUtils.clickWithJS(submenuWebElement);

    }

    public void select_product(String productName)  {
        Select select=new Select(show_konteyner);
        BrowserUtils.waitFor(10);
        select.selectByVisibleText("100");



        WebElement productLocator = Driver.get().findElement(By.xpath("//h4[.='"+productName+"']"));

        BrowserUtils.waitForClickablility(productLocator, 20);

// JavaScriptExecutor ile elementin görünür olmasını sağla
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", productLocator);

// Beklemeyi bir süre daha uzat, tıklanabilir olmasını bekle
        BrowserUtils.waitFor(1); // Bu süreyi ihtiyaca göre ayarlayabilirsiniz

        try {
            productLocator.click();
        } catch (ElementClickInterceptedException e) {
            // Eğer tıklama başarısız olursa, JavaScript kullanarak tıklamayı deneyin
            jse.executeScript("arguments[0].click();", productLocator);
        }


    }


    public void add_to_cart() {
       WebElement add_to_cart_l = Driver.get().findElement(By.id("button-cart"));
        BrowserUtils.waitForClickablility(add_to_cart_l, 20);

// JavaScriptExecutor ile elementin görünür olmasını sağla
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", add_to_cart_l);

// Beklemeyi bir süre daha uzat, tıklanabilir olmasını bekle
        BrowserUtils.waitFor(1); // Bu süreyi ihtiyaca göre ayarlayabilirsiniz

        try {
            add_to_cart_l.click();
        } catch (ElementClickInterceptedException e) {
            // Eğer tıklama başarısız olursa, JavaScript kullanarak tıklamayı deneyin
            jse.executeScript("arguments[0].click();", add_to_cart_l);
        }


    }
}