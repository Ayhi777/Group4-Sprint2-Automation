package com.cydeo.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    @FindBy(xpath = "//html[@class='ng-csp']")
    public WebElement loginPage;

    @FindBy(xpath = "//div[@class='logo']")
    public WebElement loginLogo;

    @FindBy(xpath = "//input[@id='user']")
    public WebElement userName;



}
