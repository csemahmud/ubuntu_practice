/**
 * 
 */
package com.khan.atcoder_test2Package;

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
		
		//task1();
		//task2();
		task3();
		//task4();
	}

	private static void task4() {
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			String input;
			input = scanner.nextLine();    // get the entire line after the prompt 
			String[] numbers = input.split(" "); // split by spaces
			int h = Integer.parseInt(numbers[0]);
			int w = Integer.parseInt(numbers[1]);
			char[][] a = new char[h][w];
			int si = 0, sj = 0;
			
			for(int i = 0; i < h; i++) {
				
				input = scanner.nextLine();    // get the entire line after the prompt 
				for(int j = 0; j < w; j++) {
					
					a[i][j] = input.charAt(j);
					if(a[i][j] == 'S') {
						si = i;
						sj = j;
					}
					
				}
				
			}
			
			input = scanner.nextLine();    // get the entire line after the prompt
			int n = Integer.parseInt(input);
			int[][] e = new int[h][w];
			for(int i = 0; i < n; i++) {
				
				input = scanner.nextLine();    // get the entire line after the prompt 
				numbers = input.split(" "); // split by spaces
				int r = Integer.parseInt(numbers[0]);
				int c = Integer.parseInt(numbers[1]);
				e[r - 1][c - 1] = Integer.parseInt(numbers[2]);
				
			}
			if(e[si][sj] > 0) {
				e[si][sj] = 0;
				if((si + 1 < h)&&(a[si + 1][sj] != '#')) {
					move(si + 1, sj, a, e, h, w, e[si][sj] - 1);
				}
				if((sj + 1 < w)&&(a[si][sj + 1] != '#')) {
					move(si, sj + 1, a, e, h, w, e[si][sj] - 1);
				}
				if((si - 1 >= 0)&&(a[si - 1][sj] != '#')) {
					move(si - 1, sj, a, e, h, w, e[si][sj] - 1);
				}
				if((sj - 1 >= 0)&&(a[si][sj - 1] != '#')) {
					move(si, sj - 1, a, e, h, w, e[si][sj] - 1);
				}
			}
			
			System.out.println("No");
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void move(int i, int j, char[][] a, int[][] e, int h, int w, int energy) {
		// TODO Auto-generated method stub
		
		if(a[i][j] == 'T') {
			System.out.println("Yes");
			return;
		}
		energy = e[i][j];
		e[i][j] = 0;
		if(energy > 0) {
			if((i + 1 < h)&&(a[i + 1][j] != '#')) {
				move(i + 1, j, a, e, h, w, energy - 1);
			}
			if((j + 1 < w)&&(a[i][j + 1] != '#')) {
				move(i, j + 1, a, e, h, w, energy - 1);
			}
			if((i - 1 >= 0)&&(a[i - 1][j] != '#')) {
				move(i - 1, j, a, e, h, w, energy - 1);
			}
			if((j - 1 >= 0)&&(a[i][j - 1] != '#')) {
				move(i, j - 1, a, e, h, w, energy - 1);
			}
		}
	}

	private static void task3() {
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			String input;
			input = scanner.nextLine();    // get the entire line after the prompt 
			int n = Integer.parseInt(input);
			
			int[][] ac = new int[n][2];
			
			int len = 0;
			
			for(int i = 0; i < n; i++) {
				
				input = scanner.nextLine();
				String[] numbers = input.split(" "); // split by spaces
				int taste = Integer.parseInt(numbers[0]);
				int color = Integer.parseInt(numbers[1]);
				
				int j = 0;
				
				for(; j < len; j++) {
					
					if(ac[j][1] == color) {
						
						if(ac[j][0] > taste) {
							
							ac[j][0] = taste;
							
						}
						
					break;
						
					}
					
				}
				
				if(j == len) {
					ac[len][0] = taste;
					ac[len][1] = color;
					len++;
				}
				
			}
			
			int max = 0;
			
			for(int k = 0; k < len; k++) {
				
				if(max < ac[k][0]) {
					
					max = ac[k][0];
					
				}
				
			}
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void task2() {
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			String input;
			input = scanner.nextLine();    // get the entire line after the prompt 
			int n = Integer.parseInt(input);
			
			int[][] xy = new int[n][2];
			for(int i = 0; i < n; i++) {
				
				input = scanner.nextLine();
				String[] numbers = input.split(" "); // split by spaces
				xy[i][0] = Integer.parseInt(numbers[0]);
				xy[i][1] = Integer.parseInt(numbers[1]);
				
			}
			
			for(int i = 0; i < n; i++) {
				
				double max_distance = 0.00;
				int farthest_point = 0;
				
				for(int j = 0; j < n; j++) {
				
					if(i != j) {
						double distance = Math.sqrt((xy[i][0] - xy[j][0])*(xy[i][0] - xy[j][0])
								+ (xy[i][1] - xy[j][1])*(xy[i][1] - xy[j][1]));
						if(max_distance < distance) {
							max_distance = distance;
							farthest_point = j;
						}
					}
				}
				
				System.out.println(farthest_point + 1);
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void task1() {
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			String input;
			input = scanner.nextLine();    // get the entire line after the prompt 
			int n = Integer.parseInt(input);
			
			for(int i = 1; i <= n; i++) {
				
				if(i%3 == 0) {
					System.out.print("x");
				} else {
					System.out.print("o");
				}
				
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
