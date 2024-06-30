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
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CategoryPage extends BasePage{

    @FindBy(xpath = "//span[text()='Category']")
    public WebElement categoryButton;

    @FindBy(xpath = "(//a[text()='Health & Beauty'])[1]")
    public WebElement healthAndBeautyButton;


    @FindBy(xpath = "(//a[text()='Televisions'])[1]")
    public WebElement televisionsButton;


    @FindBy(xpath = "(//a[text()='TV Accessories'])[1]")
    public WebElement tvAccessoriesButton;

    @FindBy(xpath = "(//a[text()='Networking'])[1]")
    public WebElement networkingButton;

    @FindBy(xpath = "//h1[text()='Health & Beauty']")
    public WebElement healthAndBeautyPage;

    @FindBy(xpath = "//h1[text()='Televisions']")
    public WebElement televisionsPage;

    @FindBy(xpath = "//h1[text()='TV Accessories']")
    public WebElement tvAccessoriesPage;
  
    @FindBy(xpath = "//div[@class='caption']")
    public List<WebElement> productCaptions;
    
    @FindBy(xpath = "//h1[text()='Networking']")
    public WebElement networkingPage;




    public void navigateToPageOrClickAButton(String text) {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("//*[text()='" + text + "']")));

    }


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



