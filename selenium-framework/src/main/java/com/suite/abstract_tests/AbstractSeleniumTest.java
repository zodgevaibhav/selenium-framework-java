package com.suite.abstract_tests;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.suite.commons.TestDataProvider;
import com.suite.commons.listeners.SeleniumMethodInvocationListener;
import com.suite.commons.screencheck.IScreenCheck;

@Listeners(SeleniumMethodInvocationListener.class)
public class AbstractSeleniumTest implements IScreenCheck{
	
	@DataProvider(name = "ExcelAPIDataProvider")
	public String[][] DataProvider(Method m) {
		return TestDataProvider.GetExcelDataProvider(m);
	}
}
