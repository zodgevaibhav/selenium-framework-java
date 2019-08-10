package com.web_app.test.login_module;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.suite.abstract_tests.AbstractSeleniumTest;
import com.suite.commons.SeleniumUtils;
import com.web.webdriver_factory.WebDriverFactory;

public class AddUserTest extends AbstractSeleniumTest{
	
	@Test(groups= {"Critical"})
	public void verifyLoginSuccessFul() throws IOException
	{
		WebDriverFactory.getDriver().get("https://www.google.com");
		screenCheck.checkScreen("verifyLoginSuccessFul");
	}

	@Test(groups= {"High"})
	public void verifyLoginSuccessFul1() throws IOException
	{
		WebDriverFactory.getDriver().get("https://www.google.com");
		screenCheck.checkScreen("verifyLoginSuccessFul");
		Assert.assertFalse(true);
	}
} 
