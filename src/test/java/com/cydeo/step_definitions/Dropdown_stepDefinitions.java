package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoDropDownsPage;
import com.cydeo.utilities.BrowserUtil;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class Dropdown_stepDefinitions {

    CydeoDropDownsPage dropDownsPage = new CydeoDropDownsPage();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> months) {


        List<String> list = BrowserUtil.dropdownOptions_as_STRING(dropDownsPage.monthsDropDown);
        Assert.assertEquals(months, list);
        System.out.println(list);


        /*
        int k = 0;
        for (WebElement each : options) {

            System.out.println(each.getText() + " : " + months.get(k));
            //
            Assert.assertEquals(months.get(k), each.getText());
            k++;
        }

         */
    }

}
