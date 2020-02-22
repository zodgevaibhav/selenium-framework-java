package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.common.WebDriverFactory;

import cucumber.api.java.en.Then;

public class HomePageAfterLogin {

	// WebElements
	@FindBy(id = "welcome")
	WebElement vWelcometxt;

	// explicit wait
	WebDriverWait objwait = new WebDriverWait(WebDriverFactory.getWebDriver(), 10);

	// default constructor to initialize webelements
	public HomePageAfterLogin() {

		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}

	// Pageloaded method
	public HomePageAfterLogin isHomePageLoaded() {

		objwait.until(ExpectedConditions.elementToBeClickable(vWelcometxt));
		return this;
	}

	// Generic methods
	@Then("user should be able to see {string} message")
	public HomePageAfterLogin checkWelcometxt(String txt) {
		Assert.assertEquals(vWelcometxt.getText(), txt);

		return this;

	}

}
