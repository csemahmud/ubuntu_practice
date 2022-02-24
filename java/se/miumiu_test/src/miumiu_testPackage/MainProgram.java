/**
 * 
 */
package miumiu_testPackage;

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
		int a1[] = {1, 2, 3, 4};
		System.out.println("\t{1, 2, 3, 4} :: " + f_1(a1));
		int a2[] = {4, 1, 2, 3};
		System.out.println("\t{4, 1, 2, 3} :: " + f_1(a2));
		int a3[] = {1, 1, 2, 2};
		System.out.println("\t{1, 1, 2, 2} :: " + f_1(a3));
		int a4[] = {1, 1};
		System.out.println("\t{1, 1} :: " + f_1(a4));
		int a5[] = {1};
		System.out.println("\t{1, 1} :: " + f_1(a5));
		int a6[] = {};
		System.out.println("\t{} :: " + f_1(a6));

		System.out.println("\n\tf_2 ::");
		int a7[] = {1};
		System.out.println("\t{1} :: " + f_2(a7));
		int a8[] = {1, 2};
		System.out.println("\t{1, 2} :: " + f_2(a8));
		int a9[] = {1, 2, 3};
		System.out.println("\t{1, 2, 3} :: " + f_2(a9));
		int a10[] = {1, 2, 3, 4};
		System.out.println("\t{1, 2, 3, 4} :: " + f_2(a10));
		int a11[] = {3, 3, 4, 4};
		System.out.println("\t{3, 3, 4, 4} :: " + f_2(a11));
		int a12[] = {3, 2, 3, 4};
		System.out.println("\t{3, 2, 3, 4} :: " + f_2(a12));
		int a13[] = {4, 1, 2, 3};
		System.out.println("\t{4, 1, 2, 3} :: " + f_2(a13));
		int a14[] = {1, 1};
		System.out.println("\t{1, 1} :: " + f_2(a14));
		int a15[] = {};
		System.out.println("\t{} :: " + f_2(a15));

		System.out.println("\n\tf_3 ::");
		char a16[] = {'a', 'b', 'c'};
		System.out.println("\t{'a', 'b', 'c'}, 0, 4 :: "
				+ Arrays.toString(f(a16, 0, 4)));
		System.out.println("\t{'a', 'b', 'c'}, 0, 3 :: "
				+ Arrays.toString(f(a16, 0, 3)));
		System.out.println("\t{'a', 'b', 'c'}, 0, 2 :: "
				+ Arrays.toString(f(a16, 0, 2)));
		System.out.println("\t{'a', 'b', 'c'}, 0, 1 :: "
				+ Arrays.toString(f(a16, 0, 1)));
		System.out.println("\t{'a', 'b', 'c'}, 1, 3 :: "
				+ Arrays.toString(f(a16, 1, 3)));
		System.out.println("\t{'a', 'b', 'c'}, 1, 2 :: "
				+ Arrays.toString(f(a16, 1, 2)));
		System.out.println("\t{'a', 'b', 'c'}, 1, 1 :: "
				+ Arrays.toString(f(a16, 1, 1)));
		System.out.println("\t{'a', 'b', 'c'}, 2, 2 :: "
				+ Arrays.toString(f(a16, 2, 2)));
		System.out.println("\t{'a', 'b', 'c'}, 2, 1 :: "
				+ Arrays.toString(f(a16, 2, 1)));
		System.out.println("\t{'a', 'b', 'c'}, 3, 1 :: "
				+ Arrays.toString(f(a16, 3, 1)));
		System.out.println("\t{'a', 'b', 'c'}, 1, 0 :: "
				+ Arrays.toString(f(a16, 1, 0)));
		System.out.println("\t{'a', 'b', 'c'}, -1, 2 :: "
				+ Arrays.toString(f(a16, -1, 2)));
		System.out.println("\t{'a', 'b', 'c'}, -1, -2 :: "
				+ Arrays.toString(f(a16, -1, -2)));
		char a17[] = {};
		System.out.println("\t{}, 0, 1 :: "
				+ Arrays.toString(f(a17, 0, -1)));
	}

	public static int f_1(int[ ] a) {
		
		if(a == null) {
			return -1;
		}
		int first = -1, second = -1;
		for(int i = 0; i < a.length; i++) {
			if(first < a[i]) {
				second = first;
				first = a[i];
			}
			if(second < a[i] && first > a[i]) {
				second = a[i];
			}
		}
		return second;
	}
	
	public static int f_2(int a[]) {
		int odd = 0;
		int even = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i]%2 == 0) {
				even += a[i];
			} else {
				odd += a[i];
			}
		}
		return odd - even;
	}
	
	public static char[] f(char a[], int start, int len) {
		if(start < 0 || len < 0 || start+len-1 >= a.length) {
			return null;
		}
		char newArray[] = new char[len];
		for(int i = 0, j = start; i < len; i++, j++) {
			newArray[i] = a[j];
		}
		return newArray;
	}
}
