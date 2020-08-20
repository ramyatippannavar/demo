package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.loginpage.BaseClass;

public class Linkchecks extends BaseClass
{
	 static WebDriver driver;
    @Test
	public static void links()
    {
    	
   	 List<WebElement> list= driver.findElements(By.tagName("href"));
        for(int i=0;i<=list.size();i++)
        {
     	    WebElement w= list.get(i);
     	    String s=w.getAttribute("href");
     	    System.out.println(s);
     	    
        }
    }
}