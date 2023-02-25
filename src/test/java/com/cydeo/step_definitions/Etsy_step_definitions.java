package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyHomePage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Etsy_step_definitions {

    EtsyHomePage homePage = new EtsyHomePage();


    @Given("user is on the Etsy homepage")
    public void user_is_on_the_etsy_homepage() {
        Driver.getDriver().get("https://www.etsy.com");
    }
    @Then("user should see title as expected")
    public void user_should_see_title_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());

    }

    // scenario 2

    @When("User types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
         homePage.txt_searchBox.sendKeys("Wooden Spoon");
    }
    @When("User clicks search button")
    public void user_clicks_search_button() {
       homePage.btn_searchBox.click();
    }

    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String searchValue) {
        homePage.txt_searchBox.sendKeys(searchValue);
    }

    @Then("User sees Wooden Spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
        String expectedTitle = "Wooden spoon - Etsy";
       Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

}
