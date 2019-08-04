package com.web.webdriver_factory;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	private static ThreadLocal<WebDriver> webDriver= new ThreadLocal();
	
	public static WebDriver getDriver(){
		return webDriver.get();		
	}
	public static void setDriver(WebDriver dr){
		webDriver.set(dr);		
	}
}
