package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableViewAllOrdersPage {

    public WebTableViewAllOrdersPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement customerCell;

    @FindBy(xpath = "//button[.='Select All']")
    public WebElement btn_selectAll;

    @FindBy(xpath = "//button[.='Deselect All']")
    public WebElement btn_deselectAll;

    @FindBy(css = ".button.__delete")
    public WebElement btn_deleteSelected;

    public void selectAnOrder(String customerName){
        String element = "//td[.='"+customerName+"']/..//button";
        Driver.getDriver().findElement(By.xpath(element)).click();
    }

}
