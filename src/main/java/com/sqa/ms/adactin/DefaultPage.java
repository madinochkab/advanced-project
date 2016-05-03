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

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

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
public class DefaultPage {
	public static Logger logger = Logger.getLogger(DefaultPage.class);
	private static String baseURL;
	private static WebDriver driver;

	/**
	 * @return the baseURL
	 */
	public static String getBaseURL() {
		return baseURL;
	}

	/**
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param baseURL
	 *            the baseURL to set
	 */
	public static void setBaseURL(String baseURL) {
		DefaultPage.baseURL = baseURL;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public static void setDriver(WebDriver driver) {
		DefaultPage.driver = driver;
	}

}
