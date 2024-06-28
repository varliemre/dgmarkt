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

    public void select_product(String productNAme) {
        Select select = new Select(show_konteyner);
        select.selectByVisibleText("100");
        //BrowserUtils.waitFor(25);

        WebElement selectproduct = Driver.get().findElement(By.xpath("//a[.='" + productNAme + "']"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", selectproduct);

        //BrowserUtils.waitForClickablility(selectproduct, 20);
        // BrowserUtils.clickWithJS(selectproduct);
        try {
            BrowserUtils.clickWithJS(selectproduct);
        } catch (Exception e) {
            e.printStackTrace();


        }

    }

    public void add_to_cart() {
        WebElement add_to_cart_l = Driver.get().findElement(By.xpath("//*[.='Add to Cart']"));

        BrowserUtils.waitForClickablility(add_to_cart_l, 45);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView(true);", add_to_cart_l);


        try {
            BrowserUtils.clickWithJS(add_to_cart_l);
            BrowserUtils.waitForClickablility(add_to_cart_l, 20);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void removeAllItemsFromCart() {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//*[@class='input-group btn-block']"));

        // Tüm öğeler kaldırılıncaya kadar döngüyü çalıştır
        while (!elements.isEmpty()) {
            // Listenin ilk öğesini al ve "Remove" düğmesini bul
            WebElement element = elements.get(0);
            WebElement removeButton = element.findElement(By.cssSelector("[data-original-title='Remove']"));

            // "Remove" düğmesine tıkla
            removeButton.click();

            // Öğenin sayfanın dışına çıkması bekleniyor
            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.stalenessOf(element));

            // Kalan öğeleri tekrar bul
            elements = Driver.get().findElements(By.xpath("//*[@class='input-group btn-block']"));
        }
    }

    public boolean isCartEmpty() {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//*[@class='input-group btn-block']"));
        return elements.isEmpty();
    }



    ////////////////////////////////////////////////////////für Price Silider


    @FindBy(xpath = "//div[@id='slider-price']")
    public WebElement PriceSlider2;

    @FindBy(xpath = "//input[@placeholder='Min']")
    public WebElement MinText;

    @FindBy(xpath = "//input[@placeholder='Max']")
    public WebElement MaxText;

    @FindBy(xpath = "(//div[@id='slider-price']//span)[1]")
    public WebElement PriceSliderMin;

    @FindBy(xpath = "(//div[@id='slider-price']//span)[2]")
    public WebElement PriceSliderMax;

    @FindBy(css = "[class='product-layout product-grid grid-style col-lg-4 col-md-4 col-sm-4 col-xs-6 product-items']")
    public WebElement ProductList;

}