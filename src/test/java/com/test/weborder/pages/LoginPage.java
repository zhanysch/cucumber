package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {

    public  LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "#Email")
    WebElement loginId;

    @FindBy(css = "#Password")
    WebElement passwordId;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement button;

    @FindBy(css = ".alert-danger")
    WebElement errorMessage;

    public void fillInfo(String login, String password){
        loginId.clear();
        loginId.sendKeys(login);
        passwordId.clear();
        passwordId.sendKeys(password);
        button.submit();
    }

    public void fillInfoNegative(String login, String password){
        loginId.clear();
        loginId.sendKeys(login);
        passwordId.clear();
        passwordId.sendKeys(password);
        button.submit();

    }

   /* public void validErrorText(String error) {
        BrowserUtils.getText(errorMessage);
    }*/
    public String errorMEssage(){
        return BrowserUtils.getText(errorMessage);
    }
}
