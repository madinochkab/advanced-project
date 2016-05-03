package com.sqa.ms.adactin;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC102 {
	public static Logger logger = Logger.getLogger(LoginPage.class);
	String baseURL = "http://adactin.com/HotelAppBuild2/";
	WebDriver driver = new FirefoxDriver();

	@BeforeClass
	public void setup() {
		this.driver = new FirefoxDriver();
		this.driver.get(this.baseURL);
	}

	@Test
	public void testCheckInOut() {

		// LoginPage loginPage = new LoginPage(this.driver);

		// loginPage.enterUsername("madinochkab").enterPassword("madina261184").login();
		new LoginPage(this.driver).enterUsername("madinochkab").enterPassword("madina261184").login()
				.chooseHotel("Hotel Creek").chooseLocation("Sydney").chooseNumOfRooms("1 - One")
				.chooseRoomType("Standard");

		// Assert.assertTrue(new
		// LoginPage(this.driver).enterUsername("madinochkab").enterPassword("madina261184").login()
		// .hasWelcomeMsg());

	}
}
