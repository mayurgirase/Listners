package com.listner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Takescreenshot {
	
	public static String takescrernshot(String fname) throws IOException {
		//take screenshot and store in desired file format
		
		File src=((TakesScreenshot)Testdata.dr).getScreenshotAs(OutputType.FILE);
		//String dst=System.getProperty(".\\screenshots")+fname+ ".png";
		
		//copy the screenshot to desired location using copyfile format
		//File destn=new File();
		FileUtils.copyFile(src, new File(".//screenshots//screenshot"+fname+".jpg"));
		return fname ;
		
		
	}

}
