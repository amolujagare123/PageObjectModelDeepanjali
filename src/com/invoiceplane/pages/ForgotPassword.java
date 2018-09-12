package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by amolpc on 7/15/2018.
 */
public class ForgotPassword
{
    WebDriver driver;

    @FindBy(id="email")
    WebElement txtEmail;

    @FindBy(name="btn_reset")
    WebElement btnReset;

    public ForgotPassword(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void clickReset()
    {
        btnReset.click();
    }
}
