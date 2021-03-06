package com.web_app.test.login_module;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.suite.abstract_tests.AbstractSeleniumTest;
import com.suite.commons.SeleniumUtils;
import com.web.webdriver_factory.WebDriverFactory;

public class LoginTest extends AbstractSeleniumTest{
	
	@Test(groups= {"Critical"})
	public void verifyLoginSuccessFul() throws IOException
	{
		WebDriverFactory.getDriver().get("https://www.google.com");
		screenCheck.checkScreen("verifyLoginSuccessFul");
		Assert.assertTrue(false);
	}

	@Test(groups= {"Critical","Negative"})
	public void verifyLoginUnSuccessFul() throws IOException
	{
		WebDriverFactory.getDriver().get("https://www.google.com");
		screenCheck.checkScreen("verifyLoginSuccessFul");
	}
} 
