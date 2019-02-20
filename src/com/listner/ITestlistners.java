package com.listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ITestlistners  implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart"+result.getName());
		System.out.println("start time"+ new java.util.Date());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess"+result.getName());
		System.out.println("start time"+ new java.util.Date());
		try {
			Takescreenshot.takescrernshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Takescreenshot.takescrernshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart"+context.getName());
		System.out.println("start time"+ new java.util.Date());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish"+context.getName());
		System.out.println("finish time"+ new java.util.Date());
	}

}
