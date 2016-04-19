/**
 *   File Name: Automation.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 16, 2016
 *
 */

package com.sqa.ms.util.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Automation //ADDD (description of class)
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
public class Automation {
	public static boolean checkPageTitle(String url, String expectedPageTitle) {
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		String actualPageTitle = driver.getTitle();
		if (actualPageTitle.equalsIgnoreCase(expectedPageTitle)) {
			return true;
		} else {
			return false;
		}
	}

}
