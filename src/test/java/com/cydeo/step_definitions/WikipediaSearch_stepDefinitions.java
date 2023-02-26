package com.cydeo.step_definitions;

import com.cydeo.pages.WikiResultPage;
import com.cydeo.pages.WikipediaSearchPage;
import com.cydeo.utilities.BrowserUtil;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaSearch_stepDefinitions {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    WikipediaSearchPage searchPage = new WikipediaSearchPage();
    WikiResultPage resultPage = new WikiResultPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }

    //Steve Jobs
    @When("User types {string} in the wiki search box.")
    public void user_types_steve_jobs_in_the_wiki_search_box(String string) {
        BrowserUtil.sleep(1);
        searchPage.txt_searchBox.sendKeys(string);
    }

    @Then("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        BrowserUtil.sleep(1);
        searchPage.btn_search.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_steve_jobs_is_in_the_wiki_title(String string) {
        BrowserUtil.sleep(1);
        wait.until(ExpectedConditions.titleContains(string));
        BrowserUtil.verifyTitleContains(string);


    }


    @Then("User sees {string} is in the main header")
    public void user_sees_steve_jobs_is_in_the_main_header(String string) {
        BrowserUtil.sleep(1);
        wait.until(ExpectedConditions.titleContains(string));
        Assert.assertEquals(resultPage.mainHeader.getText(),string);
/*
        Scenario scenario =
        if (scenario.isFailed()){
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].style.value='3px solid red'",resultPage.mainHeader);
        }

 */

    }


    @Then("User sees {string} is in the image header")
    public void user_sees_steve_jobs_is_in_the_image_header(String string) {
        BrowserUtil.sleep(1);
        wait.until(ExpectedConditions.titleContains(string));
        Assert.assertTrue(resultPage.imageHeader.getText().contains(string));
    }


}
