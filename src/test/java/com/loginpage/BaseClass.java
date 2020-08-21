package com.loginpage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pages.Pageclass;

public class BaseClass 
{
	WebDriver driver;
	public Excelprovider excel;
	public Configclass config;
	
	public ExtentReports repo;
	public ExtentTest test;

	@BeforeSuite
	public void setup() throws Exception 
	{
		excel = new Excelprovider();
		config=new Configclass();
		
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FB+"+ Helerclass.screenshotdatetime()+".html"));		
		repo=new ExtentReports();
		repo.attachReporter(extent);
	}

	@BeforeClass
	public void startup() 
	{
		
		driver = Pageclass.startapplicaction(driver, config.getbrowser(),config.getUrl());
	}

	@AfterClass
	public void closeup() throws Exception 
	{
		System.out.println("stopping appp");
		Pageclass.Stopapplication(driver);
	}
	@AfterMethod
	public void teardownmethod(ITestResult res) throws IOException
	{
		if(res.getStatus()==ITestResult.FAILURE)
		{
			Helerclass.screenshot(driver);
			test.fail("failed due to error",MediaEntityBuilder.createScreenCaptureFromPath(Helerclass.screenshot(driver)).build());
		}
		else if(res.getStatus()==ITestResult.SUCCESS)
		{
			test.pass("passed",MediaEntityBuilder.createScreenCaptureFromPath(Helerclass.screenshot(driver)).build());
		}
		repo.flush();
	}
}
