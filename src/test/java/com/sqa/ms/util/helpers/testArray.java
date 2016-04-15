/**
 *   File Name: testArray.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 4, 2016
 *
 */

package com.sqa.ms.util.helpers;

import org.testng.annotations.Test;

/**
 * testArray //ADDD (description of class)
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
public class testArray {
	@Test
	public void display2DArray() {
		int newArray[][];
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 7, 9, 7, 6 } };

		RequestInput.display2DArray(matrix);
		// for (int row = 0; row < matrix.length; row++) {
		// for (int col = 0; col < matrix[row].length; col++) {
		// System.out.println("enter the elementss for the Matrix");
		// matrix[row][col] = scanner.nextInt();
		//
		// }
		System.out.println();
	}

	@Test
	public void displayArray() {
		System.out.println("array test");
		// System.out.println("Index\tValue");
		int newArray[] = new int[] { 8, 9, 7, 6, 1, 4, 3 };

		RequestInput.displayArray(newArray);

	}
}
