package com.web_app.test.login_module;

import java.io.IOException;

import org.testng.annotations.Test;

import com.suite.abstract_tests.AbstractSeleniumTest;
import com.suite.commons.SeleniumUtils;
import com.web.webdriver_factory.WebDriverFactory;

public class LoginTest extends AbstractSeleniumTest{
	
	@Test
	public void verifyLoginSuccessFul() throws IOException
	{
		WebDriverFactory.getDriver().get("https://www.google.com");
		screenCheck.checkScreen("verifyLoginSuccessFul");
	}

	@Test
	public void verifyLoginSuccessFul1() throws IOException
	{
		WebDriverFactory.getDriver().get("https://www.google.com");
		screenCheck.checkScreen("verifyLoginSuccessFul");
	}
} 
