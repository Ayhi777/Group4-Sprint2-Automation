package com.cydeo.trycloud.pages;

import com.cydeo.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkModulePage {

    public TalkModulePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div/button[@aria-label='Create a new group conversation']")
    public WebElement createGroupButton;

    @FindBy (xpath = "//input[@placeholder='Conversation name']")
    public WebElement conversationNameTextBox;

    @FindBy (xpath = "//label[@for='checkbox']")
    public WebElement allowViaLinkCheckBox;

    @FindBy (xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement addParticipantsButton;



    public static void employeeName (String participantName){
       WebElement employee = Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='" + participantName + "']"));
       employee.click();
    }


    @FindBy (xpath = "//button[normalize-space(text())='Create conversation']")
    public WebElement createConversationButton;


    @FindBy (xpath = "//button[normalize-space(text())='Close']")
    public WebElement closeConversationButton;


    public static WebElement conversationName (String conversationName){
        WebElement groupName = Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='" + conversationName + "']"));
        return groupName;

    }

    @FindBy (xpath ="(//div[@class='acli__content'])[2]")
    public WebElement existingGroup;

    @FindBy (xpath ="//input[@placeholder='Add participants to the conversation']")
    public WebElement addingParticipantsTextBox;

    public static WebElement selectedParticipant (String usernameOfEmployee){

        WebElement selectedUser = Driver.getDriver().findElement(By.xpath("//span[.='" + usernameOfEmployee + "']"));

        return selectedUser;
    }

    @FindBy (xpath ="//button[normalize-space(text())='Start call']")
    public WebElement startCallButton;

    @FindBy (xpath ="//button[normalize-space(text())='Leave call']")
    public WebElement leaveCallButton;

    //span[@class='toast-close'][1]

    @FindBy (xpath = "//span[@class='toast-close'][1]")
    public WebElement unnecessaryNotification;

    @FindBy (xpath = "(//button[@aria-label='Conversation settings'])[1]")
    public WebElement chatThreeDotsButton;


    @FindBy (xpath = "//button/span[.='Delete conversation']")
    public WebElement deleteConversationButton;

    @FindBy (xpath = "//button[.='Yes']")
    public WebElement confirmationButton;


    public static List<WebElement> deletedConversation(String deletedConversation) {
        return Driver.getDriver().findElements(
                By.xpath("//span[normalize-space(text())='" + deletedConversation + "']")
        );
    }



}
