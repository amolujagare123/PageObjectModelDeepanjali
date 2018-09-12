package UI_Testing;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by amolpc on 19/08/2018.
 */
public class LoginTest
{
    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);

    @BeforeClass
    public void start()
    {
        ResourceBundle rb= ResourceBundle.getBundle("InvoicePlane");
        String urlStr=rb.getString("url");
        driver.get(urlStr);
    }

    @Test
    public void txtUserVisibilty()
    {
        Login login=new Login(driver);
        boolean expected=true;
        boolean actual=false;
        try
        {
             actual = login.txtEmail.isDisplayed();
        }
        catch(Exception e)
        {
            actual=false;
        }
        Assert.assertEquals(actual,expected,"Email textbox is missing Login page");
        System.out.println("Email txtbox is displayed");
    }

    @Test
    public void txtUserEnables()
    {
        Login login=new Login(driver);
        boolean expected=true;
        boolean actual=false;
        try
        {
            actual = login.txtEmail.isEnabled();
        }
        catch(Exception e)
        {
            actual=false;
        }
        Assert.assertEquals(actual,expected,"Email textbox is not enabled for Login page");
        System.out.println("Email txtbox is enabled");
    }

    @Test
    public void txtUserVisibilty1()
    {
        Login login=new Login(driver);
        boolean expected=true;
        boolean actual=false;
        try
        {
            actual = login.txtPassword.isDisplayed();
        }
        catch(Exception e)
        {
            actual=false;
        }
        Assert.assertEquals(actual,expected,"Password textbox is missing on Login page");
        System.out.println("password txtbox displayed");
    }

    @Test
    public void txtUserEnables1()
    {
        Login login=new Login(driver);
        boolean expected=true;
        boolean actual=false;
        try
        {
            actual = login.txtPassword.isEnabled();
        }
        catch(Exception e)
        {
            actual=false;
        }
        Assert.assertEquals(actual,expected,"Pwd textbox is not enabled for Login page");
        System.out.println("Pwd txtbox is enabled");
    }

    @Test
    public void btnLoginVisibilty()
    {
        Login login=new Login(driver);
        boolean expected=true;
        boolean actual=false;
        try
        {
            actual = login.btnLogin.isDisplayed();
        }
        catch(Exception e)
        {
            actual=false;
        }
        Assert.assertEquals(actual,expected,"Login button is missing on Login page");
        System.out.println("Login button is displayed");
    }

    @Test
    public void btnLoginEnables()
    {
        Login login=new Login(driver);
        boolean expected=true;
        boolean actual=false;
        try
        {
            actual = login.btnLogin.isEnabled();
        }
        catch(Exception e)
        {
            actual=false;
        }
        Assert.assertEquals(actual,expected,"login button is not enabled for Login page");
        System.out.println("Login button is enabled");
    }

   @Test
    public void lnkforgotPwdVisibilty()
    {
        Login login=new Login(driver);
        boolean expected=true;
        boolean actual=false;
        try
        {
            actual = login.lnkForgotPwd.isDisplayed();
        }
        catch(Exception e)
        {
            actual=false;
        }
        Assert.assertEquals(actual,expected,"Forgot password link is missing on Login page");
        System.out.println("forgot displayed link is displayed");
    }

    @Test
    public void lnkforgotPwdEnables()
    {
        Login login=new Login(driver);
        boolean expected=true;
        boolean actual=false;
        try
        {
            actual = login.lnkForgotPwd.isDisplayed();
        }
        catch(Exception e)
        {
            actual=false;
        }
        Assert.assertEquals(actual,expected,"Forgot password link is not enabled on Login page");
        System.out.println("forgot displayed link enabled");
    }

    @Test
    public void LblUserVisibilty()
    {
        Login login=new Login(driver);
        String expected="Email";
        String actual="";
        try
        {
            actual = login.lblEmail.getText();
        }
        catch(Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected,"Email label is not matching");
        System.out.println("Email label checked");
    }

    @Test
    public void LblPwdVisibilty()
    {
         Login login=new Login(driver);
        String expected="Password";
        String actual="";
        try
        {
            actual = login.lblPassword.getText();
        }
        catch(Exception e)
       {
            actual="";
       }
        Assert.assertEquals(actual,expected,"Password label is not matching");
        System.out.println("Password label checked");
    }

    @Test
    public void LblEmailWatermarkVisibilty()
    {
        Login login=new Login(driver);
        String expected="Email";
        String actual="";
        try
        {
            actual = login.txtEmail.getAttribute("placeholder");
        }
        catch(Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected,"Email watermark  is not matching");
        System.out.println("Email watermark checked");
    }

    @Test
    public void LblPwdWatermarkVisibilty()
    {
        Login login=new Login(driver);
        String expected="Password";
        String actual="";
        try
        {
            actual = login.txtPassword.getAttribute("placeholder");
        }
        catch(Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected,"Password watermark  is not matching");
        System.out.println("Password watermark checked");
    }

    @Test
    public void btnColorTest()
    {
        Login login=new Login(driver);
        String expected="#337ab7";
        String actual="";
        String btnColor="";
        try
        {
            btnColor=login.btnLogin.getCssValue("background-color");
            actual= Color.fromString(btnColor).asHex(); //converting rgba to hex for color
            System.out.println(actual);
        }
        catch(Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected,"Login button color  is not matching");
        System.out.println("Login button color is OK");
        System.out.println(actual);
       /* String hexColor= Color.fromString(actual).asHex(); //converting rgba to hex for color
        System.out.println(hexColor); // these 2 lines not to write here*/
    }

    @AfterClass
    public void end()
    {
        driver.close();
    }
}
