package com.cydeo.step_definitions;

import com.cydeo.pages.Librarian.Library_LoginPage;
import com.cydeo.pages.Librarian.UserPage;
import com.cydeo.utilities.BrowserUtil;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Librarian_StepDefs {

    Library_LoginPage loginPage = new Library_LoginPage();
    UserPage userPage = new UserPage();


    @Given("the {string} on the home page")
    public void the_on_the_home_page(String user) {
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryUrl"));
        loginPage.login(user);
    }
    @Given("the librarian navigates to {string} page")
    public void the_librarian_navigates_to_page(String users) {
        loginPage.navigateTo(users);
    }
    @When("the librarian clicks to Add User")
    public void the_librarian_clicks_to_add_user() {
         userPage.addUser.click();
    }
    @When("the librarian enters fullname {string}")
    public void the_librarian_enters_fullname(String fullName) {
         userPage.inputFullName.sendKeys(fullName);
    }
    @When("the librarian enters password {string}")
    public void the_librarian_enters_password(String password) {
        userPage.inputPassword.sendKeys(password);
    }
    @When("the librarian enters email {string}")
    public void the_librarian_enters_email(String email) {
         userPage.inputEmail.sendKeys(email);
    }
    @When("the librarian clicks to save changes")
    public void the_librarian_clicks_to_save_changes() {
        userPage.buttonSaveChanges.click();
    }
    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String expectedMessage) {
        Assert.assertEquals( expectedMessage,userPage.actualMessage.getText() );
        Assert.assertTrue(userPage.actualMessage.isDisplayed());
    }
    @Then("verify created user with {string} and {string} able to login")
    public void verify_created_user_with_and_able_to_login(String userName, String password) {
        BrowserUtil.waifForVisibilityOfElement(userPage.actualMessage);
        userPage.accountHolderName.click();
        userPage.logout.click();
        BrowserUtil.sleep(4);
        loginPage.login(userName, password);

    }
    @Then("verify created user should be able to see {string}")
    public void verify_created_user_should_be_able_to_see(String expectedName) {

        BrowserUtil.sleep(2);
        String actualName = userPage.accountHolderName.getText();
        Assert.assertEquals(expectedName,actualName);

    }
}
