package com.sqa.ms.adactin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC101 {
	String baseURL = "http://adactin.com/hotelapp";
	WebDriver driver = new FirefoxDriver();

	@BeforeClass
	public void setup() {
		this.driver = new FirefoxDriver();
		this.driver.get(this.baseURL);
	}

	@Test
	public void testLogin() {

		// LoginPage loginPage = new LoginPage(this.driver);

		// loginPage.enterUsername("madinochkab").enterPassword("madina261184").login();

		Assert.assertTrue(new LoginPage(this.driver).enterUsername("madinochkab").enterPassword("madina261184").login()
				.hasWelcomeMsg());

	}
}
