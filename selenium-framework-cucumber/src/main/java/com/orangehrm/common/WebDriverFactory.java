package com.orangehrm.common;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	// to have separate thread level execution
	private static ThreadLocal<WebDriver> threadlevelstorage = new ThreadLocal<>();

	// getter setter methods for dr object

	public static WebDriver getWebDriver() {

		return threadlevelstorage.get();
	}

	// set only within package
	protected static void setWebDriver(WebDriver objdr) {
		threadlevelstorage.set(objdr);

	}

}
