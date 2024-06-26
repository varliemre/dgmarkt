package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.CheckoutPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;

public class PriceSlider_StepDef {
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();


    @Then("Verify price silder display")
    public void verify_price_silder_display() {
        BrowserUtils.scrollToElement(cartPage.PriceSlider2);
        Assert.assertTrue(cartPage.PriceSlider2.isDisplayed());
    }


    @Then("user can change min  {string} and  and max values {string}")
    public void user_can_change_min_and_and_max_values(String minStr, String maxStr) {
        Select select = new Select(cartPage.show_konteyner);
        select.selectByVisibleText("100");

        int minValue = Integer.parseInt(minStr);
        int maxValue = Integer.parseInt(maxStr);

        // Sayfayı kaydır
        BrowserUtils.waitFor(2);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,300)");

        // Mevcut minimum ve maksimum değerleri alın
        int start = Integer.parseInt(cartPage.MinText.getAttribute("value"));
        int finish = Integer.parseInt(cartPage.MaxText.getAttribute("value"));
        BrowserUtils.waitFor(2);

        // Minimum ve maksimum değerleri ayarlamak için JavaScript kullanın
        jse.executeScript("arguments[0].value = arguments[1];", cartPage.MinText, minValue);
        jse.executeScript("arguments[0].value = arguments[1];", cartPage.MaxText, maxValue);

        // Değişiklikleri doğrulamak için değerleri güncelle
        BrowserUtils.waitFor(2);
        int updatedMinValue = Integer.parseInt(cartPage.MinText.getAttribute("value"));
        int updatedMaxValue = Integer.parseInt(cartPage.MaxText.getAttribute("value"));

        List<WebElement> productList = Driver.get().findElements(By.cssSelector("[class='product-layout product-grid grid-style col-lg-4 col-md-4 col-sm-4 col-xs-6 product-items']"));

        boolean allPricesWithinRange = true;

        // Ürün listesi üzerinde iterasyon yap ve fiyatları kontrol et
        for (WebElement product : productList) {
            try {
                // Ürün fiyatını al
                WebElement priceElement = product.findElement(By.xpath("//p[@class='price']")); // Fiyat elementinin CSS seçicisini buraya ekleyin
                BrowserUtils.waitForClickablility(priceElement, 12);
                String priceText = priceElement.getText().replace("$", ""); // Fiyat metnini alın ve $ işaretini kaldırın (farklı bir para birimi kullanıyorsanız uyarlayın)
                double priceDouble = Double.parseDouble(priceText); // Double olarak parse et
                int price = (int) priceDouble; // Int'e dönüştür
                BrowserUtils.waitFor(12);

                // Fiyatın belirtilen aralıkta olup olmadığını kontrol edin
                if (price < minValue || price > maxValue) {
                    allPricesWithinRange = false;
                    break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Fiyat elemanı bulunamadı: " + e.getMessage());
                allPricesWithinRange = false;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Fiyat dönüştürülemedi: " + e.getMessage());
                allPricesWithinRange = false;
                break;
            }
        }
        BrowserUtils.waitFor(10);
        // Fiyatların belirtilen aralıkta olup olmadığını kontrol edin
        Assert.assertTrue("Bazı fiyatlar belirtilen aralıkta değil", allPricesWithinRange);

        System.out.println("minValue: " + minValue);
        System.out.println("maxValue: " + maxValue);
        System.out.println("updatedMinValue: " + updatedMinValue);
        System.out.println("updatedMaxValue: " + updatedMaxValue);

        BrowserUtils.waitFor(2);
        // Beklenen ve güncellenen değerlerin eşit olduğunu doğrula
        Assert.assertEquals(minValue, updatedMinValue);
        Assert.assertEquals(maxValue, updatedMaxValue);



    }
}
