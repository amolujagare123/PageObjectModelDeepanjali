package Regression.clients;

import com.invoiceplane.pages.Login;
import com.invoiceplane.pages.Menus;
import com.invoiceplane.pages.clients.ViewClient;
import com.invoiceplane.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by amolpc on 7/15/2018.
 */
public class ViewClientTest
{
    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);

    @BeforeClass
    public void loginTest()
    {
        ResourceBundle rb= ResourceBundle.getBundle("InvoicePlane");
        String urlStr=rb.getString("url");
        driver.get(urlStr);

        Login login=new Login(driver);

        login.setTxtEmail("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();
    }

    @Test
    public void viewClientTest()
    {
        Menus mnu=new Menus(driver);
        mnu.clickViewClients();

        ViewClient vc= new ViewClient(driver);
        vc.setBtnActive();

    }

   /* @AfterClass
    public void closeViewClientTest()
    {
        driver.quit();
    }*/
}
