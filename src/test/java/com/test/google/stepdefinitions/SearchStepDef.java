package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepDef {

    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);
    @Given("User navigates to the google")
    public void user_navigates_to_the_google() {
      driver.get("https://www.google.com/");
    }
    @When("User searches for CodeFish")
    public void user_searches_for_code_fish() {
        googleMainPage.searcItem("CodeFish");
    }
    @Then("User validates first page returns more than ten links")
    public void user_validates_first_page_returns_more_than_ten_links() throws InterruptedException {

        Thread.sleep(3000);
     Assert.assertTrue( googleMainPage.linkCount(10));
    }

    @When("User searches for Kyrgyz Food in USA")
    public void user_searches_for_kyrgyz_food_in_usa() {
        googleMainPage.searcItem("Kyrgyz Food in USA");
    }
    @Then("User validates the result is less than three hundred million")
    public void user_validates_the_result_is_less_than_three_hundred_million() throws InterruptedException {
        Thread.sleep(3000);
      Assert.assertTrue(googleMainPage.resultsFromSearch(300000000));
    }

    @When("USer Search for Turkish baklava")
    public void u_ser_search_for_turkish_baklava() {
      googleMainPage.searcItem("Turkish baklava");
    }

    @Then("User validate it loads less than one sec")
    public void user_validate_it_loads_less_than_one_sec() {
        Assert.assertTrue(googleMainPage.resultsFromSearchBaklava(1));
    }



}
