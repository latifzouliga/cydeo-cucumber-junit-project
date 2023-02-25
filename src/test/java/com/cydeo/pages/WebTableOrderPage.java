package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTableOrderPage extends WebTableBasePage{


    @FindBy(name = "product")
    public WebElement btn_productDropdown;

    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement btn_calculate;

    @FindBy(css = "input[value='Visa']")
    public WebElement btn_visa;

    @FindBy(css = "input[value='MasterCard']")
    public WebElement btn_MasterCard;

    @FindBy(css = "input[value='American Express']")
    public WebElement btn_AmericanExpress;

    @FindBy(xpath = "//input[@name='card']")
    public List<WebElement> cardTypes;


    @FindBy(name = "quantity")
    public WebElement txt_quantity;

    @FindBy(name = "name")
    public WebElement txt_CustomerName;

    @FindBy(name = "street")
    public WebElement txt_streetAddress;

    @FindBy(name = "city")
    public WebElement txt_city;

    @FindBy(name = "state")
    public WebElement txt_state;

    @FindBy(name = "zip")
    public WebElement txt_zipcode;

    @FindBy(name = "cardNo")
    public WebElement txt_cardNumber;

    @FindBy(name = "cardExp")
    public WebElement txt_expiryDate;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement btn_processOrder;

    @FindBy(xpath = "//td[.='Mariam']")
    public WebElement orderInTable;





}




















