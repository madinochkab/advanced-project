/**
 *   File Name: RequestInputTest.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Mar 30, 2016
 *
 */

package com.sqa.ms.util.helpers;

import java.util.Scanner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * RequestInputTest //ADDD (description of class)
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
public class RequestInputTest {
	static public Scanner scanner;
	static private String question;
	static private String userName;
	static private Object userValue;

	/**
	 *
	 */
	@AfterClass
	public static void farewellUser() {
		// TODO Auto-generated method stub
		System.out.println("bye user " + userName);

	}

	/**
	 *
	 */
	@BeforeClass
	public static void welcomeUser() {

		System.out.println("welcome to my request input test");
		System.out.print("whats your name?");
		scanner = new Scanner(System.in);
		userName = scanner.nextLine();

	}

	/**
	 * @param question
	 * @param userValue
	 */
	@BeforeMethod
	public void clearVariables() {
		userValue = "";
		question = "";
	}

	/**
	 * @param question
	 * @param userValue
	 */
	@AfterMethod
	public void displayOutput() {
		System.out.println("for the question \"" + question + "\" you have given the value of (" + userValue + ")");
	}

	/**
	 * Test method for
	 * {@link com.sqa.ms.util.helpers.RequestInput#getChar(java.lang.String)}.
	 */
	@Test

	public void testGetCharString() {
		question = "please give me a char type";
		userValue = RequestInput.getChar(question);

	}

	/**
	 * Test method for
	 * {@link com.sqa.ms.util.helpers.RequestInput#getChar(java.lang.String, char[])}
	 * .
	 */
	@Test(enabled = false)

	public void testGetCharStringCharArray() {
		question = "please give me a char type in an array";
		userValue = RequestInput.getChar(question);
	}

	/**
	 * Test method for
	 * {@link com.sqa.ms.util.helpers.RequestInput#getDouble(java.lang.String)}.
	 */
	@Test

	public void testGetDouble() {
		question = "please give me a double type number";
		userValue = RequestInput.getDouble(question);

	}

	/**
	 * Test method for
	 * {@link com.sqa.ms.util.helpers.RequestInput#getInt(java.lang.String, int[])}
	 * .
	 */
	@Test
	public void testGetInt() {

		question = "please give me your lucky number";
		userValue = RequestInput.getInt(question, 1, 2, 3, 4, 5, 6, 7);

	}

	/**
	 * Test method for
	 * {@link com.sqa.ms.util.helpers.RequestInput#getString(java.lang.String, java.lang.String[])}
	 * .
	 */
	@Test

	public void testGetString() {
		// welcomeUser();
		question = "please give me your favority color";
		userValue = RequestInput.getString(question, "red", "white", "blue");
		// displayOutput();
		// farewellUser();
	}

}
