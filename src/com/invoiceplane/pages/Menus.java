package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by amolpc on 8/4/2018.
 */
public class Menus
{
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Clients']")
    WebElement lnkClients;

    @FindBy(xpath = "//a[text()='Add Client']")
    WebElement lnkAddClients;

    @FindBy(xpath = "//a[text()='View Clients']")
    WebElement lnkViewClients;

    @FindBy(xpath = "//span[text()='Quotes']")
    WebElement lnkQuotes;

    @FindBy(xpath = "//a[text()='Create Quote']")
    WebElement lnkCreateQuote;

    @FindBy(xpath = "//a[text()='View Quotes']")
    WebElement lnkViewQuotes;

    @FindBy(xpath = "//span[text()='Invoices']")
    WebElement lnkInvoices;

    @FindBy(xpath = "//a[text()='Create Invoice']")
    WebElement lnkCreateInvoice;

    @FindBy(xpath = "//a[text()='View Invoices']")
    WebElement lnkViewInvoices;

    @FindBy(xpath = "//a[text()='View Recurring Invoices']")
    WebElement lnkViewRecurringInvoices;

    @FindBy(xpath = "//span[text()='Products']")
    WebElement lnkProducts;

    @FindBy(xpath = "//a[text()='Create product']")
    WebElement lnkCreateproduct;

    @FindBy(xpath = "//a[text()='View products']")
    WebElement lnkViewproducts;

    @FindBy(xpath = "//a[text()='Product families']")
    WebElement lnkProductfamilies;

    @FindBy(xpath = "//span[text()='Payments']")
    WebElement lnkPayments;

    @FindBy(xpath = "//a[text()='Enter Payment']")
    WebElement lnkEnterPayment;

    @FindBy(xpath = "//a[text()='View Payments']")
    WebElement lnkViewPayments;

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement lnkReports;

    @FindBy(xpath = "//a[text()='Invoice Aging']")
    WebElement lnkInvoiceAging;

    @FindBy(xpath = "//a[text()='Payment History']")
    WebElement lnkPaymentHistory;

    @FindBy(xpath = "//a[text()='Sales by Client']")
    WebElement lnkSalesbyClient;

    @FindBy(xpath = "//a[text()='Sales by Date']")
    WebElement lnkSalesbyDate;

    public Menus(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickAddClients()
    {
        lnkClients.click();
        lnkAddClients.click();
    }

    public void clickViewClients()
    {
        lnkClients.click();
        lnkViewClients.click();
    }

    public void clickCreateQuote()
    {
        lnkQuotes.click();
        lnkCreateQuote.click();
    }

    public void clickViewQuotes()
    {
        lnkQuotes.click();
        lnkViewClients.click();
    }

    public void clickCreateInvoice()
    {
        lnkInvoices.click();
        lnkCreateInvoice.click();
    }

    public void clickViewInvoices()
    {
        lnkInvoices.click();
        lnkViewInvoices.click();
    }

    public void clickViewRecurringInvoices()
    {
        lnkInvoices.click();
        lnkViewRecurringInvoices.click();
    }

    public void clickCreateproduct()
    {
        lnkProducts.click();
        lnkCreateproduct.click();
    }

    public void clickViewproduct()
    {
        lnkProducts.click();
        lnkViewproducts.click();
    }

    public void clickProductfamilies()
    {
        lnkProducts.click();
        lnkProductfamilies.click();
    }

    public void clickEnterPayment()
    {
        lnkPayments.click();
        lnkEnterPayment.click();
    }

    public void clickViewPayments()
    {
        lnkPayments.click();
        lnkViewPayments.click();
    }

    public void clickInvoiceAging()
    {
        lnkReports.click();
        lnkInvoiceAging.click();
    }

    public void clickPaymentHistory()
    {
        lnkReports.click();
        lnkPaymentHistory.click();
    }

    public void clickSalesbyClient()
    {
        lnkReports.click();
        lnkSalesbyClient.click();
    }

    public void clickSalesbyDate()
    {
        lnkReports.click();
        lnkSalesbyDate.click();
    }
}

