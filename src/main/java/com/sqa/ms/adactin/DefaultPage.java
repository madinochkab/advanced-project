/**
 *   File Name: DefaultPage.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: May 2, 2016
 *
 */

package com.sqa.ms.adactin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.ParseException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * DefaultPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Siebenthal, Madina
 * @version 1.0.0
 * @since 1.0
 *
 */
public class DefaultPage extends PageFactory {

	private static String baseURL = "http://adactin.com/HotelAppBuild2";

	private static WebDriver driver;

	private static Logger logger;

	/**
	 * @param date
	 * @param days
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static String changeDate(String date, int days) throws ParseException, java.text.ParseException {
		String newDate;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df = DateFormat.getDateInstance();
		Calendar calendar = Calendar.getInstance();
		Date inputDate = dateFormat.parse(date);
		calendar.setTime(inputDate);
		calendar.add(Calendar.DATE, days);
		newDate = dateFormat.format(calendar.getTime());
		return newDate;
	}

	/**
	 * @return the baseURL
	 */
	public static String getBaseURL() {
		return baseURL;
	}

	/**
	 * @param baseURL
	 *            the baseURL to set
	 */
	public static void setBaseURL(String baseURL) {
		DefaultPage.baseURL = baseURL;
	}

	public DefaultPage() {
		try {
			setDriver();
		} catch (DriverAlreadyInitializedException e) {
			getLogger().warn(
					"Driver may have been initialized already, does not need reinitilaization from Core Constructor.");
		}
		PageFactory.initElements(getDriver(), this);
	}

	public DefaultPage(WebDriver driver) {
		setDriver(driver);
		PageFactory.initElements(getDriver(), this);
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		if (DefaultPage.driver == null) {
			DefaultPage.driver = new FirefoxDriver();
		}
		return DefaultPage.driver;
	}

	/**
	 * @return the logger
	 */
	public Logger getLogger() {
		if (logger == null) {
			logger = logger.getLogger(this.getClass());
		}
		return logger;
	}

	/*
	 * @param driver the driver to set
	 *
	 * @throws DriverAlreadyInitializedException
	 */
	/**
	 * @throws DriverAlreadyInitializedException
	 */
	public void setDriver() throws DriverAlreadyInitializedException {
		if (DefaultPage.driver == null) {
			DefaultPage.driver = new FirefoxDriver();
			getLogger().warn("Using default Firefox Driver implementation");
		} else {
			throw new DriverAlreadyInitializedException();
		}
	}

	/**
	 * @param driver
	 *            the driver to set
	 * @throws DriverAlreadyInitializedException
	 */
	public void setDriver(WebDriver driver) {
		if (DefaultPage.driver == null) {
			DefaultPage.driver = driver;
		}
	}
}