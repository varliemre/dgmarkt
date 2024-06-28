package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {

@FindBy(xpath = "//h2[text()='My Wish List']")
    public WebElement wishListText;

public void wishListTextVerify(){
    String actualText="My Wish List";
    Assert.assertEquals(wishListText.getText(),actualText);
}

//------------------

    @FindBy(xpath = "//button[@data-original-title='Add to Cart']")
    public List<WebElement> addToCartButtons;

    public void addProductFromWishListToCart(String productThatWillBeAdded) {
        int timer = 0;
        for (WebElement w : wishListElements) {
            if (w.getText().equals(productThatWillBeAdded)) {
                break;
            }
            timer++;
        }
        BrowserUtils.waitFor(2);
        addToCartButtons.get(timer).click();
        BrowserUtils.waitFor(2);
    }
    @FindBy(xpath = "//div[@class='alert alert-fix alert-success alert-dismissible']")
    public WebElement successMessage;

    public void addingProductToCartValidateSuccessMessages(String expectedSuccessMessage) {
        expectedSuccessMessage = "Success: You have added " + expectedSuccessMessage + " to your shopping cart!\n×";
        String actualSuccessMessage = successMessage.getText();
        System.out.println(actualSuccessMessage);
        System.out.println(expectedSuccessMessage);
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }

    public void addingProductToWishListValidateSuccessMessages(String expectedSuccessMessage) {
        expectedSuccessMessage = "Success: You have added " + expectedSuccessMessage;
        String actualSuccessMessage = successMessage.getText();
        System.out.println(actualSuccessMessage);
        System.out.println(expectedSuccessMessage);
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
        BrowserUtils.waitFor(3);
    }

    @FindBy(xpath = "//a[@data-original-title='Remove']")
    public List<WebElement> removeButtons;


    public void removeElementFromWishList(String productThatWillBeRemoved) {
        int timer = 0;
        for (WebElement w : wishListElements) {
            if (w.getText().equals(productThatWillBeRemoved)) {
                break;
            }
            timer++;
        }
        BrowserUtils.waitFor(2);
        removeButtons.get(timer).click();
        BrowserUtils.waitFor(2);
    }

    public void validateThatTheItemIsNoMoreInWishList(String expectedElement) {
        try {
            Assert.assertFalse(Driver.get().findElement(By.xpath("//td[@class='text-left']//a[text()='" + expectedElement + "']")).isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(true);
        }

        //Alternative Solution
        Assert.assertEquals(0, Driver.get().findElements(By.xpath("//td[@class='text-left']//a[text()='" + expectedElement + "']")).size());
    }


@FindBy(xpath = "//td[@class='text-left']//a")
public List<WebElement> wishListElements;

    public void productInTheWishListValidation(String expectedProductName) {
        boolean flag = false;
        for (WebElement w : wishListElements) {
            System.out.println(w.getText());
            if (w.getText().contains(expectedProductName)) {
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }




    public void canNotAddToCart() {
        // Sayfadaki tüm ürün satırlarını locate et
        List<WebElement> productRows = Driver.get().findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));

        for (WebElement productRow : productRows) {
            // Ürün adını ve teslimat süresini bul
            String productName = productRow.findElement(By.xpath(".//td[2]")).getText();
            String deliveryTime = productRow.findElement(By.xpath(".//td[contains(text(), 'Days')]")).getText();

            // Eğer teslimat süresi "2-3 Days" ise, sepete ekleme
            if (deliveryTime.contains("2-3 Days")) {
                System.out.println("Item " + productName + " has a delivery time of " + deliveryTime + ". Skipping add to cart.");
            } else {
                WebElement addToCartButton = productRow.findElement(By.xpath(".//button[contains(@class, 'add-to-cart')]"));
                addToCartButton.click();
                System.out.println("Item " + productName + " added to cart.");
            }
        }
    }




}
