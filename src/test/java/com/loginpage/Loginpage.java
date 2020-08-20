package com.loginpage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.element.Webelements;

public class Loginpage extends BaseClass 
{
	@Test
	public void loginapp() throws Exception 
	{
		test=repo.createTest("logintest"); 
		Webelements wb = PageFactory.initElements(driver, Webelements.class);
	    test.info("logging");
	   
		wb.setup(excel.getstringdata("Sheet1", 0, 0), excel.getstringdata("Sheet1", 0, 1));
		Thread.sleep(1000);   
		test.pass("passed");
		
	}
}
