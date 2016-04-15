/**
 *   File Name: AppBasicsTests.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 2, 2016
 *
 */

package com.sqa.ms.util.helpers;

import java.util.Scanner;

import org.testng.annotations.Test;

/**
 * AppBasicsTests //ADDD (description of class)
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
public class AppBasicsTests {
	private static Scanner scanner = new Scanner(System.in);
	static String appName = "MS test";
	static String userName;

	/**
	 * Test method for
	 * {@link com.sqa.ms.util.helpers.AppBasics#farewellUser(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testFarewellUser() {
		AppBasics.farewellUser(userName, appName);
	}

	/**
	 * Test method for
	 * {@link com.sqa.ms.util.helpers.AppBasics#welcomeUserAndGetUsersName(java.lang.String)}
	 * .
	 */
	@Test
	public void testWelcomeUser() {

		userName = AppBasics.welcomeUserAndGetUsersName(appName);
	}

}
