/**
 * 
 */
package BS02ArraysAppPackage;

import java.util.Arrays;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class MainProgram {

	/**
	 * 
	 */
	public MainProgram() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\n\n");
		String names[][] = {
				
				{"Mr.", "Mrs.", "Ms."},
				{"Smith", "Jones"}
				
		};
		
		// Mr. Smith
		System.out.println("\t" + names[0][0] + names[1][0]);
		
		// Mr. Jones
		System.out.println("\t" + names[0][0] + names[1][1]);
		
		// int[] intArray = new int[3] {1, 2, 3};
		// Compiler Error
		// Cannot define dimension expressions 
		// when an array initializer is provided
		
		char[] copyFrom = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
				'j', 'k', 'l', 'm'};
		
		char copyTo[] = new char[10];
		System.arraycopy(copyFrom, 3, copyTo, 0, 5);
		
		System.out.println("\tcopyTo = " + new String(copyTo));
		
		char[] copyfrom = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 
				'q', 'p', 'o', 'n'};
		
		System.arraycopy(copyfrom, 2, copyTo, 5, 5);
		
		System.out.println("\tcopyTo = " + new String(copyTo));
		
		final short s41 = 41;
		final byte b42 = 42;
		int[][] numbers = {
				{11, 12, 'a'},
				{21, 'b', 23},
				{'c', 32, 33},
				{s41, b42, 43}
		};
		
		int[][] copyNum = new int[4][3];
		int[][] result = copyFunction(numbers, copyNum);
		
		System.out.print("\tcopyNum = ");
		printMatrix(copyNum);
		
		System.out.print("\tresult = ");
		printMatrix(result);
		
		replaceElement(copyNum, 3, 2, 2000);
		
		System.out.println("\tcopyNum[3][2] = " + copyNum[3][2]);
		System.out.println("\tresult[3][2] = " + result[3][2]);
	}

	private static void replaceElement(int[][] matrix, int row, int column, int newElement) {
		// TODO Auto-generated method stub
		
		matrix[row][column] = newElement;
	}

	private static void printMatrix(int[][] matrix) {
		// TODO Auto-generated method stub
		
		System.out.println("\n\t[\n");
		Arrays.asList(matrix).stream().forEach(intArray -> {
			
			System.out.print("\t\t" + Arrays.toString(intArray));
			if(!intArray.equals(matrix[matrix.length-1])) {
				System.out.println(",");
			}
			
		});
		System.out.println("\n\n\t]");
	}

	private static int[][] copyFunction(int[][] numbers, int[][] copyNum) {
		// TODO Auto-generated method stub
		
		System.arraycopy(numbers, 0, copyNum, 0, 4);
		return copyNum;
	}

}
