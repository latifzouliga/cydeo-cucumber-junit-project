package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.pages.WebTableOrderPage;
import com.cydeo.pages.WebTableViewAllOrdersPage;
import com.cydeo.utilities.BrowserUtil;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.JSUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class WebTableOrder_stepDefinitions {


    WebTableLoginPage loginPage = new WebTableLoginPage();
    WebTableOrderPage orderPage = new WebTableOrderPage();

    @Given("user is already logged in to The Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {

        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        loginPage.login();
    }

    @When("user is on the Order page")
    public void user_is_on_the_order_page() {
        orderPage.btn_order.click();
    }

    @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> orderOptions) {
        List<String> list = BrowserUtil.dropdownOptions_as_STRING(orderPage.btn_productDropdown);

        Assert.assertEquals(orderOptions, list);
    }


    @Then("user sees Visa radio button is enabled")
    public void user_sees_visa_radio_button_is_enabled() {
        orderPage.btn_visa.click();
        Assert.assertTrue(orderPage.btn_visa.isEnabled());
    }


    @Then("user sees Mastercard radio button is enabled")
    public void user_sees_mastercard_radio_button_is_enabled() {
        orderPage.btn_MasterCard.click();
        Assert.assertTrue(orderPage.btn_MasterCard.isEnabled());
    }


    @Then("user sees American Express radio button is enabled")
    public void user_sees_american_express_radio_button_is_enabled() {
        orderPage.btn_AmericanExpress.click();
        Assert.assertTrue(orderPage.btn_AmericanExpress.isEnabled());
    }

    @Then("user enters appropriate test data")
    public void user_enters_appropriate_test_data(Map<String, String> orderInfo) {
        Select select = new Select(orderPage.btn_productDropdown);
        select.selectByVisibleText("Familybea");

        orderPage.txt_quantity.sendKeys(orderInfo.get("Quantity"));
        orderPage.txt_CustomerName.sendKeys(orderInfo.get("Customer name"));
        orderPage.txt_streetAddress.sendKeys(orderInfo.get("Street"));
        orderPage.txt_city.sendKeys(orderInfo.get("City"));
        orderPage.txt_state.sendKeys(orderInfo.get("State"));
        orderPage.txt_zipcode.sendKeys(orderInfo.get("Zip"));
        BrowserUtil.clickRadioButton(orderPage.cardTypes, orderInfo.get("Card type"));
        BrowserUtil.sleep(1);
        orderPage.txt_cardNumber.sendKeys(orderInfo.get("Card No"));
        orderPage.txt_expiryDate.sendKeys(orderInfo.get("Expire date"));


    }


    @Then("user clicks to Process Order")
    public void user_clicks_to_process_order() {
        orderPage.btn_processOrder.click();
    }


    WebTableViewAllOrdersPage viewAllOrdersPage = new WebTableViewAllOrdersPage();

    @Then("user should see {string} in the table on View all orders")
    public void user_should_see_new_order_in_the_table_on_view_all_orders(String name) {

        JSUtils.drawBorder(viewAllOrdersPage.customerCell);
        String actualName = viewAllOrdersPage.customerCell.getText();
        Assert.assertEquals(actualName, name);
    }


    @When("user is on the Order page And user enters quantity {string}")
    public void user_is_on_the_order_page_and_user_enters_quantity(String string) {
        orderPage.btn_order.click();
        orderPage.txt_quantity.sendKeys(string);
    }

    @Then("user clicks to the calculate button And user enters customer name {string}")
    public void user_clicks_to_the_calculate_button_and_user_enters_customer_name(String string) {
        orderPage.btn_calculate.click();
        orderPage.txt_CustomerName.sendKeys(string);
    }

    @Then("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.txt_streetAddress.sendKeys(string);
    }

    @Then("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.txt_city.sendKeys(string);
    }

    @Then("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.txt_state.sendKeys(string);
    }

    @Then("user enters zip {string}")
    public void user_enters_zip(String string) {
        orderPage.txt_zipcode.sendKeys(string);
    }

    @Then("user selects payment option {string}")
    public void user_selects_payment_option(String string) {
        BrowserUtil.clickRadioButton(orderPage.cardTypes, string);
    }

    @Then("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.txt_cardNumber.sendKeys(string);
    }

    @Then("user enters expiration date {string}")
    public void user_enters_expiration_date(String string) {
        orderPage.txt_expiryDate.sendKeys(string);

    }

    @Then("user clicks to process order button")
    public void user_clicks_to_process_order_button() {
        //JSUtils.flashElement(orderPage.btn_processOrder);
        orderPage.btn_processOrder.click();
    }

    @Then("user should see {string} in the first row of the web table I")
    public void user_should_see_in_the_first_row_of_the_web_table_i(String string) {
        Assert.assertEquals(string, viewAllOrdersPage.customerCell.getText());
    }


    // delete an order from the table

    @When("user select an {string} from the table")
    public void user_select_an_order_from_the_table(String order) {
        viewAllOrdersPage.selectAnOrder(order);
    }

    @Then("user click delete selected button")
    public void user_click_delete_selected_button() {
        BrowserUtil.sleep(2);
        viewAllOrdersPage.btn_deleteSelected.click();
    }

    @Then("user should see the order disappear from the table")
    public void user_should_see_the_order_disappear_from_the_table() {
        String customerName = viewAllOrdersPage.customerCell.getText();

        Assert.assertFalse("If the customer name is still in table it means that the order is not deleted",
                customerName.contains("Bob Martin")
        );

        BrowserUtil.sleep(2);

    }

    @When("user select all orders from the table")
    public void user_select_all_orders_from_the_table() {
        viewAllOrdersPage.btn_selectAll.click();
    }
    @Then("user should see an empty table")
    public void user_should_see_an_empty_table() {
        try {
            Assert.assertFalse(viewAllOrdersPage.customerCell.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
            System.out.println("The table row are being deleted from the web page");
            System.out.println("if you see this message in console, it means that this case is passed");
            // do nothing
        }
    }



}
