package com.sqa.ms.adactin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sqa.ms.util.helpers.ConProperties;

public class adactin {
	// By usernameTest = By.id("email");
	private static String baseURL;

	private static Properties devProps;

	private static String devPropsLocation = "src/main/resources/dev.properties";

	private static WebDriver driver;

	private static Properties sharedMapUI;

	private static String sharedMapUILocation = "src/main/resources/shared-map-ui.properties";

	@DataProvider(name = "UserAccountInfo")
	public static Object[][] getLoginData() {
		// Create a 2D Object with only one level (for one test)
		Object[][] data = new Object[1][];
		// Create a test with 2 elements for username and password
		Object[] test = { devProps.get("username"), devProps.get("password") };
		// Set the array of parameters to be the first element (and only) for
		// the data
		data[0] = test;
		//// System.out.println("Username:" + data[0][0] + " Password:" +
		//// data[0][1]);
		return data;
	}

	@BeforeClass(groups = "firefox", dependsOnMethods = "loadProperties")
	public static void setupFirefox() throws InterruptedException {
		driver = new FirefoxDriver();
		// driver.get(devProps.getProperty("baseURL2"));
	}

	private By by;

	private String message = "succefull login";

	By adultsPerRoom = By.cssSelector("adult_room");
	By checkIn = By.cssSelector("#datepick_in");
	By checkOut = By.cssSelector("#datepick_out");
	By childPerRoom = By.cssSelector("#child_room");
	By errorMEsCheckOut = By.cssSelector("#checkout_span");
	By errorMesChekIn = By.cssSelector("#checkin_span");
	String ErrorMessageBadRange = "range is bad, checkout date is prior check in";
	By hotels = By.cssSelector("#hotels");
	// test editing vars
	By location = By.cssSelector("#location");
	By loginBtn = By.cssSelector("#login");
	By numOfRooms = By.cssSelector("room_nos");
	By password = By.cssSelector("#password");
	By resetBtn = By.cssSelector("#Reset");
	By roomType = By.cssSelector("#room_type");
	By submitBtn = By.cssSelector("#Submit");
	By successLogin = By.cssSelector("#username_show");
	By username = By.cssSelector("#username");

	@AfterClass
	public void afterClass() {
	}

	@BeforeClass
	public void loadProperties() {
		sharedMapUI = ConProperties.loadProperties(sharedMapUILocation);
		devProps = ConProperties.loadProperties(devPropsLocation);
	}

	// to verify whether the check-out date field accepts a later date than
	// check-in date
	@Test(dataProvider = "UserAccountInfo", dependsOnMethods = "testLoginToBase2", priority = 3)
	public void tc102(String username, String password) {
		//
		System.out.println("test 3");
		SelectElement();
		// thiserrorMesChekIn
		Assert.assertEquals("Check-In Date shall be before than Check-Out Date",
				driver.findElement(this.errorMesChekIn).getText(), this.ErrorMessageBadRange);
		System.out.println(this.ErrorMessageBadRange);

	}

	@Test(dataProvider = "UserAccountInfo", dependsOnMethods = "testLoginToBase2", priority = 4, enabled = false)
	public void tc105(String username, String password) {

	}

	@Test(dataProvider = "UserAccountInfo", priority = 1)
	public void testLogin(String username, String password) throws InterruptedException {
		//// clickSigninBtn();
		//// enterCredentialsAndLogin(username, password);
		driver.get(devProps.getProperty("baseURL1"));
		WebElement usernameFld;
		WebElement passwordFld;
		usernameFld = driver.findElement(By.cssSelector(sharedMapUI.getProperty("usernameFld")));
		passwordFld = driver.findElement(By.cssSelector(sharedMapUI.getProperty("passwordFld")));
		usernameFld.sendKeys(username);
		passwordFld.sendKeys(password);

		// WebElement signInBtn = null;

		driver.findElement(By.cssSelector(sharedMapUI.getProperty("signInBtn"))).click();
		;
		// signInBtn.click();

		// if (!isElementPresent(this.by)) {
		// Assert.fail("Did not sign in correctly.");
		// }
		//// WebElement signInLink =
		// driver.findElement(By.cssSelector("#username_show"));
		// System.out.println("text present (" + signInLink.getText() + ")");
		// Assert.assertTrue(isElementPresent(By.partialLinkText("Sign Name")));
		// better use names in separate file for different users
		//// String actualSignInText = signInLink.getText();
		//// String expectedResult = "Hello madinochkab!";
		// Assert.assertEquals(expectedResult, actualSignInText);
		//// Assert.assertEquals(actualSignInText, expectedResult);
		Assert.assertTrue(isElementPresent(By.id("username_show")), this.message);
		System.out.println("assertion is " + this.message);
	}

