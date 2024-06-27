package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.CategoryPage;
import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.WishListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WishList_StepDefs {
    HomePage homePage=new HomePage();
    WishListPage wishListPage=new WishListPage();
    CategoryPage categoryPage=new CategoryPage();
    CartPage cartPage=new CartPage();

    @When("The user clicks wish list link")
    public void the_user_clicks_wish_list_link() {
        homePage.clcikToWishList();
    }
    @Then("The user verifies that the user should see wish list text")
    public void the_user_verifies_that_the_user_should_seewish_list_text() {
        wishListPage.wishListTextVerify();
    }
    @When("The user clicks wish list icon")
    public void the_user_clicks_wish_list_icon() {
        homePage.clickWishListIcon();
    }




}
