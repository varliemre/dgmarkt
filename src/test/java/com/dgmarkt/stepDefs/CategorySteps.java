package com.dgmarkt.stepDefs;


import com.dgmarkt.pages.CategoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CategorySteps {

        WebDriver driver;
        CategoryPage categoryPage;

        @Given("user is on the DGMarkt homepage")
        public void user_is_on_the_dgmarkt_homepage() {
            driver = new ChromeDriver();
            driver.get("https://dgmarkt.com/");
            categoryPage = new CategoryPage(driver);
        }

        @When("The user navigates to the {string} category")
        public void the_user_navigates_to_the_category(String category) {
            categoryPage.navigateToCategory(category);
        }

        @When("The user selects the {string} sub-category")
        public void the_user_selects_the_sub_category(String subCategory) {
            categoryPage.selectSubCategory(subCategory);
        }
        //
        @Then("The user should see the Sub-Category page")
        public void the_user_should_see_the_sub_category_page() {

            String subCategory = "Networking";
            boolean isDisplayed = categoryPage.isSubCategoryPageDisplayed(subCategory);
            Assert.assertTrue("Sub-category page is not displayed!", isDisplayed);
            driver.quit();
        }

        //
        @When("The user navigates through the following tabs:")
        public void the_user_navigates_through_the_following_tabs(List<String> tabs) {
            for (String tab : tabs) {
                categoryPage.navigateThroughTabs(tab);
            }
        }

        @Then("Each tab should display the correct content")
        public void each_tab_should_display_the_correct_content(List<String> tabs) {
            for (String tab : tabs) {
                boolean isContentDisplayed = categoryPage.isTabContentDisplayed(tab);
                Assert.assertTrue("Content for tab " + tab + " is not displayed!", isContentDisplayed);
            }
            driver.quit();
        }

        @When("The user clicks on the following buttons:")
        public void the_user_clicks_on_the_following_buttons(List<String> buttons) {
            for (String button : buttons) {
                categoryPage.clickButton(button);
            }
        }

        @Then("Each button should navigate to the correct page")
        public void each_button_should_navigate_to_the_correct_page(List<String> buttons) {
            for (String button : buttons) {
                boolean isNavigationCorrect = categoryPage.isButtonNavigationCorrect(button);
                Assert.assertTrue("Navigation for button " + button + " is not correct!", isNavigationCorrect);
            }
            driver.quit();
        }
    }


