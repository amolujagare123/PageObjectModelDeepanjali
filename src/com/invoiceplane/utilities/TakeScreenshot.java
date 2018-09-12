package com.invoiceplane.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by amolpc on 13/08/2018.
 */
public class TakeScreenshot
{
    public static String takeScreenshot(WebDriver driver) throws IOException
    {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            String DateStr = sd.format(new Date());
            String imageName = "screenshot"+DateStr+".png";
            String imagePath="Report/screenshots/"+imageName;
            FileUtils.copyFile(scrFile, new File(imagePath)); // C:\DEEPALI\IMG.JPS

            return imageName;

    }



}
