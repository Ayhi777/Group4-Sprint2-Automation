package com.cydeo.trycloud.pages;

import com.cydeo.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuBasePage {

    public TopMenuBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div[@class='logo logo-icon']")
    public WebElement tryCloudLogo;

    @FindBy (xpath = "//a[@href='/index.php/apps/dashboard/']")
    public WebElement dashboardIcon;

    @FindBy (xpath = "(//a[@aria-label='Files'])[1]")
    public WebElement filesIcon;

    @FindBy (xpath = "(//a[@aria-label='Photos'])[1]")
    public WebElement photosIcon;

    @FindBy (xpath = "(//a[@aria-label='Activity'])[1]")
    public WebElement activityIcon;

    @FindBy (xpath = "(//a[@aria-label='Talk'])[1]")
    public WebElement talkIcon;

    @FindBy (xpath = "(//a[@aria-label='Mail'])[1]")
    public WebElement mailIcon;

    @FindBy (xpath = "(//a[@aria-label='Contacts'])[1]")
    public WebElement contactsIcon;

    @FindBy (xpath = "(//a[@aria-label='Circles'])[1]")
    public WebElement circlesIcon;

    @FindBy (xpath = "(//a[@aria-label='Deck'])[1]")
    public WebElement deckIcon;

    @FindBy (xpath = "(//a[@aria-label='Calendar'])[1]")
    public WebElement calendarIcon;

    @FindBy (xpath = "(//a[@aria-label='More apps'])[1]")
    public WebElement moreThreeDot;

    @FindBy (xpath = "//div[@class='header-menu unified-search']")
    public WebElement searchIcon;

    @FindBy (xpath = "//div[@class='icon-contacts menutoggle']")
    public WebElement searchContactIcon;

    @FindBy (xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement avatarIcon;










}
