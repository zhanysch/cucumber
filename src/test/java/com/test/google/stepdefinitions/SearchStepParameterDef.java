package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepParameterDef {

    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);

    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String website) {
       driver.get(website);
    }
    @When("User searches for {string}")
    public void user_searches_for(String searchItem) throws InterruptedException {
        Thread.sleep(3000);
       googleMainPage.searcItem(searchItem);
    }
    @Then("User validates first page returns more than {int} links")
    public void user_validates_first_page_returns_more_than_links(Integer expectedLink) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(googleMainPage.linkCount(expectedLink));
    }

    @When("User searches for special {string}")
    public void user_searches_for_special(String searchFood) throws InterruptedException {
        Thread.sleep(3000);
        googleMainPage.searcItem(searchFood);
    }
    @Then("User validates the result is less than three {int}")
    public void user_validates_the_result_is_less_than_three(Integer summ) {
        Assert.assertTrue(googleMainPage.resultsFromSearch(summ));
    }

    @When("USer Search for {string}")
    public void u_ser_search_for(String turkishFood) {
        googleMainPage.searcItem(turkishFood);
    }
    @Then("User validate it loads less than {double}")
    public void user_validate_it_loads_less_than(Double sum) {
        Assert.assertTrue(googleMainPage.resultsFromSearchBaklava(sum));
    }

}
