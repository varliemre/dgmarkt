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
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class ComparePage extends BasePage{
    @FindBy(tagName = "h1")
    public WebElement ProductComparisonText;

    @FindBy(id = "compare-total")
    public WebElement productCompareButton;

    @FindBy(xpath = "(//input[@type='button'])[1]")
    public WebElement firstProductsAddtoCartButton;

    @FindBy(xpath = "(//input[@type='button'])[2]")
    public WebElement secondProductsAddtoCartButton;

    @FindBy(xpath = "//*[text()='Remove']")
    public WebElement firstProductsRemoveButton;

    @FindBy(xpath = "//div[@id='content']/p")
    public WebElement noElementText;

    public void hoverOverAndCompareProduct(String productName) {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();


        WebElement product = Driver.get().findElement(By.xpath("//img[contains(@title,'" + productName + "')][contains(@class,'responsive')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", product);

        WebElement compareButton = Driver.get().findElement(By.xpath("//img[contains(@title,'" + productName + "')]/../../../..//span[text()='Compare this Product']/.."));
        jse.executeScript("arguments[0].click();", compareButton);


    }

    @FindBy(xpath = "//table/tbody/tr/td[text()='Capsule Plate 6pcs']")
    public WebElement product1;

    @FindBy(xpath = "//table/thead/tr/td[@colspan='2']")
    public WebElement columnNumber;
    @FindBy(xpath = "//table/thead/tr/td[@colspan='5']")
    public WebElement columnNumber5;




    @FindBy(xpath = "//div[@class='caption']")
    public List<WebElement> productCaptions;

    public void addProductToCompare(String productNames) {
        int timer = 0;
        for (WebElement w : productCaptions) {
            if (w.getText().contains(productNames)) {
                break;
            }
            timer++;
            System.out.println(w.getText());
        }
        System.out.println(timer);
        new Actions(Driver.get()).moveToElement(productCaptions.get(timer)).perform();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("(//*[@class='button-compare'])[" + (timer + 1) + "]")).click();
        BrowserUtils.waitFor(2);
    }

    @FindBy(xpath = "//a[text()='product comparison']")
    public WebElement pop_upProductComparisonButton;

    @FindBy(xpath = "//h1[text()='Product Comparison']")
    public WebElement productText;

    public void verifyProductText(){
        String actualtext="Product Comparison";
        Assert.assertEquals(productText.getText(),actualtext);
    }



    public void comparePageProductVerify(String expectedProduct){

            BrowserUtils.waitFor(2);
            Assert.assertTrue(Driver.get().findElement(By.xpath("//strong[text()='"+expectedProduct+"']")).isDisplayed());

    }


    public void theUserClicksTheRemoveButtonToRemoveProducts() throws InterruptedException {
        BrowserUtils.clickWithJS(firstProductsRemoveButton);
        Thread.sleep(2000);

        WebElement popupForRemove = Driver.get().findElement(By.xpath("//button[@class='close']"));

    }


    public void verifyThereisNoProductAfterRemove(){
        String expectedText ="You have not chosen any products to compare.";
        String actualText = noElementText.getText();

        Assert.assertEquals(expectedText, actualText);
    }


}
