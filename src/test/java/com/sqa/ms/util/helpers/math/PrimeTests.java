package com.sqa.ms.util.helpers.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sqa.ms.util.helpers.MyMath;

public class PrimeTests {
	@DataProvider(name = "getData")
	public Object[][] getData() {

		return new Object[][] { new Object[] { 3, true }, new Object[] { 2, true }, new Object[] { 8, false },
				new Object[] { 7, true }, new Object[] { 11, true }, new Object[] { 12, false },
				new Object[] { 13, true }, new Object[] { 15, false }, new Object[] { 17, true },
				new Object[] { 10, false }, new Object[] { 20, false }, new Object[] { 4, false },
				new Object[] { 5, true }, new Object[] { 6, false }, new Object[] { 9, false },

		};
		// Assert.assertEquals(actual, expected);
		// Object[][] data = { { 3, true }, { 7, true }, { 8, false } };

	}

	/**
	 * @param number
	 * @param expectedResult
	 */
	@Test(dataProvider = "getData")
	public void testInstancePrime(Integer number, boolean expectedResult) {
		MyMath myMath = new MyMath(0);
		myMath.add(number);
		myMath.evalPrime();

		boolean actualResult = MyMath.evalPrime(number);

		String message = "when adding " + number + " to a total of 0, the result is Prime? ( " + myMath.evalPrime()
				+ ")";
		Assert.assertEquals(actualResult, expectedResult, message);
		System.out.println("Passed " + message);

	}

	/**
	 * @param number
	 * @param expectedResult
	 */
	@Test(enabled = true, dataProvider = "getData")
	public void testStaticPrime(Integer number, boolean expectedResult) {
		boolean actualResult;
		String message;
		actualResult = MyMath.evalPrime(number);
		message = "when using the static method in MyMath class , evalPrime(" + number + " , the result is Prime?{"
				+ MyMath.evalPrime(number) + ")";
		Assert.assertEquals(actualResult, expectedResult, message);

		System.out.println("Passed (" + message + ")");
	}
}
