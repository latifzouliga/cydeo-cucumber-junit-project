package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleSearch_stepDefinitions {

    GoogleSearchPage searchPage = new GoogleSearchPage();


    @Given("user on google search page")
    public void user_on_google_search_page() {
       Driver.getDriver().get("https://www.google.com");
    }
    @When("user enter {word} in google search box")
    public void user_enter_apple_in_search_box(String string) {
        searchPage.txt_searchBox.sendKeys(string, Keys.ENTER);
    }
    @Then("usr see title {word} - Google Search")
    public void usr_see_title_apple_google_search(String string) {
       Assert.assertEquals(string+" - Google Search", Driver.getDriver().getTitle());
    }

}
