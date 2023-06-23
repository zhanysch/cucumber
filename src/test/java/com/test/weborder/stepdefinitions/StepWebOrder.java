package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.DriverHelper;

public class StepWebOrder {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @When("User searches for  fields {string}, {string},")
    public void user_searches_for_fields(String string, String string2) {
        loginPage.fillInfo(string,string2);
    }
    @Then("User validates title of the {string}")
    public void user_validates_title_of_the(String string) {
        Assert.assertEquals(string,driver.getTitle());
    }

    @When("User searches for  fields inCorrectPassword {string}, {string},")
    public void user_searches_for_fields_in_correct_password(String string, String string2) {
        loginPage.fillInfoNegative(string,string2);
    }
    @Then("User validates for error {string}")
    public void user_validates_for_error(String expectedMeesage) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(expectedMeesage,loginPage.errorMEssage());
    }

    @When("User searches for  fields inCorrectLogin {string}, {string},")
    public void user_searches_for_fields_in_correct_login(String string, String string2) {
        loginPage.fillInfoNegative(string,string2);
    }
    @Then("User validates for password error {string}")
    public void user_validates_for_password_error(String string) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(string,loginPage.errorMEssage());
    }

}
