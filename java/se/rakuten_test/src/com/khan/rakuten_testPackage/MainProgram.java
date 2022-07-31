/**
 * 
 */
package com.khan.rakuten_testPackage;

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
		
		
		System.out.println("\n\n\n");
		System.out.println("\tBISMILLAH HIR RAHMAN NIR RAHIM");
		System.out.println("\n\n\n\tsolution ::");
		System.out.println("\t{1, 3, 6, 4, 1, 2} :: " 
				+ solution(new int[] {1, 3, 6, 4, 1, 2}));
		System.out.println("\t{1, 2, 3} :: " 
				+ solution(new int[] {1, 2, 3}));
		System.out.println("\t{-1, -3} :: " 
				+ solution(new int[] {-1, -3}));
		
		System.out.println("\n\tsolution1 ::");
		System.out.println("\t{-1, 1, 3, 3, 3, 2, 3, 2, 1, 0} :: " 
				+ solution1(new int[] {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0}));
		
	}
	
	public static int solution(int[] A) {
        // write your code in Java SE 8

        int smallestPositive = 1;
        for(int i = 0; i < A.length; i++){
            if(smallestPositive == A[i]){
                smallestPositive++; 
                i = 0;
            }
        }

        return smallestPositive;
    }
	
	public static int solution1(int[] A) {
        // write your code in Java SE 8
		
		int stabilityCounter = 0;
        for(int P = 0; P < A.length - 2; P++){
            if((A[P+2] - A[P+1]) == (A[P+1] - A[P])){
                for(int i = P; i < A.length - 2; i++){
                    if((A[i+2] - A[i+1]) == (A[i+1] - A[i])){
                        stabilityCounter++;
                        if( stabilityCounter > 1_000_000_000) {
                        	return -1;
                        }
                    } else {
                    	break;
                    }
                }
            }
        }

        return stabilityCounter;
    }

}
