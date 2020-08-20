package com.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Webelements
{
	WebDriver driver;
     public Webelements(WebDriver driver)
     {
          this.driver=driver;  
          
     }

      @FindBy(id="email")
      WebElement name;
      
      @FindBy(id="pass")
      WebElement Pass;
      
      @FindBy(xpath="//*[@id=\"u_0_b\"]")
      WebElement clickbutton;
      
      public void setup(String uname,String pass1)
      {
    	 
    	 name.sendKeys(uname);
    	 Pass.sendKeys(pass1);
    	 clickbutton.click();
      }
}

