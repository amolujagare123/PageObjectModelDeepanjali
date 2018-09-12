package Regression;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utilities.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by amolpc on 7/15/2018.
 */
public class LoginTest
{
    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent;

    @Test
    public void logintest()
    {
        extent = new ExtentReports("Report/report.html",true, NetworkMode.OFFLINE);
        ExtentTest test = extent.startTest("logintest","Login into Invoice billing");

        ResourceBundle rb= ResourceBundle.getBundle("InvoicePlane");
        String urlStr=rb.getString("url");
        driver.get(urlStr);
        test.log(LogStatus.INFO,"Login into Invoice billing");

        Login login=new Login(driver);

        login.setTxtEmail("amolujagare@gmail.com");
        test.log(LogStatus.INFO,"Email is entered");
        login.setTxtPassword("admin123");
        test.log(LogStatus.INFO,"Password is entered");
        login.clickLogin();
        test.log(LogStatus.INFO,"Login button is clicked and home page is viewed");

        extent.endTest(test);
        extent.flush();
    }
}
