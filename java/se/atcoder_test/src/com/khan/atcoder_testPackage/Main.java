/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 * 
 */
package com.khan.atcoder_testPackage;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Uncomment and execute only one task at a time
		
		//task1();
		//task2();
		//task3();
		task4();
		
		

	}

	private static void task4() {
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) {
			String input;
			String[] numbers;
			
			
			input = scanner.nextLine();    // get the entire line after the prompt 
			numbers = input.split(" "); // split by spaces
			
			int x = Integer.parseInt(numbers[0]);
			int y = Integer.parseInt(numbers[1]);
			
			
			
			int counterx = 0;
			int countery = 0;
			
			for(int i = 1; i <= x; i++) {
				if(x % i == 0){
				    counterx++;
				}
			}
			
			for(int i = 1; i <= y; i++) {
				
				if(y % i == 0){
				    countery++;
				}
			}
			
			if(counterx > countery){
			    System.out.println("X");
			} else if(countery > counterx) {
			    System.out.println("Y");
			} else {
			    System.out.println("Z");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void task3() {
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) {
			String input;
			String[] numbers;
			int i = 0;
			
			input = scanner.nextLine();    // get the entire line after the prompt 
			numbers = input.split(" "); // split by spaces
			
			int n = Integer.parseInt(numbers[0]);
			int x = Integer.parseInt(numbers[1]);
			
			
			input = scanner.nextLine();    // get the entire line after the prompt 
			numbers = input.split(" "); // split by spaces
			
			int counter = 0;
			
			for(i = 0; i < n; i++) {
				if(x == Integer.parseInt(numbers[i])){
				    counter++;
				}
			}
			
			System.out.println(counter);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void task2() {
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) {
			String input;
			String[] numbers;
			int i = 0, j = 0, k = 0;
			
			input = scanner.nextLine();    // get the entire line after the prompt 
			numbers = input.split(" "); // split by spaces
			
			int len1 = Integer.parseInt(numbers[0]);
			int len2 = Integer.parseInt(numbers[1]);
			
			int[] a = new int[len1];
			int[] b = new int[len2];
			
			input = scanner.nextLine();    // get the entire line after the prompt 
			numbers = input.split(" "); // split by spaces
			
			for(i = 0; i < len1; i++) {
				a[i] = Integer.parseInt(numbers[i]);
			}
			
			input = scanner.nextLine();    // get the entire line after the prompt 
			numbers = input.split(" "); // split by spaces
			
			for(i = 0; i < len2; i++) {
				b[i] = Integer.parseInt(numbers[i]);
			}
			
			int[] c;
   
			if (len1 < len2){
			    c = new int[len1];
			} else {
			    c = new int[len2];
			}
			
			k = 0;
			
			for(i = 0; i < len1; i++) {
			    for(j = 0; j < len2; j++){
				    if(a[i] == b[j]){
				        c[k] = b[j];
				        k++;
				    }
			    }
			}
			
			if(k == 0) {
			    System.out.println();
			} else if (k == 1) {
			    System.out.println(c[0]);
			} else {
			    Arrays.sort(c, 0, k);
			
				for(i = 0; i < k-1; i++){
				    System.out.print(c[i] + " ");
				}
				System.out.println(c[k-1]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void task1() {
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[4];
			
			String input = scanner.nextLine();    // get the entire line after the prompt 
			String[] numbers = input.split(" "); // split by spaces
			
			for(int i = 0; i < numbers.length; i++) {
				a[i] = Integer.parseInt(numbers[i]);
			}
			
			int discount = a[0] + a[1] - a[2];
			if(discount < a[3]) {
			    System.out.println(discount);	
			} else {
				System.out.println(a[3]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
