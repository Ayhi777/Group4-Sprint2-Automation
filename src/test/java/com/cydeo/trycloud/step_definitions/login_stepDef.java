package com.cydeo.trycloud.step_definitions;

import com.cydeo.trycloud.pages.LoginPage;
import com.cydeo.trycloud.utilities.ConfigurationReader;
import com.cydeo.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login_stepDef {

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        Driver.getDriver().get("http://qa2.trycloud.net/");

    }
    @Given("the user is logged in with {string}")
    public void the_user_is_logged_in_with(String submitType) throws InterruptedException {

        LoginPage loginPage=new LoginPage();

        String username= ConfigurationReader.getProperty("username");
        String password= ConfigurationReader.getProperty("password");

        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password);

        if(submitType.equalsIgnoreCase("submitButton")){
            loginPage.loginButton.click();
        } else if (submitType.equalsIgnoreCase("enterKey")) {
            loginPage.password.sendKeys(Keys.ENTER);
        }else{
            System.out.println("Invalid submit type");
        }


    }
    @Then("the user should see the url contains {string}")
    public void the_user_should_see_the_url_contains(String string) {

    }
    @Then("the user should see the username as {string}")
    public void the_user_should_see_the_username_as(String string) {

    }
}
