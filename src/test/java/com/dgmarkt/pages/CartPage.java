package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;


public class CartPage extends BasePage {

    JavascriptExecutor jse;
    private static WebDriverWait wait;

    @FindBy(css = "[type='button']")
    public WebElement add_to_cart_Btn;
    @FindBy(xpath = "//div[text()='Success: You have added ']")
    public WebElement success_add_to_Cart_Msg;

    @FindBy(id = "input-limit")
    public WebElement show_konteyner;
    @FindBy(css = "[id='content']")
    public WebElement cart_emptyMsg;


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

    public void select_product(String productName) {
        Select select = new Select(show_konteyner);
        BrowserUtils.waitFor(11);
        select.selectByVisibleText("100");

        BrowserUtils.waitFor(32);

        //WebElement productLocator = Driver.get().findElement(By.xpath("//h4[.='" + productName + "']"));
        WebElement productLocator = Driver.get().findElement(By.xpath("//img[@alt='" + productName + "']"));


// JavaScriptExecutor ile elementin görünür olmasını sağla
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", productLocator);


// Beklemeyi bir süre daha uzat, tıklanabilir olmasını bekle
        BrowserUtils.waitFor(35); // Bu süreyi ihtiyaca göre ayarlayabilirsiniz


        try {
            productLocator.click();
        } catch (ElementClickInterceptedException e) {
            BrowserUtils.waitFor(12);
            // Eğer tıklama başarısız olursa, JavaScript kullanarak tıklamayı deneyin
            jse.executeScript("arguments[0].click();", productLocator);
        }
    }


    public void add_to_cart() {
        //WebElement add_to_cart_l = Driver.get().findElement(By.id("button-cart"));
        WebElement add_to_cart_l = Driver.get().findElement(By.xpath("//*[@id='button-cart']"));
        BrowserUtils.waitForClickablility(add_to_cart_l, 33);

// JavaScriptExecutor ile elementin görünür olmasını sağla
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", add_to_cart_l);

// Beklemeyi bir süre daha uzat, tıklanabilir olmasını bekle
        BrowserUtils.waitFor(60); // Bu süreyi ihtiyaca göre ayarlayabilirsiniz

        try {
            // Click the "Add to Cart" button
            BrowserUtils.clickWithJS(add_to_cart_l);

            // Optional: Handle any pop-ups or alerts that appear after clicking "Add to Cart"
            // Example: If there's a confirmation popup, handle it using WebDriver's switchTo() method

            // Example: Navigating to the Cart page after adding the item
            // Assuming there's a link or button that navigates to the Cart page, you'd do something like:
            // WebElement cart_link = Driver.get().findElement(By.xpath("//a[@id='cart-link']"));
            // cart_link.click();

            // Example: Verification that the item was successfully added to the cart
            // You might assert the presence of a success message or check the cart contents

        } catch (Exception e) {
            // Handle any exceptions that occur during the add to cart process
            e.printStackTrace();
            // You might want to log the error or handle it gracefully
        }
    }


        public void removeAllItemsFromCart() {
            // Öğeleri bul
            List<WebElement> elements = Driver.get().findElements(By.xpath("//*[@class='input-group btn-block']"));

            for (int i = 0; i < elements.size(); i++) {
                // "Kaldır" butonunun tıklanabilir olmasını bekle
                WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
                WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-original-title='Remove']")));

                try {
                    // "Kaldır" butonuna tıkla
                    removeButton.click();

                    // Kaldırma işlemi tamamlanana kadar bekle
                    wait.until(ExpectedConditions.stalenessOf(elements.get(i)));

                    // Kalan öğeleri tekrar bul
                    elements = Driver.get().findElements(By.xpath("//*[@class='input-group btn-block']"));
                } catch (Exception e) {
                    // Herhangi bir hata durumunda, öğeleri tekrar bul
                    elements = Driver.get().findElements(By.xpath("//*[@class='input-group btn-block']"));
                    // İndeksi ayarla
                    i--;
                }
            }
        }

        public boolean isCartEmpty() {
            List<WebElement> elements = Driver.get().findElements(By.xpath("//*[@class='input-group btn-block']"));
            return elements.isEmpty();
        }
    }