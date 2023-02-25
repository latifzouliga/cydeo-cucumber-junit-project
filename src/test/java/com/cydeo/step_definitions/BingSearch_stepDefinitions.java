package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtil;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BingSearch_stepDefinitions {

    BingSearchPage searchPage = new BingSearchPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));


    @Given("user on Bing search page")
    public void user_on_bing_search_page() {
        Driver.getDriver().get("https://www.bing.com/");
    }

    @When("user enter {string} in bing search box")
    public void user_enter_orange_in_bing_search_box(String searchValue) {
        searchPage.txt_bingSearchBox.sendKeys(searchValue);
        BrowserUtil.sleep(2);
        searchPage.txt_bingSearchBox.sendKeys(Keys.ENTER);
    }

    @When("user enter kiwi in bing search box")
    public void user_enter_kiwi_in_bing_search_box() {
        searchPage.txt_bingSearchBox.sendKeys("kiwi");
        BrowserUtil.sleep(2);
        searchPage.txt_bingSearchBox.sendKeys(Keys.ENTER);
    }


    @Then("user should see title is {string}")
    public void user_should_see_title_is_orange_search(String expectedTitle) {

        wait.until(ExpectedConditions.titleContains(expectedTitle));
        BrowserUtil.verifyTitleContains(expectedTitle);
    }

}
