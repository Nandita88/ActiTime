package com.actiTime.generic;


	import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;

	public class BaseClass {
	public static WebDriver driver;
	@BeforeClass
	public void openBrowser()
	{
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public void closeBrowser()
	{
	driver.quit();
	}
	@BeforeMethod
	public void login() 
	{
		driver.get("https://online.actitime.com/ibm/login.do");
		 driver.findElement(By.id("username")).sendKeys("mpchethan999@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("chethan12345");
	driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.id("logoutLink")).click();
		
	}
	}

