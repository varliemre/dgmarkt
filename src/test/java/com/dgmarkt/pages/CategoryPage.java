package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage extends BasePage{

    WebDriver driver;

//    public CategoryPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    @FindBy(xpath = "//*[@id=\"pt-menu-4885\"]/ul/li[2]/a/span")
    WebElement categoryTab;

    @FindBy(xpath = "//*[@id=\"pt-menu-4885\"]/ul/li[2]/div")
    WebElement subCategoryTab;

    public void hoverOnCategoryTab() {
        Actions actions = new Actions(driver);
        actions.moveToElement(categoryTab).perform();
    }

    public void hoverOnSubCategoryTab() {
        Actions actions = new Actions(driver);
        actions.moveToElement(subCategoryTab).perform();
    }
    public void clickOnSubCategoryTab() {
        subCategoryTab.click();
    }

    //---------------

    public void navigateToPageOrClickAButton(String text) {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("//*[text()='" + text + "']")));

    }


    @FindBy(xpath = "//div[@class='caption']")
    public List<WebElement> productCaptions;

    public void addProductToWishList(String productNames) {
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
        Driver.get().findElement(By.xpath("(//*[@class='button-wishlist'])[" + (timer + 1) + "]")).click();
        BrowserUtils.waitFor(2);
    }




}

