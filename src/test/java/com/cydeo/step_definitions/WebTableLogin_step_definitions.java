package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebTableLogin_step_definitions {

    WebTableLoginPage loginPage = new WebTableLoginPage();

    @Given("user on login page")
    public void user_on_login_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }

    @When("user enter valid username")
    public void user_enter_username() {
        loginPage.txt_usernameBox.sendKeys("Test");
    }

    @When("user enter valid password")
    public void user_enter_password() {
        loginPage.txt_passwordBox.sendKeys("Tester");
    }

    @When("user click login button")
    public void user_click_login_button() {
        loginPage.btn_login.click();
    }

    @Then("user see url ends with order")
    public void user_see_url_ends_with_order() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith("orders"));
    }


    @When("user enter valid credential")
    public void user_enter_valid_credential(Map<String,String> credentials) {
        loginPage.txt_usernameBox.sendKeys(credentials.get("username"));
        loginPage.txt_passwordBox.sendKeys(credentials.get("password"));
    }


    @When("user enter valid username {word}")
    public void user_enter_username(String username) {
        loginPage.txt_usernameBox.sendKeys(username);
    }

    @When("user enter valid password {word}")
    public void user_enter_password(String password) {
        loginPage.txt_passwordBox.sendKeys(password);
    }


    @When("user enter invalid credentials {string} {string}")
    public void user_enter_invalid_credentials(String username, String password) {
        loginPage.txt_usernameBox.sendKeys((username.equals("empty")) ? "" : username);
        loginPage.txt_passwordBox.sendKeys((password.equals("empty")) ? "" : password);
        loginPage.btn_login.click();

    }

    @Then("user see error message")
    public void user_see_error_message() {
        Assert.assertEquals("Cydeo Web Table App",Driver.getDriver().getTitle());
        String expectedErrorMessage = "Incorrect Username or Password, please double check the provided credentials.";
        Assert.assertEquals(expectedErrorMessage, loginPage.loginError_message.getText());
    }


}
