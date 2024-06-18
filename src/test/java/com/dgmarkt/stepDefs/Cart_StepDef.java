package com.dgmarkt.stepDefs;

import com.dgmarkt.pages.CartPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Cart_StepDef {
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();
    LoginPanel loginPanel = new LoginPanel();

    @Given("The user logged in with valid credentials {string} and {string} and is on the home page")
    public void the_user_is_on_the_home_page(String email, String password) {
        loginPanel.loginPanel();
        loginPage.navigateMyAccount("Login");
        BrowserUtils.waitForClickablility(loginPage.loginEmail, 2);
        BrowserUtils.waitForClickablility(loginPage.loginPassword, 2);
        loginPage.login(email, password);
        loginPage.loginBtn.click();


    }

    @When("The user selects a {string}")
    public void the_user_selects_a(String categoryName) {

        cartPage.select_Category(categoryName);
    }



}