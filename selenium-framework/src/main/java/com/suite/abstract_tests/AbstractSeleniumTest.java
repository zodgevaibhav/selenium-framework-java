package com.suite.abstract_tests;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.suite.commons.TestDataProvider;
import com.suite.commons.listeners.SeleniumMethodInvocationListener;
import com.suite.commons.screencheck.ScreenCheck;

@Listeners(SeleniumMethodInvocationListener.class)
public class AbstractSeleniumTest {
	protected ScreenCheck screenCheck;
	
	public AbstractSeleniumTest()
	{
		screenCheck=new ScreenCheck();
	}
	
	
	@DataProvider(name = "ExcelAPIDataProvider")
	public String[][] DataProvider(Method m) {
		return TestDataProvider.GetExcelDataProvider(m);
	}

}
