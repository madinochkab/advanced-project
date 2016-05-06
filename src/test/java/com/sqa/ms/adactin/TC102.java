package com.sqa.ms.adactin;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC102 {

	private static String baseURL = "http://adactin.com/HotelAppBuild2";

	private static WebDriver driver;

	/**
	 *
	 */

	@DataProvider
	public static Object[][] tc102data() {
		return new Object[][] {
				{ "SQABCMar21", "sqaadmin2016", "Sydney", "Hotel Sunshine", "Double", "1", "01/06/2016", "4", "2",
						true },
				{ "SQABCMar21", "sqaadmin2016", "Paris", "Hotel Creek", "Deluxe", "9", "02/06/2018", "2", "4", true },
				{ "SQABCMar21", "sqaadmin2016", "Paris", "Hotel Creek", "Deluxe", "9", "02/06/2014", "2", "4",
						false } };
	}

	public SearchPage searchPage;

	@BeforeClass
	public void setUp() {
		this.driver = new FirefoxDriver();
		this.driver.get(this.baseURL);
	}

	/**
	 * @param username
	 * @param password
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param numRooms
	 * @param checkIn
	 * @param adultsInRoom
	 * @param childrenInRoom
	 * @param expectedResults
	 * @throws ParseException
	 */
	@Test(dataProvider = "tc102data")
	public void testCheckInOut(String username, String password, String location, String hotel, String roomType,
			String numRooms, String checkIn, String adultsInRoom, String childrenInRoom, boolean expectedResults)
			throws ParseException {
		boolean actualResults;
		System.out.println("TC-102");
		// Eval CheckOut Date:
		String checkOut = DefaultPage.changeDate(checkIn, 7);
		System.out.println("Check-in: " + checkIn + " Check-out: " + checkOut);

		// Login:
		if (this.searchPage == null) {
			this.searchPage = new LoginPage(driver).enterUsername(username).enterPassword(password).login();
		} else {
			this.searchPage.getDriver().get(DefaultPage.getBaseURL() + "/SearchHotel.php");
		}

		System.out.println("Enter Information: ");
		// Enter Information
		this.searchPage.chooseLocation(location).chooseHotel(hotel).chooseRoomType(roomType).chooseNumOfRooms(numRooms)
				.chooseCheckInDate(checkIn).chooseCheckOutDate(checkOut).chooseNumAdultsInRoom(adultsInRoom)
				.chooseNumChildrenInRoom(childrenInRoom)
				// Submit
				.submit();
		// Checkout if actual is same as expected results
		actualResults = !this.searchPage.hasCheckInErrorMessage();
		Assert.assertEquals(actualResults, expectedResults);
	}
}
