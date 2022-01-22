/**
 * 
 */
package miumiu_samplePackage;

import java.util.Arrays;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class MainProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\n\n\n\tf_1 ::");
		int a1[] = {1, 2, 3, 4, 5};
		System.out.println("\t{1, 2, 3, 4, 5} = " + f_1(a1));
		int a2[] = {3, 2, 1, 4, 5};
		System.out.println("\t{3, 2, 1, 4, 5} = " + f_1(a2));
		int a3[] = {3, 2, 1, 4, 1};
		System.out.println("\t{3, 2, 1, 4, 1} = " + f_1(a3));
		int a4[] = {1, 2, 3, 4};
		System.out.println("\t{1, 2, 3, 4} = " + f_1(a4));
		int a5[] = {};
		System.out.println("\t{} = " + f_1(a5));
		int a6[] = {10};
		System.out.println("\t{10} = " + f_1(a6));
		
		
		System.out.println("\n\tf_2 ::");
		int a7[] = {1};
		System.out.println("\t{1} = " + f_2(a7));
		int a8[] = {1,2};
		System.out.println("\t{1,2} = " + f_2(a8));
		int a9[] = {1,2,3};
		System.out.println("\t{1,2,3} = " + f_2(a9));
		int a10[] = {1,2,3,4};
		System.out.println("\t{1,2,3,4} = " + f_2(a10));
		int a11[] = {3,3,4,4};
		System.out.println("\t{3,3,4,4} = " + f_2(a11));
		int a12[] = {3,2,3,4};
		System.out.println("\t{3,2,3,4} = " + f_2(a12));
		int a13[] = {4,1,2,3};
		System.out.println("\t{4,1,2,3} = " + f_2(a13));
		int a14[] = {1,1};
		System.out.println("\t{1,1} = " + f_2(a14));
		int a15[] = {};
		System.out.println("\t{} = " + f_2(a15));
		
		
		System.out.println("\n\tf_3 ::");
		char charA1[] = {'a', 'b', 'c'};
		char resultA1[] = f_3(charA1, 0, 4);
		if(resultA1 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 0, 4 :: "
				+ String.valueOf(resultA1));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 0, 4 :: null ");
		}
		char resultA2[] = f_3(charA1, 0, 3);
		if(resultA2 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 0, 3 :: "
				+ String.valueOf(resultA2));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 0, 3 :: null ");
		}
		char resultA3[] = f_3(charA1, 0, 2);
		if(resultA3 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 0, 2 :: "
				+ String.valueOf(resultA3));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 0, 2 :: null ");
		}
		char resultA4[] = f_3(charA1, 0, 1);
		if(resultA4 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 0, 1 :: "
				+ String.valueOf(resultA4));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 0, 1 :: null ");
		}
		char resultA5[] = f_3(charA1, 1, 3);
		if(resultA5 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 1, 3 :: "
				+ String.valueOf(resultA5));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 1, 3 :: null ");
		}
		char resultA6[] = f_3(charA1, 1, 2);
		if(resultA6 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 1, 2 :: "
				+ String.valueOf(resultA6));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 1, 2 :: null ");
		}
		char resultA7[] = f_3(charA1, 1, 1);
		if(resultA7 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 1, 1 :: "
				+ String.valueOf(resultA7));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 1, 1 :: null ");
		}
		char resultA8[] = f_3(charA1, 2, 1);
		if(resultA8 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 2, 1 :: "
				+ String.valueOf(resultA8));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 2, 1 :: null ");
		}
		char resultA9[] = f_3(charA1, 3, 1);
		if(resultA9 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 3, 1 :: "
				+ String.valueOf(resultA9));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 3, 1 :: null ");
		}
		char resultA10[] = f_3(charA1, 1, 0);
		if(resultA10 != null) {
		System.out.println("\t{'a', 'b', 'c'}, 1, 0 :: "
				+ String.valueOf(resultA10));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, 1, 0 :: null ");
		}
		char resultA11[] = f_3(charA1, -1, 2);
		if(resultA11 != null) {
		System.out.println("\t{'a', 'b', 'c'}, -1, 2 :: "
				+ String.valueOf(resultA11));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, -1, 2 :: null ");
		}
		char resultA12[] = f_3(charA1, -1, -2);
		if(resultA12 != null) {
		System.out.println("\t{'a', 'b', 'c'}, -1, -2 :: "
				+ String.valueOf(resultA12));
		} else {
			System.out.println("\t{'a', 'b', 'c'}, -1, -2 :: null ");
		}
		char charAempty[] = {};
		char resultA13[] = f_3(charAempty, 0, 1);
		if(resultA13 != null) {
		System.out.println("\t{}, 0, 1 :: "
				+ String.valueOf(resultA13));
		} else {
			System.out.println("\t{}, 0, 1 :: null ");
		}
		
		
		System.out.println("\n\tf_4 ::");
		System.out.println("\t1234 : " + f_4(1234));
		System.out.println("\t12005 : " + f_4(12005));
		System.out.println("\t1 : " + f_4(1));
		System.out.println("\t1000 : " + f_4(1000));
		System.out.println("\t0 : " + f_4(0));
		System.out.println("\t-12345 : " + f_4(-12345));
				
		System.out.println("\n\tf_5 ::");
		int a16[] = {1,8,3,2};
		int a17[] = {4,2,6,1};
		System.out.println("\t{1,8,3,2} X {4,2,6,1} :: " 
		+ Arrays.toString(f_5(a16,a17)));
		int a18[] = {1,8,3,2,6};
		int a19[] = {2,6,1};
		System.out.println("\t{1,8,3,2,6} X {2,6,1} :: " 
		+ Arrays.toString(f_5(a18,a19)));
		int a20[] = {1,3,7,9};
		int a21[] = {7,1,9,3};
		System.out.println("\t{1,3,7,9} X {7,1,9,3} :: " 
		+ Arrays.toString(f_5(a20,a21)));
		int a22[] = {1,2};
		int a23[] = {3,4};
		System.out.println("\t{1,2} X {3,4} :: " 
		+ Arrays.toString(f_5(a22,a23)));
		int a24[] = {};
		int a25[] = {1,2,3};
		System.out.println("\t{} X {1,2,3} :: " 
		+ Arrays.toString(f_5(a24,a25)));
		int a26[] = {1,2};
		int a27[] = {};
		System.out.println("\t{1,2} X {} :: " 
		+ Arrays.toString(f_5(a26,a27)));
		int a28[] = {1,2};
		int a29[] = null;
		System.out.println("\t{1,2} X null :: " 
		+ Arrays.toString(f_5(a28,a29)));
		int a30[] = null;
		int a31[] = {};
		System.out.println("\tnull X {} :: " 
		+ Arrays.toString(f_5(a30,a31)));
				
		System.out.println("\n\tf_6 ::");
		int a32[] = {1,8,3,7,10,2};
		System.out.println("\t{1,8,3,7,10,2} :: " + f_6(a32));
		int a33[] = {1,5,3,1,1,1,1,1,1};
		System.out.println("\t{1,5,3,1,1,1,1,1,1} :: " + f_6(a33));
		int a34[] = {2,1,1,1,2,1,7};
		System.out.println("\t{2,1,1,1,2,1,7} :: " + f_6(a34));
		int a35[] = {1,2,3};
		System.out.println("\t{1,2,3} :: " + f_6(a35));
		int a36[] = {3,4,5,10};
		System.out.println("\t{3,4,5,10} :: " + f_6(a36));
		int a37[] = {1,2,10,3,4};
		System.out.println("\t{1,2,10,3,4} :: " + f_6(a37));		
		
		System.out.println("\n\tf_7 ::");
		System.out.println("\tRange 1000 : " + f_7(1000));
		System.out.println("\tRange 100 : " + f_7(100));
		System.out.println("\tRange 233 : " + f_7(233));
		System.out.println("\tRange 89 : " + f_7(89));
		System.out.println("\tRange 10 : " + f_7(10));
		System.out.println("\tRange 5 : " + f_7(5));
		System.out.println("\tRange 3 : " + f_7(3));
		System.out.println("\tRange 0 : " + f_7(0));
		System.out.println("\tRange 13 : " + f_7(13));		
		
	}

	private static int f_1(int aMHKBD[]) {
		// TODO Auto-generated method stub
		
		if(aMHKBD == null || aMHKBD.length%2 == 0) {
			return 0;
		}
		int mid_pos = aMHKBD.length/2;
		for(int i = 0; i < mid_pos; i++) {
			if(aMHKBD[i] <= aMHKBD[mid_pos]) {
				return 0;
			}
		}
		for(int i = mid_pos + 1; i < aMHKBD.length; i++) {
			if(aMHKBD[i] <= aMHKBD[mid_pos]) {
				return 0;
			}
		}
		return 1;
	}

	private static int f_2(int aMHKBD[]) {
		// TODO Auto-generated method stub
		
		int even, odd;
		even = 0;
		odd = 0;
		for(int i = 0; i < aMHKBD.length; i++) {
			if(aMHKBD[i] % 2 == 0) {
				even += aMHKBD[i];
			}else {
				odd += aMHKBD[i];
			}
		}
		return odd-even;
	}
	
	private static char[] f_3(char aMHKBD[], int start, int length) {
		if(start < 0 || length < 0 || start+length - 1 >= aMHKBD.length) {
			return null;
		}
		char newA[] = new char[length];
		for(int i = 0, j = start; i < length; i++, j++) {
			newA[i] = aMHKBD[j];
		}
		return newA;
	}
	
	private static int f_4(int intMHKBD) {
		int reverseNum = 0;
		
		while(intMHKBD != 0) {
			reverseNum = (reverseNum*10) + (intMHKBD % 10);
			intMHKBD /= 10;
		}
		
		return reverseNum;
	}
	
	private static int[] f_5(int[] firstArrayMHKBD, int[] secondArrayMHKBD) {
		if(firstArrayMHKBD == null || secondArrayMHKBD == null) {
			return null;
		}
		int commonElements = 0;
		int commonArray[] = new int[firstArrayMHKBD.length];
		for(int i = 0; i < firstArrayMHKBD.length; i++) {
			for(int j = 0; j < secondArrayMHKBD.length; j++) {
				if(firstArrayMHKBD[i] == secondArrayMHKBD[j]) {
					commonArray[commonElements++] 
							= firstArrayMHKBD[i];
				}
			}
		}
		int reducedArray[] = new int[commonElements];
		for(int i = 0; i < commonElements; i++) {
			reducedArray[i] = commonArray[i];
		}
		
		return reducedArray;
	}

	private static int f_6(int[] arrayMHKBD) {
		for(int i = 0; i < arrayMHKBD.length; i++) {
			int before = 0;
			int after = 0;
			for(int j = 0; j < i; j++) {
				before += arrayMHKBD[j];
			}
			for(int j = i+1; j < arrayMHKBD.length; j++) {
				after  += arrayMHKBD[j];
			}
			if(before == after) {
				return i;
			}
		}
		return -1;
	}
	private static int f_7(int rangeMHKBD) {
		if(rangeMHKBD < 3) {
			return -1;
		} else if(rangeMHKBD < 5) {
			return 3;
		} else if(rangeMHKBD < 5) {
			return 3;
		}  else if(rangeMHKBD < 13) {
			return 5;
		}  
		int ofpNum1 = 3, ofpNum2 = 5, ofpNum3 = 0, returnValue = -1;
		while(ofpNum3 <= rangeMHKBD) {
			ofpNum3 = ofpNum1 + ofpNum2;
			boolean isPrime = true;
			for(int i = 3; i <= Math.sqrt(ofpNum3); i+=2) {
				if(ofpNum3 % i == 0) {
					isPrime = false;
				}
			}
			if(isPrime && ofpNum3 <= rangeMHKBD) {
				returnValue = ofpNum3;
			}
			ofpNum1 = ofpNum2;
			ofpNum2 = ofpNum3;
		}
		return returnValue;
	}
}
