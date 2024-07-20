/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 * 
 */
package com.khan.codality_testPackage;

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
		System.out.println("\tBANAXXNA :: " 
				+ solution("BANAXXNA"));
		System.out.println("\tBANAXXNABANAXXNA :: " 
				+ solution("BANAXXNABANAXXNA"));
		System.out.println("\tBANANA :: " 
				+ solution("BANANA"));
		System.out.println("\tBANANABANANA :: " 
				+ solution("BANANABANANA"));
		System.out.println("\tBANANABANAN :: " 
				+ solution("BANANABANAN"));
		System.out.println("\tBANANABANANBANANA :: " 
				+ solution("BANANABANANBANANA"));

	}

	private static int solution(String StrBANANA) {
		// TODO Auto-generated method stub
		
		int counter = 0, a = 0, b = 0, n = 0;
		
		for (int i = 0; i < StrBANANA.length(); i++) {
			
			switch(StrBANANA.charAt(i)) {
				
			case 'A':
				a++;
				break;
			case 'B':
				b++;
				break;
			case 'N':
				n++;
				break;			
			}
			
			while((a >= 3)&&(b >= 1)&&(n >= 2)) {
				a -= 3;
				b--;
				n -= 2;
				counter++;
			}
			
		}
		
		return counter;
	}

}
