package com.orangehrm.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.common.BaseSelenium;
import com.orangehrm.common.ExtentReportTestFactory;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

public class CucumberLoginTestRunner extends BaseSelenium{
	private TestNGCucumberRunner cucumberRunner;
	

	 @BeforeSuite
	 public void beforeSuite()
	 {
		 System.setProperty("cucumber.options","features/Login.feature --glue com.orangehrm.pages ");
		 cucumberRunner = new TestNGCucumberRunner(this.getClass());
	 }
	 
	 @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "cucumber-data")
	 public void runScenarios(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable
	 {
		 ExtentReportTestFactory.createNewTest(featureWrapper.toString(),pickleWrapper.toString());
		 cucumberRunner.runScenario(pickleWrapper.getPickleEvent());
	 }
	 
	 @DataProvider(name="cucumber-data",parallel=true)
	 public Object[][] dataProvider()
	 {
		 return cucumberRunner.provideScenarios();
	 }
	 
}
