package com.dgmarkt.pages;

import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    @FindBy(xpath = "//span[text()='Category']")
    public WebElement categoryNav;

    @FindBy(css = ".cbk_newsletter")
    public WebElement dontShowAgain;
    public Actions closePopupButton;



    public void navigateToCategory(String categoryName) {
        //hovering over to category navigator
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(categoryNav).perform();

        //clicking to the category
        Driver.get().findElement(By.xpath("//a[text()='" + categoryName + "']")).click();
    }
}
