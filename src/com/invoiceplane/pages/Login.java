package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by amolpc on 7/15/2018.
 */
public class Login
{
    WebDriver driver;

    @FindBy (name="email")
    public WebElement txtEmail;

    @FindBy (name="password")
    public WebElement txtPassword;

    @FindBy (xpath = "//*[@type='submit']") //(xpath="//button[@type='submit']")//localhost submit button code //@FindBy(name="btn_login") //online login attribute
    public WebElement btnLogin;

    @FindBy(partialLinkText = "I forgot my password")
    public WebElement lnkForgotPwd;

    @FindBy(xpath="//label[text()='Email']")
    public WebElement lblEmail;

    @FindBy(xpath="//label[text()='Password']")
    public WebElement lblPassword;

    public Login(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this); //initialise elements
    }

    public void setTxtEmail(String username)
    {
        txtEmail.sendKeys(username);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }

    public void clickLinkForgotPwd()
    {
        lnkForgotPwd.click();
    }
}
