package com.dgmarkt.pages;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class CategoryPage extends BasePage {

        WebDriver driver;

        // Constructor
        public CategoryPage(WebDriver driver) {
            this.driver = driver;
        }

        // Method to navigate to a category
        public void navigateToCategory(String category) {
            WebElement categoryElement = driver.findElement(By.xpath("//a[contains(text(),'" + category + "')]"));
            categoryElement.click();
        }

        // Method to select a sub-category
        public void selectSubCategory(String subCategory) {
            WebElement subCategoryElement = driver.findElement(By.xpath("//a[contains(text(),'" + subCategory + "')]"));
            subCategoryElement.click();
        }

        // Method to verify the sub-category page
        public boolean isSubCategoryPageDisplayed(String subCategory) {
            return driver.findElement(By.xpath("//h1[contains(text(),'" + subCategory + "')]")).isDisplayed();
        }

        // Method to hover over a tab
        public void hoverOverTab(String tabName) {
            Actions actions = new Actions(driver);
            WebElement tabElement = driver.findElement(By.xpath("//a[contains(text(),'" + tabName + "')]"));
            actions.moveToElement(tabElement).perform();
        }

        // Method to verify tab content
        public boolean isTabContentDisplayed(String tabName) {
            return driver.findElement(By.xpath("//h2[contains(text(),'" + tabName + "')]")).isDisplayed();
        }

        // Method to click buttons
        public void clickButton(String buttonName) {
            WebElement buttonElement = driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
            buttonElement.click();
        }

        // Method to verify button navigation
        public boolean isButtonNavigationCorrect(String expectedPage) {
            return driver.findElement(By.xpath("//h1[contains(text(),'" + expectedPage + "')]")).isDisplayed();
        }
    }



