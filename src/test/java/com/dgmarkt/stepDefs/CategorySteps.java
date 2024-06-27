package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class CategorySteps {

    WebDriver driver;
    CategoryPage categoryPage;

//    @Given("The user is on the home page")
//    public void the_user_is_on_the_home_page() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        driver = new ChromeDriver();
//        driver.get("https://dgmarkt.com/");
//        categoryPage = new CategoryPage(driver);
//    }

    @When("The user hovers over the Category tab")
    public void the_user_hovers_over_the_category_tab() {
        categoryPage.hoverOnCategoryTab();
    }

    @When("The user hovers over the Sub-Category tab")
    public void the_user_hovers_over_the_sub_category_tab() {
        categoryPage.hoverOnSubCategoryTab();
    }

    @When("The user clicks on a Sub-Category tab")
    public void the_user_clicks_on_a_sub_category_tab() {
        categoryPage.clickOnSubCategoryTab();
    }

    @Then("The Sub-Category Page should be displayed")
    public void the_sub_category_page_should_be_displayed() {
        String expectedElementXPath = "//*[@id=\"pt-menu-4885\"]/ul/li[2]/div";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement expectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expectedElementXPath)));
        Assert.assertTrue(expectedElement.isDisplayed());
        driver.quit();
    }

    @And("The user clicks on the {string} Sub-Category tab")
    public void theUserClicksOnTheSubCategoryTab(String arg0) {

    }
    }

