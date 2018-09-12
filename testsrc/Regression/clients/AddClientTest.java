package Regression.clients;

import com.invoiceplane.pages.Login;
import com.invoiceplane.pages.Menus;
import com.invoiceplane.pages.clients.AddClient;
import com.invoiceplane.utilities.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ResourceBundle;

import static com.invoiceplane.utilities.TakeScreenshot.takeScreenshot;

/**
 * Created by amolpc on 7/15/2018.
 */
public class AddClientTest
{
    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent;
    public static int  count;

    @BeforeClass
    public void logintest()
    {
        extent = new ExtentReports("Report/report.html",true, NetworkMode.OFFLINE);

        ResourceBundle rb= ResourceBundle.getBundle("InvoicePlane");
        String urlStr=rb.getString("url");
        driver.get(urlStr);

        Login login=new Login(driver);

        login.setTxtEmail("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();
    }

   /* @Test
    public void addClientTest()
    {
        Menus mnu=new Menus(driver);
        mnu.clickAddClients();

        AddClient ac= new AddClient(driver);
        ac.setClientName("DA Pvt Ltd");
        ac.setStreetAddr("Katraj");
        ac.setCity("Pune");
        ac.setState("Maharashtra");
        ac.setZipCode("12455");
        ac.setCountry("India");
        ac.setPhone("012-1255");
        ac.setMobile("1326459870");
        ac.setEmail("da@gmail.com");
        ac.setWeb("www.da.com");
        ac.setVatID("v453789");
        ac.setTaxCd("gst012");
        ac.clickSave();
    } */


    @Test(dataProvider="getData")
    public void addClienTest(String clientname,String streetaddr,String city,String state,String zipcode,
                             String country,String phone, String mobile,String email,String web,
                             String vatid,String taxcd,String expected_result,
                             String xpath_of_actual_result) throws IOException {

        ExtentTest test = extent.startTest("Test"+(count++)+" Add Client Test: "+clientname,
                "To test the funtionality of Save button for the input: "+clientname);

        Menus mnu=new Menus(driver);
        mnu.clickAddClients();
        test.log(LogStatus.INFO,"Menu add client is selected");

        AddClient ac= new AddClient(driver);
        ac.setClientName(clientname);
        test.log(LogStatus.INFO,"Client name entered");
        ac.setStreetAddr(streetaddr);
        test.log(LogStatus.INFO,"Street address entered");
        ac.setCity(city);
        test.log(LogStatus.INFO,"City entered");
        ac.setState(state);
        test.log(LogStatus.INFO,"State entered");
        ac.setZipCode(zipcode);
        test.log(LogStatus.INFO,"Zip Code entered");
        ac.setCountry(country);
        test.log(LogStatus.INFO,"Country entered");
        ac.setPhone(phone);
        test.log(LogStatus.INFO,"Phone entered");
        ac.setMobile(mobile);
        test.log(LogStatus.INFO,"Mobile entered");
        ac.setEmail(email);
        test.log(LogStatus.INFO,"Email entered");
        ac.setWeb(web);
        test.log(LogStatus.INFO,"Web entered");
        ac.setVatID(vatid);
        test.log(LogStatus.INFO,"VAT ID entered");
        ac.setTaxCd(taxcd);
        test.log(LogStatus.INFO,"Tax Code entered");
        ac.clickSave();
        test.log(LogStatus.INFO,"Record is saved. Client is added");

        String actual="";
        try
        {
             actual=driver.findElement(By.xpath(xpath_of_actual_result)).getText();

        }
        catch(Exception e)
        {
            actual="";

        }
        try
        {
            Assert.assertEquals(actual, expected_result, "Actuals is not matching with expected");
            test.log(LogStatus.INFO,"Test is PASSED");
            test.log(LogStatus.INFO,"Screenshot below ;"+test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));
        }
        catch(AssertionError e)
        {
            test.log(LogStatus.FAIL,e);
            test.log(LogStatus.INFO,"Screenshot below ;"+test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));
        }
        extent.endTest(test);

    }

    @DataProvider
    public Object[][] getData() throws IOException
    {
        //Rows - Number of times your test has to be repeated.
        //Columns - Number of parameters in test data.
        FileInputStream fileInputStream = new FileInputStream("Data3/AddClientDataProvider.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream); // converts excel into workbook
        HSSFSheet worksheet = workbook.getSheet("Sheet1"); //in workbook  refer sheet

        int rowCount= worksheet.getPhysicalNumberOfRows(); // counting actual no.of rows in sheet

        Object[][] data = new Object[rowCount-1][14];

        for(int i=1;i<rowCount;i++)
        {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell clientname = row.getCell(0);
            if (clientname == null)
                data[i-1][0] = "";
            else {
                clientname.setCellType(CellType.STRING);
                data[i-1][0] = clientname.getStringCellValue();
            }
            HSSFCell streetaddr = row.getCell(1);
            if (streetaddr == null)
                data[i-1][1] = "";
            else {
                streetaddr.setCellType(CellType.STRING);
                data[i-1][1] = streetaddr.getStringCellValue();
            }

            HSSFCell city = row.getCell(2);
            if (city == null)
                data[i-1][2] = "";
            else
            {
                city.setCellType(CellType.STRING);
                data[i-1][2] = city.getStringCellValue();
            }
            HSSFCell state = row.getCell(3);
            if (state == null)
                data[i-1][3] = "";
            else
            {
                state.setCellType(CellType.STRING);
                data[i-1][3] = state.getStringCellValue();
            }
            HSSFCell zipcode = row.getCell(4);
            if (zipcode == null)
                data[i-1][4] = "";
            else
            {
                zipcode.setCellType(CellType.STRING);
                data[i-1][4] = zipcode.getStringCellValue();
            }
            HSSFCell country = row.getCell(5);
            if (country == null)
                data[i-1][5] = "";
            else
            {
                country.setCellType(CellType.STRING);
                data[i-1][5] = country.getStringCellValue();
            }
            HSSFCell phone = row.getCell(6);
            if (phone == null)
                data[i-1][6] = "";
            else
            {
                phone.setCellType(CellType.STRING);
                data[i-1][6] = phone.getStringCellValue();
            }
            HSSFCell mobile = row.getCell(7);
            if (mobile == null)
                data[i-1][7] = "";
            else
            {
                mobile.setCellType(CellType.STRING);
                data[i-1][7] = mobile.getStringCellValue();
            }
            HSSFCell email = row.getCell(8);
            if (email == null)
                data[i-1][8] = "";
            else
            {
                email.setCellType(CellType.STRING);
                data[i-1][8] = email.getStringCellValue();
            }
            HSSFCell web = row.getCell(9);
            if (web == null)
                data[i-1][9] = "";
            else
            {
                web.setCellType(CellType.STRING);
                data[i-1][9] = web.getStringCellValue();
            }
            HSSFCell vatid = row.getCell(10);
            if (vatid == null)
                data[i-1][10] = "";
            else
            {
                vatid.setCellType(CellType.STRING);
                data[i-1][10] = vatid.getStringCellValue();
            }
            HSSFCell taxcd = row.getCell(11);
            if (taxcd == null)
                data[i-1][11] = "";
            else
            {
                taxcd.setCellType(CellType.STRING);
                data[i-1][11] = taxcd.getStringCellValue();
            }
            HSSFCell expected_result = row.getCell(12);
            if (expected_result == null)
                data[i-1][12] = "";
            else
            {
                expected_result.setCellType(CellType.STRING);
                data[i-1][12] = expected_result.getStringCellValue();
            }
            HSSFCell xpath_of_actual_result = row.getCell(13);
            if (xpath_of_actual_result == null)
                data[i-1][13] = "";
            else
            {
                xpath_of_actual_result.setCellType(CellType.STRING);
                data[i-1][13] = xpath_of_actual_result.getStringCellValue();
            }
        }
        return data;
    }

    @AfterClass
    public void CloseTest()
    {
        extent.flush();
        driver.close();
    }
}
