package com.cydeo.trycloud.pages;

import com.cydeo.trycloud.utilities.BrowserUtils;
import com.cydeo.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class BasePage {

    @FindBy(xpath = "//html[@class='ng-csp']")
    public WebElement loginPage;

    @FindBy(xpath = "//div[@class='logo']")
    public WebElement loginLabel;

    @FindBy(xpath = "//input[@id='user']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement userPassword;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@id='lost-password']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//a[contains(text(), 'Log in with a device')]")
    public WebElement loginWithADevice;

    @FindBy(xpath = "//a[@class='entity-name']")
    public WebElement trycloudHomePage;
    public HTMLInputElement logOutLink;
    public HTMLInputElement avatarIcon;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getUserName() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }

    public String getUserPassword() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userPassword);
        BrowserUtils.waitForVisibility(userPassword, 5);
        return userPassword.getText();
    }
}
