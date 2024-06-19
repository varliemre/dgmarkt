package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage {
    JavascriptExecutor jse;
    JavascriptExecutor executor = (JavascriptExecutor) Driver.get();


    @FindBy(id = "cart")
    public WebElement cart_l;
    @FindBy(xpath = "//li[.='Shopping Cart']")
    public WebElement shoppingCart_l;


    @FindBy(css = "[class='fa fa-shopping-cart']")
    public WebElement viewCart_l;

    @FindBy(xpath = "//div[@id='content']//table[@class='table table-bordered']//tbody//td[@class='text-left'][1]")
    public List<String> product_list_l;

    public void click_cart_Ikon() {

        executor.executeScript("arguments[0].click();", cart_l);
        BrowserUtils.waitForClickablility(cart_l, 2);
        executor.executeScript("arguments[0].click();", viewCart_l);


    }

    public void produkt_list_in_Checkout(int  amount ,int  quantityy) {


        List<WebElement> elements = Driver.get().findElements(By.xpath("//*[@class='input-group btn-block']"));
        BrowserUtils.waitFor(20);

        System.out.println("productList.size() = " + elements.size());
        int amout_product_in_Cart=elements.size();
        System.out.println("amout_product_in_Cart = " + amout_product_in_Cart);
        Assert.assertEquals(amount, amout_product_in_Cart);

        //sepetteki ürün ürün adedi


        List<WebElement> productQuantities = Driver.get().findElements(By.xpath("//input[contains(@name, 'quantity')]"));

        int totalQuantity = 0;

        for (WebElement quantityInput : productQuantities) {
            String quantityValue = quantityInput.getAttribute("value");

            if (quantityValue != null && !quantityValue.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityValue);
                    totalQuantity += quantity;
                } catch (NumberFormatException e) {
                    System.out.println("Hata: Adet değeri geçerli bir tam sayıya dönüştürülemedi: " + quantityValue);
                }
            } else {
                System.out.println("Hata: Adet değeri boş veya null.");
            }
        }

        System.out.println("Sepetteki toplam ürün adeti: " + totalQuantity);
        Assert.assertEquals(quantityy,totalQuantity);

    }

}
