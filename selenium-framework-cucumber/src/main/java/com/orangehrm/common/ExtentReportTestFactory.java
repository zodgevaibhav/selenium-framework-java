package com.orangehrm.common;

import java.util.HashMap;
import java.util.Map;

import org.testng.IInvokedMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTestFactory {
	private static ExtentReports extentReport;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	private static Map<String, ExtentTest> moduleMap = new HashMap<String, ExtentTest>();
	
	//report configuration
	static {
		//you can change file name of report
		//you can give path with filename
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Test Result");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Results");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
				
	}
	
	synchronized public static ExtentTest getModule(String className)
	{
		//if not empty then
		if(!moduleMap.isEmpty() && moduleMap.containsKey(className))
		{
			return moduleMap.get(className);
		}
		//empty then put class name 
		else {
			moduleMap.put(className, extentReport.createTest(className));
			return moduleMap.get(className);
		}
	}
	
	synchronized public static void createNewTest(IInvokedMethod m)
	{
		ExtentReportTestFactory.extentTest.set(
					getModule(m.getTestResult().getInstance().getClass().getSimpleName())
					.createNode(m.getTestMethod().getMethodName())
					);
		for(String group:m.getTestMethod().getGroups())
			extentTest.get().assignCategory(group);
	}

	
	synchronized public static void createNewTest(String moduleName,String testName)
	{
		ExtentReportTestFactory.extentTest.set(
				getModule(moduleName)
				.createNode(testName)
				);
	}
	
	synchronized public static void flushReport()
	{
		extentReport.flush();
	}

	synchronized public static ExtentTest getTest() {
		return extentTest.get();
	}
}
