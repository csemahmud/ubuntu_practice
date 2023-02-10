/**
 * 
 */
package com.khan.AlgHRCExamPackage;

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
		
		viewGreeneryValueOfOtherSide(
				new String[]{"2", "3 1"});
		viewGreeneryValueOfOtherSide(
				new String[]{"3", "-10 2 10000"});
		viewGreeneryValueOfOtherSide(
				new String[]{"5", 
						"-1000000000 -1000000000 -1000000000 -1000000000 -1000000000"});
	}

	private static void viewGreeneryValueOfOtherSide(String[] lines) {
		// TODO Auto-generated method stub
		
	    int n = Integer.parseInt(lines[0]);
	    String[] aStr = lines[1].split(" ");
	    long a[] = new long[aStr.length]; 

	    for(int i = 0 ; i < aStr.length ; i++){ 

	        a[i] = Long.parseLong(aStr[i]);

	    }
	    for(int i = 0 ; i < n ; i++){ 

	        long other = -1000000000;
	        for(int j = 0; j < n; j++){

	          if((i != j) && (other < a[j])){

	              other = a[j];

	          }

	        }
	        System.out.println(other);

	    }
		
	}

}
