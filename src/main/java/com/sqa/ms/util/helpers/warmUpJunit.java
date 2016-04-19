/**
 *   File Name: warmUpJunit.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Mar 31, 2016
 *
 */

package com.sqa.ms.util.helpers;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * warmUpJunit //ADDD (description of class)
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
public class warmUpJunit {
	// Get a char value from the user
	public static char getChar(String question) {
		return 0;

	}

	// Get a char value from the user, must be an acceptable value
	public static char getChar(String question, char... c) {
		return 0;

	}

	// Get a double value from the user
	public static double getDouble(String question) {
		return 0;

	}

	// Get a int from the user, must be in acceptable range value
	public static int getInt(String question, int... acceptableNumbers) {
		return 0;

	}

	// Get a int from the user, must be in acceptable range value
	public static int getIntWithRange(String question, int intMin, int intMax) {
		return intMax;

	}

	// Get a String from the user, must be an acceptable value
	public static String getString(String question, String... s) {
		return question;

	}

	// Get a int from the user, must be in acceptable range value
	public static int getStringWithoutWorkds(String question, String... InvalidWords) {
		return 0;

	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	Scanner scanner = new Scanner(System.in);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeMethod
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterMethod
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Assert.fail("Not yet implemented");
	}

	// Create your own helper method that you may find useful

}
