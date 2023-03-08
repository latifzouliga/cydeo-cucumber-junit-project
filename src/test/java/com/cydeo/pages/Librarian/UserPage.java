package com.cydeo.pages.Librarian;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://library2.cydeo.com/#users
public class UserPage extends Librarian_BasePage {
    @FindBy(xpath = "//a[@href='#users']")
    public WebElement users;

    @FindBy(css = "a[class*='btn-outline']")
    public WebElement linkAjax;

    @FindBy(name = "full_name")
    public WebElement inputFullName;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(name = "email")
    public WebElement inputEmail;

    @FindBy(name = "user_group_id")
    public WebElement selectUserGroup;

    @FindBy(name = "address")
    public WebElement textareaAddress;

    //@FindBy(css = "button[class$='btn-primary']")
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonSaveChanges;

    @FindBy(css ="#toast-container > div >div")
    public WebElement actualMessage;

    @FindBy(css = "a[class*='btn-outline']")
    public WebElement addUser;

    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountHolderName;

    @FindBy(css = ".dropdown-item")
    public WebElement logout;
    
  
    
    
    
    
    
    
}