package com.dgmarkt.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

@FindBy(xpath = "//h2[text()='My Wish List']")
    public WebElement wishListText;

public void wishListTextVerify(){
    String actualText="My Wish List";
    Assert.assertEquals(wishListText.getText(),actualText);
}
}
