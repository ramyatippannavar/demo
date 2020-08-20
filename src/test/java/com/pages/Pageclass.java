package com.pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Pageclass {
	WebDriver driver;

	public static WebDriver startapplicaction(WebDriver driver, String browser, String URL)
	{
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "F://ramya_selenium//maven_proj//drivers//chromedriver.exe");
			 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static void Stopapplication(WebDriver driver) throws Exception 
	{
		Thread.sleep(1000);
		driver.quit();
	}
}
