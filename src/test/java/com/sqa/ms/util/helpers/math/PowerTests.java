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

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import org.junit.*;
//import org.junit.runner.*;
//import org.junit.runners.*;
//import org.junit.runners.Parameterized.*;
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

public class PowerTests {

	/**
	 * @return
	 */
	// creating data set
	@DataProvider
	public static Object[][] getData() {
		Object[][] data = { { 2.0, 2.0, 4.0 }, { 5.0, 2.0, 25.0 }, { 4.0, 3.0, 64.0 }, { 1.0, 0.0, 1.0 },
				{ 3.0, 1.0, 3.0 }, { 2.0, 1.5, 4.0 }

		};
		return data;

	}

	@Test(enabled = false)

	public void divideNumbers() {
		double expectedResult;
		double num1 = 10;
		double num2 = 2;

		expectedResult = MyMath.divideNumbers(num1, num2);
		System.out
				.println(String.format("the result of %.0f  the division by %.0f is %.0f", num1, num2, expectedResult));

	}

	@Test(enabled = false)

	public void hasCleanDivision() {
		boolean result;
		double num1 = 3;
		double num2 = 2;
		result = MyMath.hasCleanDivision(num1, num2);
		System.out.println(String.format("the result is %b   for the remainder method for numbers %.0f and %.0f",
				result, num1, num2));
	}

	@Test

	public void mulNumbersTest() {
		double result;

		result = MyMath.multNumbers(2, 2, 3);
		System.out.println(String.format("the result of multiplication  resulting to %.2f", result));

	}

	@Test(dataProvider = "getData")
	public void powerNumber(double num, double power, double expectedResult) {
		double actualResult;

		actualResult = MyMath.powerNumber(num, power);
		String message = String.format("the result of %.0f to the power of %.0f is %.2f", num, power, actualResult);
		System.out.println(message);
		// testng differetnt order : actual, expected, delta, message
		assertEquals(actualResult, expectedResult, 0, message);
	}

	// @Test
	// public void testMyMathClass() {
	// double result = 0;
	// System.out.println(String.format("the result ", result));
	// }
	@Test(enabled = false)
	public void resetTest() {

		double result = 20;

		MyMath myMath = new MyMath(result);
		myMath.reset();
		System.out.println(String.format("Resetted result is equl %.0f", myMath.getTotal()));
	}

	@Test(enabled = false)

	public void testAddAndSubstract() {
		double addNumber = 10;
		double subNumber = 3;
		double result = 0;
		MyMath myMath = new MyMath();
		myMath.add(addNumber);
		myMath.sub(subNumber);

		result = myMath.getTotal();
		System.out.println(String.format("The result of 0 and adding " + "%.0f and then substracting %.0f is %.0f",
				addNumber, subNumber, result));
	}

	@Test(enabled = false)

	public void testDiv() {
		double divNumber = 5;
		double result = 20;
		double divResult;
		MyMath myMath = new MyMath();
		divResult = myMath.div(divNumber);
		result = myMath.getTotal();

		System.out.println(String.format("division of %.0f by %.0f is %.2f", result, divNumber, divResult));
		result = myMath.getTotal();

	}

	@Test(enabled = false)

	public void testMyMult() {

		double multNumber = 2;
		// double totalResult = 0;
		double initValue = 6;

		double multResult;
		MyMath myMath = new MyMath(initValue);

		multResult = myMath.mult(multNumber);
		// myMath.reset();
		// result = myMath.getTotal();
		System.out.println(String.format("multiplication of %.2f and %.0f is equal to %.2f ", initValue, multNumber,
				myMath.getTotal()));

	}
}
