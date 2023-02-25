package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(name = "username")
    public WebElement txt_usernameBox;

    @FindBy(name = "password")
    public WebElement txt_passwordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement btn_login;

    @FindBy(css = "div[class='login__error'] > p")
    public WebElement loginError_message;



    public void login(){
        txt_usernameBox.sendKeys("Test");
        txt_passwordBox.sendKeys("Tester");
        btn_login.click();
    }

    /**
     *
     * @param username
     * @param password
     */
    public void login(String username, String password){
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        txt_usernameBox.sendKeys(username);
        txt_passwordBox.sendKeys(password);
        btn_login.click();
    }




}
