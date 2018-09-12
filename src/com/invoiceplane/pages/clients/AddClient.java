package com.invoiceplane.pages.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by amolpc on 7/15/2018.
 */
public class AddClient
{
    WebDriver driver;

    @FindBy(name="client_name")
    WebElement txtClientName;

    @FindBy(name="client_address_1")
    WebElement txtStreetAddr;

    @FindBy(name="client_city")
    WebElement txtCity;

    @FindBy(name="client_state")
    WebElement txtState;

    @FindBy(name="client_zip")
    WebElement txtZipCode;

    @FindBy(name="client_phone")
    WebElement txtPhoneNum;

    @FindBy(name="client_mobile")
    WebElement txtMobileNum;

    @FindBy(name="client_email")
    WebElement txtEmailAddr;

    @FindBy(name="client_web")
    WebElement txtWebAddr;

    @FindBy(name="client_vat_id")
    WebElement txtVatID;

    @FindBy(name="client_tax_code")
    WebElement txtTaxCode;

    @FindBy(name="btn_submit")
    WebElement btnSave;

    @FindBy(name="btn_cancel")
    WebElement btnCancel;

    @FindBy(id="select2-client_country-container")
    WebElement drpCountry;

    @FindBy(xpath="//input[@class='select2-search__field']")
    WebElement txtCountry;

    public  AddClient(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setClientName(String clientName)
    {
        txtClientName.sendKeys(clientName);
    }

    public void setStreetAddr(String streetAddr)
    {
        txtStreetAddr.sendKeys(streetAddr);
    }

    public void setCity(String cityn)
    {
        txtCity.sendKeys(cityn);
    }

    public void setState(String staten)
    {
        txtState.sendKeys(staten);
    }

    public void setZipCode(String zip)
    {
        txtZipCode.sendKeys(zip);
    }

    public void setPhone(String phone)
    {
        txtPhoneNum.sendKeys(phone);
    }

    public void setMobile(String mobile )
    {
        txtMobileNum .sendKeys(mobile);
    }

    public void setEmail(String email )
    {
        txtEmailAddr .sendKeys(email);
    }

    public void setWeb(String web )
    {
        txtWebAddr.sendKeys(web);
    }

    public void setVatID(String vat )
    {
        txtVatID.sendKeys(vat);
    }

    public void setTaxCd(String taxCd )
    {
        txtTaxCode .sendKeys(taxCd);
    }

    public void clickSave()
    {
        btnSave.click();
    }

    public void clickCancel()
    {
        btnCancel.click();
    }

    public void setCountry(String country)
    {
        drpCountry.click();
        txtCountry.sendKeys(country);

        driver.findElement(By.xpath("//li[text()='"+country+"']")).click();

    }

}
