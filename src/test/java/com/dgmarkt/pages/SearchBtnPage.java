package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBtnPage extends BasePage{
    @FindBy(xpath = "//*[text()='shopping cart']")
    public WebElement shoppingCartLink;


    @FindBy(xpath = "//*[text()=' Success: You have added ']")
    public WebElement successfullyAddedMessage;
    @FindBy(xpath = "//*[@name='search']")
    public WebElement searchArea;

    @FindBy(xpath = "(//*[text()='Search - TV'])[2]")
    public WebElement searchTV;

    @FindBy(xpath = "(//a[contains(text(),'TV')])[2]")
    public WebElement productTV;

    @FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
    public WebElement productNotFoundMsg;
    @FindBy(id = "search-by-category")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@id='btn-search-category']")
    public WebElement searchButton2;

}
