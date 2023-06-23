package com.test.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class OrderMainPage {

    public OrderMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement groupBox;

    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;

    @FindBy(css = "#ConfirmAddressID")
    WebElement pickUPAddress;

    @FindBy(css = "#addressPreview")
    WebElement confirmAddress;

    @FindBy(css = "#InviteNote")
    WebElement inviteInput;

    @FindBy(css = "#InviteList")
    WebElement emails;

    @FindBy(css = "#createGroupOrder")
    WebElement button;

    @FindBy(xpath = "//h1")
    WebElement header;


    @FindBy(xpath = "//p[contains(text(),'Your group order is now pending')]")
    WebElement description;

    public void clickButtons() throws InterruptedException {
        groupBox.click();
        Thread.sleep(3000);
        nextButton.click();
    }
    public void enterData(String nameOfValue, String value) {
        BrowserUtils.selectByMethod(pickUPAddress, nameOfValue, value);
    }

    public String addressConfirmation() {
        return BrowserUtils.getText(confirmAddress);
    }
    public void invitations(String invite, String firstEmail, String secondEmail) {
        inviteInput.sendKeys(invite);
        emails.sendKeys(firstEmail, ",", secondEmail);
    }
    public boolean validationPage(String expectedHead, String expectedDescription) throws InterruptedException {
        button.click();
        Thread.sleep(3000);
        List<String> actualAll = Arrays.asList(BrowserUtils.getText(header), BrowserUtils.getText(description));
        return actualAll.get(0).contains(expectedHead) && actualAll.get(1).contains(expectedDescription);
    }
}
