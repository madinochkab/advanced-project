/**
 * File Name: MyMath.java <br>
 *

 */

package com.sqa.ms.util.helpers;

/**
 * MyMath // ADDD (description of class)
 * <p>
 * // ADDD (description of core fields)
 * <p>
 * // ADDD (description of core methods)
 *
 * @author Madina, Siebenthal
 * @version 1.0.0
 * @since 1.0
 *
 */

// *BONUS add a collection of type ArrayList<String> operations;
// This should display all operations executed on the instance of MyMath Class
// by calling public void displayOperations(int numOfOperations).
//
// Example of executing:
// Set total to 0
// Add 4 to 0
// Sub 3 from 4
// Multiply 1 by 6
// Display total of 6
// Reset total to 0
// ect...
public class MyMath {
	// A static method which divides one number by another 1/2
	public static double divideNumbers(double num1, double num2) {
		double result = num1 / num2;
		return result;
	}

	// implement only here
	public static boolean evalPrime(int numbers) {
		// check if n is a multiple of 2
		if (numbers == 2) {
			return true;
		} else if (numbers % 2 == 0) {
			return false;
		}
		// if not, then just check the odds
		for (int i = 3; i * i <= numbers; i += 2) {
			if (numbers % i == 0)
				return false;
		}
		return true;

	}

	// bonus
	public static boolean[] evalPrimes(int... numbers) {
		return null;

	}

	/**
	 * @param num1
	 * @param num2
	 * @return
	 */
	// A static method which let the user know if there is a clean division with
	// no remainder
	public static boolean hasCleanDivision(double num1, double num2) {
		double result;
		result = num1 % num2;
		if (result == 0) {
			System.out.println("numbers have a clean division");
			return true;
		} else {
			System.out.println("numbers don't have a clean division");
			return false;
		}

	}

	// A static method which multiplies a set of numbers
	public static double multNumbers(double... nums) {
		double result = 1;
		Double[] numbers = new Double[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result *= nums[i];
		}
		return result;

	}

	// A static method which multiplies a given number by the amount
	public static double powerNumber(double number, double power) {
		// creaing var to hold a final result and setting it to power of 1
		double result = 1;

		if (power > 1) {

			for (int i = 0; i < power; i++) {
				result *= number;
			}
		} else if (power == 1) {
			result = number;
		} else {
			System.out.println("returning 1");

		}

		return result;
	}

	private double result;

	// Default Constructor
	public MyMath() {
		setResult(0);
	}

	// Argument Constructor, starting value given
	public MyMath(double defaultNum) {
		setResult(defaultNum);
	}

	/*
	 * A class which gets the total of an instance object of type MyMath Class
	 */

	// To Add a number to total
	public double add(double num) {
		setResult(getResult() + num);
		return getTotal();
	}

	// To divide a number of total
	public double div(double num) {
		setResult(getResult() / num);
		return getTotal();
	}

	public boolean evalPrime() {

		return MyMath.evalPrime((int) getTotal());

	}

	/**
	 * @return the result
	 */
	public double getResult() {
		return this.result;
	}

	// To get the current total
	public double getTotal() {
		return this.result;
	}

	// To multiply a number to total
	public double mult(double num) {
		setResult(getResult() * num);

		return getTotal();
	}

	// To reset total to 0
	public void reset() {
		// double result = 0;
		setResult(0);

	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(double result) {
		this.result = result;
	}

	// To subtract a number from total
	public double sub(double num) {
		setResult(getResult() - num);

		return getTotal();
	}
}