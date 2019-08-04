package com.suite.commons.listeners;

import java.net.MalformedURLException;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.web.webdriver_factory.WebDriverFactory;
import com.web.webdriver_factory.WebDriverManager;


public class SeleniumMethodInvocationListener implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if(method.isTestMethod())
		{
			try {
				WebDriverFactory.setDriver(WebDriverManager.CreateInstance());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if(method.isTestMethod())
		{
			WebDriverFactory.getDriver().quit();
		}
	}

	
}
