package com.cydeo.trycloud.step_definitions;

import com.cydeo.trycloud.pages.LoginPage;
import com.cydeo.trycloud.pages.TalkModulePage;
import com.cydeo.trycloud.pages.TopMenuBasePage;
import com.cydeo.trycloud.utilities.BrowserUtils;
import com.cydeo.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;

import java.util.List;
import java.util.NoSuchElementException;

public class TalkModule_StepDefinitions {

    TopMenuBasePage topMenuBasePage = new TopMenuBasePage();
    TalkModulePage talkModulePage = new TalkModulePage();
    Actions actions = new Actions(Driver.getDriver());


    @Then("User clicks on Talk module from the top menu")
    public void user_clicks_on_talk_module_from_the_top_menu() {

    actions.moveToElement(topMenuBasePage.talkIcon);
    topMenuBasePage.talkIcon.click();


    }

    // @CreatingGroup


    @When("user click on create a new group conversation button")
    public void user_click_on_create_a_new_group_conversation_button() {

        talkModulePage.createGroupButton.click();

    }

    @When("create a conversation name as {string}")
    public void create_a_conversation_name(String conversationName) {

    talkModulePage.conversationNameTextBox.sendKeys(conversationName);
    talkModulePage.allowViaLinkCheckBox.click();
    talkModulePage.addParticipantsButton.click();

    }


    @Then("user should add some users as {string}, {string}, {string} from the pop-up window")
    public void userShouldAddSomeUsersAsFromThePopUpWindow(String arg0, String arg1, String arg2) {

        talkModulePage.employeeName(arg0);
        talkModulePage.employeeName(arg1);
        talkModulePage.employeeName(arg2);

        BrowserUtils.sleep(4);

        talkModulePage.createConversationButton.click();
        BrowserUtils.sleep(4);
        talkModulePage.closeConversationButton.click();

    }


    @Then("user can see created conversation as {string} in the list")
    public void userCanSeeCreatedConversationAsInTheList(String groupName) {


     Assert.assertTrue("THE NEW CONVERSATION WASN'T CREATED",talkModulePage.conversationName(groupName).isDisplayed());

    }

    // @AddingUser

    @When("user selects any existing conversation in the list")
    public void user_selects_any_existing_conversation_in_the_list() {
        talkModulePage.existingGroup.click();
        BrowserUtils.sleep(2);


    }

    @And("user types any user's name into the participants search box {string}")
    public void userTypesAnyUserSNameIntoTheParticipantsSearchBox(String username) {
        talkModulePage.addingParticipantsTextBox.sendKeys(username);
        BrowserUtils.sleep(2);

    }

    @Then("the user should be able to select the new participant with its {string}")
    public void theUserShouldBeAbleToSelectTheNewParticipantWithIts(String username) {
        talkModulePage.selectedParticipant(username).click();
        BrowserUtils.sleep(2);

    }



    @Then("user should see the new participant's {string} on the participants list")
    public void userShouldSeeTheNewParticipantSOnTheParticipantsList(String username) {

       Assert.assertTrue(talkModulePage.selectedParticipant(username).isDisplayed());

    }

    // @CallFeature

    @And("user should be able to start a call by clicking on start a call button")
    public void userShouldBeAbleToStartACallByClickingOnStartACallButton() {

        talkModulePage.startCallButton.click();
        BrowserUtils.sleep(3);

    }


    @Then("user should be able to end a call by clicking on leave call button")
    public void userShouldBeAbleToEndACallByClickingOnLeaveCallButton() {

        if (talkModulePage.unnecessaryNotification.isDisplayed()) {
            talkModulePage.unnecessaryNotification.click();
            BrowserUtils.sleep(2);
        }

        talkModulePage.leaveCallButton.click();
        BrowserUtils.sleep(2);

    }

    @Then("user should come back to the chat page")
    public void userShouldComeBackToTheChatPage() {

        Assert.assertTrue("USER IS NOT ABLE TO COME BACK TO THE CONVERSATION PAGE!",Driver.getDriver().getCurrentUrl().contains("call"));
        BrowserUtils.sleep(2);

    }


    @When("user clicks the three dot icon of the created conversation as {string}")
    public void user_clicks_the_three_dot_icon_of_the_created_conversation_as(String string) {
        talkModulePage.chatThreeDotsButton.click();
        BrowserUtils.sleep(2);

    }
    @Then("user should be able to see and click delete conversation button")
    public void user_should_be_able_to_see_and_click_delete_conversation_button() {

        talkModulePage.deleteConversationButton.click();
        BrowserUtils.sleep(2);
        talkModulePage.confirmationButton.click();
        BrowserUtils.sleep(2);

    }
    @Then("user should not see the deleted conversation {string} in the conversation list")
    public void user_should_not_see_the_deleted_conversation_in_the_conversation_list(String groupName) {

        Assert.assertTrue("CONVERSATION IS NOT DELETED", talkModulePage.deletedConversation(groupName).isEmpty());

        BrowserUtils.sleep(2);

    }


}
