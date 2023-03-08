package com.cydeo.pages.Librarian;

import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Library_LoginPage extends Librarian_BasePage{

    @FindBy(css = "#inputEmail")
    public WebElement emailBox;

    @FindBy(css = "#inputPassword")
    public WebElement passwordBox;

    @FindBy(css = "button[class='btn btn-lg btn-primary btn-block']")
    public WebElement signInBtn;



    public void login(String user){
        String userEmail = ConfigurationReader.getProperty(user+"_username");
        String userPassword = ConfigurationReader.getProperty(user+"_password");
        emailBox.sendKeys(userEmail);
        passwordBox.sendKeys(userPassword);
        signInBtn.click();
    }

    public void login(String userName, String password){
        emailBox.sendKeys(userName);
        passwordBox.sendKeys(password);
        signInBtn.click();
    }

}