	// testing login with base number 2
	@Test(dataProvider = "UserAccountInfo", priority = 2)
	public void testLoginToBase2(String username, String password) throws InterruptedException {
		driver.get(devProps.getProperty("baseURL2"));

		WebElement usernameFld;
		WebElement passwordFld;
		usernameFld = driver.findElement(By.cssSelector(sharedMapUI.getProperty("usernameFld")));
		passwordFld = driver.findElement(By.cssSelector(sharedMapUI.getProperty("passwordFld")));
		usernameFld.sendKeys(username);
		passwordFld.sendKeys(password);
		driver.findElement(By.cssSelector(sharedMapUI.getProperty("signInBtn"))).click();
		Assert.assertTrue(isElementPresent(By.id("username_show")), this.message);
		System.out.println("assertion is " + this.message);
	}

	private int enterCheckIn(int daysFromToday) {
		SimpleDateFormat checkIn = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, daysFromToday);
		String dayToday = checkIn.format(c.getTime());
		System.out.println(dayToday);
		this.driver.findElement(this.checkIn).clear();
		this.driver.findElement(this.checkIn).sendKeys(dayToday);
		return daysFromToday;

	}

	private int enterCheckOut(int daysFromToday) {
		SimpleDateFormat checkIn = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, daysFromToday);
		String dayToday = checkIn.format(c.getTime());
		System.out.println(dayToday);
		this.driver.findElement(this.checkOut).clear();
		this.driver.findElement(this.checkOut).sendKeys(dayToday);
		return daysFromToday;

	}

	private void enterInValidCheckIn() {
		SimpleDateFormat todayPlus7 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 7); // Adding 7 days
		String todayPlusSeven = todayPlus7.format(c.getTime());
		System.out.println(todayPlusSeven);

		driver.findElement(By.cssSelector("#datepick_in")).clear();
		driver.findElement(By.cssSelector("#datepick_in")).sendKeys(todayPlusSeven);

		SimpleDateFormat today = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c1 = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		String dayToday = today.format(c1.getTime());
		System.out.println(dayToday);

		driver.findElement(By.cssSelector("#datepick_out")).clear();
		driver.findElement(By.cssSelector("#datepick_out")).sendKeys(dayToday);

		driver.findElement(By.cssSelector("#Submit")).click();

	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// selecting elements by css selector. 1st method
	private void SelectElement() {

		driver.findElement(By.cssSelector("#location>option:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector("#hotels>option:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector("#room_type>option:nth-of-type(2)")).click();
		enterInValidCheckIn();

		driver.findElement(By.cssSelector("#room_nos>option:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector("#adult_room>option:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector("#Submit")).click();
		// driver.findElement(By.cssSelector("#datepick_in")).sendKeys(toda);

	}

	// selecting elements by value, 2nd method
	private void selectElementsOnSearchPage() {
		selectOption(this.location, "Sydney");
		selectOption(this.hotels, "Hotel Creek");
		selectOption(this.roomType, "Standard");
		// selectOption(this.checkIn, "");
		enterCheckIn(2);
		enterCheckOut(4);
		selectOption(this.adultsPerRoom, "1 - One");
		selectOption(this.childPerRoom, "1 - One");

	}

	private void selectOption(By locator, String value) {
		Select fieldSelect = new Select(driver.findElement(locator));
		System.out.println("Possible " + fieldSelect.getOptions());
		fieldSelect.selectByValue(value);
	}

}
