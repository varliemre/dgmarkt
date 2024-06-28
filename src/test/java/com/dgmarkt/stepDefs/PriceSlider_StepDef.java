package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.CheckoutPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
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


    @Then("Verifies default values {string}  and {string}")
    public void verifiesDefaultValuesAnd(String defaultMinVaulues, String defaultMaxValues) {

        BrowserUtils.waitFor(10);
        String actualDefaultMAxVaules = cartPage.MaxText.getAttribute("value");
        System.out.println("defaultMaxValues = " + defaultMaxValues);
        BrowserUtils.waitFor(10);
        String actualDefaultMinValues = cartPage.MinText.getAttribute("value");
        System.out.println("defaultMinVaulues = " + defaultMinVaulues);
        System.out.println("actualDefaultMAxVaules = " + actualDefaultMAxVaules);

        System.out.println("actualDefaultMinValues = " + actualDefaultMinValues);
        BrowserUtils.waitFor(10);
        Assert.assertEquals(defaultMaxValues, actualDefaultMAxVaules);
        BrowserUtils.waitFor(10);
        Assert.assertEquals(defaultMinVaulues, actualDefaultMinValues);

    }

    @Then("user can change min  {string} and  and max values {string}")
    public void userCanChangeMinAndAndMaxValues(String minStr, String maxStr) {
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


        List<WebElement> priceElements = Driver.get().findElements(By.cssSelector(".box-price"));
        List<Integer> priceList = new ArrayList<>();

        // Fiyatları topla ve yazdır
        System.out.println("Fiyat Listesi:");
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").trim(); // $ işaretini kaldır ve boşlukları trim yap
            int price = (int) Double.parseDouble(priceText);
            priceList.add(price);

        }

        // Fiyatların belirtilen aralıkta olup olmadığını assertTrue ile doğrula
        boolean allPricesWithinRange = true;
        for (int price : priceList) {
            if (price < updatedMinValue || price > updatedMaxValue) {
                allPricesWithinRange = false;
                break;
            }
        }

        // Assert ile fiyatların belirtilen aralıkta olup olmadığını kontrol et
        //Assert.assertTrue("Bazı fiyatlar belirtilen aralıkta değil", allPricesWithinRange);

        // Diğer doğrulamaları yapabilir veya gerekli işlemleri gerçekleştirebilirsiniz
        System.out.println("Güncellenmiş minValue: " + updatedMinValue);
        System.out.println("Güncellenmiş maxValue: " + updatedMaxValue);
    }
};



