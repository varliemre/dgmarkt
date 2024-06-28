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

import com.dgmarkt.pages.CategoryPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import com.dgmarkt.pages.HomePage;
import com.dgmarkt.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;


public class CategorySteps {

    WebDriver driver;
    CategoryPage categoryPage;

    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://dgmarkt.com/");
        categoryPage = new CategoryPage(driver);
    }

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



public class CategorySteps {
    HomePage homePage = new HomePage();
    CategoryPage subCategoryPage = new CategoryPage();

    @When("The user moves to Category button")
    public void theUserMovesToCategoryButton() throws InterruptedException {
        homePage.dontShowAgain.click();
        homePage.closePopupButton.click();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(subCategoryPage.categoryButton).perform();
        Thread.sleep(3000);

    }

    @When("The user can see the sub categories")
    public void theUserCanSeeTheSubCategories() {
        Assert.assertEquals(subCategoryPage.healthAndBeautyButton.getText(), "HEALTH & BEAUTY");
        Assert.assertEquals(subCategoryPage.televisionsButton.getText(), "TELEVISIONS");
        Assert.assertEquals(subCategoryPage.tvAccessoriesButton.getText(), "TV ACCESSORIES");
        Assert.assertEquals(subCategoryPage.networkingButton.getText(), "NETWORKING");
    }


//    @Given("The user is on the home page")
//    public void the_user_is_on_the_home_page() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        driver = new ChromeDriver();
//        driver.get("https://dgmarkt.com/");
//        categoryPage = new CategoryPage(driver);
//    }

    @When("The user clicks on the 'Health & Beauty' sub-button")
    public void theUserClicksOnTheHealthBeautySubButton() {
        subCategoryPage.healthAndBeautyButton.click();
    }


    @Then("The user is on the Health & Beauty page")
    public void theUserIsOnTheHealthBeautyPage() {
        Assert.assertEquals(subCategoryPage.healthAndBeautyPage.getText(), "Health & Beauty");
    }

    @When("The user clicks on the 'Televisions' sub-button")
    public void theUserClicksOnTheTelevisionsSubButton() {
        subCategoryPage.televisionsButton.click();
    }

    @Then("The user is on the Televisions page")
    public void theUserIsOnTheTelevisionsPage() {
        Assert.assertEquals(subCategoryPage.televisionsPage.getText(), "Televisions");
    }

    @When("The user clicks on the 'TV Accessories' sub-button")
    public void theUserClicksOnTheTVAccessoriesSubButton() {
        subCategoryPage.tvAccessoriesButton.click();
    }

    @Then("The user is on the TV Accessories page")
    public void theUserIsOnTheTVAccessoriesPage() {
        Assert.assertEquals(subCategoryPage.tvAccessoriesPage.getText(), "TV Accessories");
    }

    @When("The user clicks on the 'Networking' sub-button")
    public void theUserClicksOnTheNetworkingSubButton() {
        subCategoryPage.networkingButton.click();
    }

    @Then("The user is on the Networking page")
    public void theUserIsOnTheNetworkingPage() {
        Assert.assertEquals(subCategoryPage.networkingPage.getText(), "Networking");

    }

}

