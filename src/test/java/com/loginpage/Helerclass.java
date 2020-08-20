package com.loginpage;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helerclass 
{
      public static String screenshot(WebDriver driver)
      {
    	  String path=System.getProperty("user.dir")+"/screenshot/fb_" + screenshotdatetime()+".png";
    	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	  try
    	  {
			FileHandler.copy(src, new File(path));
		  }
    	  catch (IOException e)
    	  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
    	  return path;
      }
      public static String screenshotdatetime()
      {
    	  DateFormat date=new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
    	  
    	  Date d=new Date();
    	  return date.format(d);
    	  
      }
}
