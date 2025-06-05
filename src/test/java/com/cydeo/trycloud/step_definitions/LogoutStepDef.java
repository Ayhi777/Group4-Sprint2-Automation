package com.cydeo.trycloud.step_definitions;

import com.cydeo.trycloud.pages.BasePage;
import com.cydeo.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class LogoutStepDef {

    @Given("the user clicks the avatar icon")
    public void the_user_clicks_the_avatar_icon() {
        new BasePage().avatarIcon.click();
    }

    @Given("the user clicks the logout label")
    public void the_user_clicks_the_logout_label() {
        new BasePage().logOutLink.click();
    }

    @When("the user clicks step back button")
    public void the_user_clicks_step_back_button() {
        Driver.getDriver().navigate().back();
    }

}
