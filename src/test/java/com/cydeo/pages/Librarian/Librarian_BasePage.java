package com.cydeo.pages.Librarian;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Librarian_BasePage {
    // parent of other POM in the project/application
    // most of the time we can make this page abstract, we dont want to create object of this class

    public Librarian_BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // navigate to different tabs in the main page
    public void navigateTo(String page) {
        WebElement linkToPage = Driver.getDriver().findElement(By.xpath("//span[.='" + page + "']"));
        linkToPage.click();
    }


}