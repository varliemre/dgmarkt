package com.dgmarkt.stepDefs;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.pages.SearchBtnPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SearchFunctionStepDefs {
    LoginPanel loginPanel = new LoginPanel();
    SearchBtnPage searchbtn= new SearchBtnPage();



    @Given("The user clicks to {string}")
    public void the_user_clicks_to(String searchButton) {
        searchbtn.searchButton.click();

    }

    @Then("The user clicks the {string}")
    public void theUserClicksThe(String searchArea) {
        searchbtn.searchArea.click();

    }

    @Then("The user should write {string} at searching area and click {string}")
    public void theUserShouldWriteAtSearchingAreaAndClick(String TV, String searchButton2) throws InterruptedException {

        searchbtn.searchArea.sendKeys("TV");
        Thread.sleep(500);
        searchbtn.searchButton2.click();
    }



    @And("Verify that {string} screen is displayed")
    public void verifyThatScreenIsDisplayed(String searchTV) {

        Assert.assertEquals(searchbtn.searchTV.getText(), "Search - TV");
    }


    @And("Verify that displayed {string} contains TV")
    public void verifyThatDisplayedContainsTV(String productTV) {
        BrowserUtils.scrollToElement(searchbtn.productTV);

        Assert.assertTrue(searchbtn.productTV.isDisplayed());
    }
    @Then("The user can write {string} at searching area and click {string}")
    public void theUserCanWriteAtSearchingAreaAndClick(String searchKey, String searchButton2) throws InterruptedException {
        searchbtn.searchArea.sendKeys(searchKey);
        Thread.sleep(500);
        searchbtn.searchButton2.click();

        }


    @And("Verify that {string} message is displayed")
    public void verifyThatMessageIsDisplayed(String productNotFoundMsg) throws InterruptedException {

        BrowserUtils.scrollToElement(searchbtn.productNotFoundMsg);
        Assert.assertTrue(searchbtn.productNotFoundMsg.isDisplayed());

    }



}
