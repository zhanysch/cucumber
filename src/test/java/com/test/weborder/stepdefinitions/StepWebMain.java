package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.LoginPage;
import com.test.weborder.pages.OrderMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class StepWebMain {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    OrderMainPage orderMainPage = new OrderMainPage(driver);




    @Given("User Login to page,")
    public void user_login_to_page() {
        loginPage.fillInfo(ConfigReader.readProperty("QA_login"),ConfigReader.readProperty("QA_password"));
    }

    @When("User enter {string} , {string},{string} ,{string},{string},")
    public void user_enter(String nameOfValue, String value, String invite, String firstEmail, String secondEmail) throws InterruptedException {
       orderMainPage.clickButtons();
       orderMainPage.enterData(nameOfValue,value);
       orderMainPage.invitations(invite,firstEmail,secondEmail);

    }
    @Then("User validate {string},")
    public void user_validate(String string) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(orderMainPage.addressConfirmation().contains(string));

    }
    @Then("validate following words {string},{string}")
    public void validate_following_words(String expectedHead, String expectedDescription) throws InterruptedException {
       Assert.assertTrue(orderMainPage.validationPage(expectedHead,expectedDescription));
    }

}
