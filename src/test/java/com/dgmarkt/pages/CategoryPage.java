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

public class CategoryPage extends BasePage{

        WebDriver driver;


        public CategoryPage(WebDriver driver) {
            this.driver = driver;
        }

        // Method to navigate to a category
        public void navigateToCategory(String category) {
            WebElement categoryElement = driver.findElement(By.xpath("//*[@id=\"pt-menu-2057\"]/ul/li[2]/a/span"));
            categoryElement.click();
        }

        // Method to select a sub-category
        public void selectSubCategory(String subCategory) {
            WebElement subCategoryElement = driver.findElement(By.xpath("//*[@id=\"pt-menu-5247\"]/ul/li[2]/div/div/div[2]/h4/a"));
            subCategoryElement.click();
        }

        // Method to verify the sub-category page
        public boolean isSubCategoryPageDisplayed(String subCategory) {
            return driver.findElement(By.xpath("<h1>")).getText().contains(subCategory);
        }

        // Method to navigate through tabs
        public void navigateThroughTabs(String tabName) {
            WebElement tabElement = driver.findElement(By.xpath("//a[contains(text(),'\" + tabName + \"')"));
            tabElement.click();
        }

        // Method to verify tab content
        public boolean isTabContentDisplayed(String tabName) {
            return driver.findElement(By.xpath("")).getText().contains(tabName);
        }

        // Method to click buttons
        public void clickButton(String buttonName) {
            WebElement buttonElement = driver.findElement(By.xpath("//button[contains(text(),'\" + buttonName + \"')]"));
            buttonElement.click();
        }

        // Method to verify button navigation
        public boolean isButtonNavigationCorrect(String expectedPage) {
            return driver.findElement(By.xpath("//h1[contains(text(),'")).getText().contains(expectedPage);
        }
    }

