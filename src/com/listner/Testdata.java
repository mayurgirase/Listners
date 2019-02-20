package com.listner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Testdata  {
	 public static WebDriver dr;
	 WebElement weuser;
	 WebElement wepsd;
	 WebElement wesgn;
	 WebElement errmessage;
	 WebElement pagedpl;
	 @BeforeSuite
	public void setbrowser() throws InterruptedException  {
		dr=new FirefoxDriver();
		dr.get("F:\\\\Selenium prgm\\\\Offline Website\\\\index.html");
		 
		}
		
	@BeforeMethod
	public void locateallwebelements() {
		 weuser=dr.findElement(By.xpath(".//*[@id='email']"));
		 wepsd=dr.findElement(By.xpath(".//*[@id='password']"));
		wesgn=dr.findElement(By.xpath(".//*[@id='form']/div[3]/div/button"));
		
		weuser.clear();
		wepsd.clear();
	}
	
	@Test(retryAnalyzer=com.listner.RetryAnalyser.class,priority=0,description="testReporterone")
	public void blankuser() {
		
		//.out.println("username "+us+"passwd "+pd);
		weuser.sendKeys("");
		
		wepsd.sendKeys("");
		
		wesgn.click();
		
		errmessage=dr.findElement(By.xpath(".//*[@id='email_error']"));
		String actual=	errmessage.getText();
		String expected="Please enter email..";
	Assert.assertEquals(actual, expected);
	}
   @Test(priority=1,description="testReportertwo")
	public void invaliduser() {
	  
		//System.out.println("username "+us+"passwd "+pd);
		weuser.sendKeys("mayurvgirase@gmail");
		
		wepsd.sendKeys("0007");
		
		wesgn.click();
		
		errmessage=dr.findElement(By.xpath(".//*[@id='email_error']"));
		String actual=	errmessage.getText();
		String expected="Please enter email as kiran@gmail.com";
	Assert.assertEquals(actual, expected);
	}
   @Test(priority=2,description="testReporterthree")
	public void valid() {
	  
		//System.out.println("username "+us+"passwd "+pd);
		weuser.sendKeys("kiran@gmail.com");
		
		wepsd.sendKeys("123456");
		
		wesgn.click();
		
		pagedpl=dr.findElement(By.xpath("html/body/div[1]/div[1]/section[1]/h1"));
		String actual=	pagedpl.getText();
		String expected="Dashboard Control panel";
	Assert.assertEquals(actual, expected);
	}
   @AfterSuite
	public void closebrowser()
	{
		dr.close();
	}
}
