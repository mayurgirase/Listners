package com.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int counter=0;
	int retrylimit=2;

	@Override
	public boolean retry(ITestResult arg0) {
		if(counter<retrylimit) {
			counter++;
			return true;
		}


		return false;
	}

}
