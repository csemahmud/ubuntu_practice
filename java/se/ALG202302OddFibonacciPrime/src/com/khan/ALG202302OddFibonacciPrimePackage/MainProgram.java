/**
 * 
 */
package com.khan.ALG202302OddFibonacciPrimePackage;

import java.util.Arrays;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
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
		
		final int RANGE = 11;
		long ofpNumSet[] = new long[RANGE];
		
		long ofpNum1 = 3;
		long ofpNum2 = 5;
		long ofpNum3;
		
		int index = 0;
		ofpNumSet[index++] = ofpNum1;
		ofpNumSet[index++] = ofpNum2;
		
		while(index < ofpNumSet.length) {
			
			ofpNum3 = ofpNum1 + ofpNum2;
			
			boolean isPrime = true;
			if(ofpNum3%2 == 0) {
				
				isPrime = false;
				
			} else {
				
				for(long i = 3; i <= Math.sqrt(ofpNum3); i += 2) {
					
					if(ofpNum3 % i == 0) {
						
						isPrime = false;
						break;
						
					}
					
				}
				
			}
			
			if(isPrime) {
				
				ofpNumSet[index++] = ofpNum3;
				
			}
			
			ofpNum1 = ofpNum2;
			ofpNum2 = ofpNum3;
			
		}
		
		System.out.println("\n\n");
		System.out.println("\t" + ofpNumSet.length 
				+ " Odd Fibonacci Primes Are : \n\n\t"
				+ Arrays.toString(ofpNumSet));
		
		System.out.println();
		
		viewEWlements(ofpNumSet, 7800);
		viewEWlements(ofpNumSet, 1028458);
		viewEWlements(ofpNumSet, 72);
		viewEWlements(ofpNumSet, 3);
		viewEWlements(ofpNumSet, 5);
		viewEWlements(ofpNumSet, 0);
	}

	private static void viewEWlements(long[] ofpNumSet, long longNum) {
		// TODO Auto-generated method stub
		
		System.out.print("\n\t" + longNum + " = \t");
		
		if(longNum > 0) {
		
			for(int i = 0; i < ofpNumSet.length; i++) {
				
				int counter = 0;
				while((longNum%ofpNumSet[i]) == 0) {
					
					counter++;
					longNum /= ofpNumSet[i];
					
				}
				if(counter > 0) {
					
					System.out.print(ofpNumSet[i] + "^"
							+ counter + "\tX\t");
					
				}
			}
		
		}
		
		System.out.println("\t" +longNum + "\t");
		
	}

}
