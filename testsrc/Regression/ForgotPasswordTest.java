package Regression;

import com.invoiceplane.pages.ForgotPassword;
import com.invoiceplane.pages.Login;
import com.invoiceplane.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by amolpc on 7/15/2018.
 */
public class ForgotPasswordTest
{
    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);

    @Test
    public void forgotpwd()
    {
        ResourceBundle rb=ResourceBundle.getBundle("InvoicePlane");
        String urlStr=rb.getString("url");
        driver.get(urlStr);

        Login login1=new Login(driver);
        login1.clickLinkForgotPwd();
        /*since element is present on login page
        so obj is created of login class*/

        ForgotPassword fp=new ForgotPassword(driver);
        fp.setEmail("someusername@gmail.com");
        fp.clickReset();

    }
}
