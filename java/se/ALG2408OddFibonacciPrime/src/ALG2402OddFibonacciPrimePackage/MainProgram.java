/**
 * 
 */
package ALG2402OddFibonacciPrimePackage;

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
			
			ofpNum3 = ofpNum2 + ofpNum1;
			
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
		
		System.out.println("\n");
		System.out.println("\t" + ofpNumSet.length
				+ " Odd Fibonaci Primes are : \n\n\t"
				+ Arrays.toString(ofpNumSet));
		
		viewElements(ofpNumSet, 7_800, 11_570);
		viewElements(ofpNumSet, 5_142_290, 2_571_145);
		viewElements(ofpNumSet, 72, 11_570);
		viewElements(ofpNumSet, 3, 11_570);
		viewElements(ofpNumSet, 5, 11_570);
		viewElements(ofpNumSet, 0, 11_570);

	}

	private static void viewElements(long[] ofpNumSet, long longNum1, long longNum2) {
		// TODO Auto-generated method stub
		
		boolean isElementSet[] = new boolean[ofpNumSet.length];
		
		System.out.print("\n\t" + longNum1 + " = \t" );
		
		if(longNum1 > 0) {
			
			for(int i = 0; i < ofpNumSet.length; i++) {
				
				isElementSet[i] = false;
				int counter = 0;
				while(longNum1%ofpNumSet[i] == 0) {
					
					counter++;
					longNum1 /= ofpNumSet[i];
					
				}
				if(counter > 0) {
					
					isElementSet[i] = true;
					System.out.print(ofpNumSet[i] + "^"
							+ counter + "\tX\t");
					
				}
			}
			
		}
		
		System.out.println(longNum1 + "\t" );
		
		long maxCommomOFPElement = 0;
		System.out.print("\n\t" + longNum2 + " = \t" );
		
		if(longNum2 > 0) {
			
			for(int i = 0; i < ofpNumSet.length; i++) {
				
				int counter = 0;
				while(longNum2%ofpNumSet[i] == 0) {
					
					counter++;
					longNum2 /= ofpNumSet[i];
					
				}
				
				if(counter > 0) {
					
					System.out.print(ofpNumSet[i] + "^"
							+ counter + "\tX\t");
					if(isElementSet[i]) {
						maxCommomOFPElement = ofpNumSet[i];
					}
					
				}
			}
			
		}
		
		System.out.println(longNum2 + "\t" );
		System.out.println("\n\tThe Greatest Common Odd Fibonacci Prime Element for above two numbers is :: " 
					+ maxCommomOFPElement);
		System.out.println();
	}

}
