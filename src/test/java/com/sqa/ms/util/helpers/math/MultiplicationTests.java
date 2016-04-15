/**
 *   File Name: MyMathTests.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 13, 2016
 *
 */

package com.sqa.ms.util.helpers.math;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sqa.ms.util.helpers.MyMath;

/**
 * MyMathTests //ADDD (description of class)
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

public class MultiplicationTests {
	/**
	 * @return
	 */
	// creating data set
	@DataProvider(name = "mult Data")
	public static Object[][] getData() {
		Object[][] data = { { new double[] { 2.0, 3.0, 4.0, 2.0 }, 48.0 }, { new double[] { 2.0, 1.0, 5.0 }, 10.0 },
				{ new double[] { 3.0, 1.5, }, 4.5 }, { new double[] { 0.0, 5.0, 15.0, 10.0 }, 0.0 },
				{ new double[] { 1.0, 2.0, 2.5, 3.0, 6.0 }, 90.0 }, { new double[] { 1.5, 5.5, 0.0 }, 0.0 } };

		return data;

	}

	/**
	 * @param numbers
	 * @param expectedResult
	 */
	@Test(dataProvider = "mult Data")
	public void testMultiplication(double[] numbers, double expectedResult) {
		double actualResult = MyMath.multNumbers(numbers);
		String numbersString = Arrays.toString(numbers);
		// error message to only highlight failed test cases
		String errorMessage = String.format(
				"Error. The result of multilying all numbers %s is actually  %.2f not expected ", numbersString,
				actualResult);

		// generic message for failed and passed tests
		String message = String.format("the result of multilying all members %s together is %.2f ", numbersString,
				actualResult);
		System.out.println(message);
		// testng differetnt order : actual, expected, delta, message
		assertEquals(actualResult, expectedResult, 0, message);

	}

}
