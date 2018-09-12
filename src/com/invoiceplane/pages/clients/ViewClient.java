package com.invoiceplane.pages.clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by amolpc on 7/15/2018.
 */
public class ViewClient
{
    WebDriver driver;

    @FindBy(xpath="//li[@class='active']/a[text()='Active']")
    WebElement btnActive;

    public  ViewClient(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setBtnActive()
    {
        btnActive.click();
    }

}
