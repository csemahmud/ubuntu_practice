/**
 * 
 */
package miumiu_final_testPackage;

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

		System.out.println("\n\n\n");
		System.out.println("\tisMartian ::");
		System.out.println("\t{1,3} :: " 
		+ isMartian(new int[] {1,3}));
		System.out.println("\t{1,2,1,2,1,2,1,2,1} :: " 
				+ isMartian(new int[] {1,2,1,2,1,2,1,2,1}));
		System.out.println("\t{1,3,2} :: " 
				+ isMartian(new int[] {1,3,2}));
		System.out.println("\t{1,3,3,2,1} :: " 
				+ isMartian(new int[] {1,3,3,2,1}));
		System.out.println("\t{1,2,-18,-18,1,2} :: " 
				+ isMartian(new int[] {1,2,-18,-18,1,2}));
		System.out.println("\t{} :: " 
				+ isMartian(new int[] {}));
		System.out.println("\t{1} :: " 
				+ isMartian(new int[] {1}));
		System.out.println("\t{2} :: " 
				+ isMartian(new int[] {2}));
		System.out.println("\t{1,2,1,3,3} :: " 
				+ isMartian(new int[] {1,2,1,3,3}));
		System.out.println("\t{1,1,1,1,1} :: " 
				+ isMartian(new int[] {1,1,1,1,1}));
		System.out.println("\t{2,2,2,2,2} :: " 
				+ isMartian(new int[] {2,2,2,2,2}));
		System.out.println("\t{3,3,3,3,3} :: " 
				+ isMartian(new int[] {3,3,3,3,3}));
		System.out.println("\t{3,1,2,1,3} :: " 
				+ isMartian(new int[] {3,1,2,1,3}));

		
		System.out.println("\n\n\n");
		System.out.println("\tisPairedN ::");
		System.out.println("\t{1,4,1,4,5,6},5 :: " 
				+ isPairedN(new int[] {1,4,1,4,5,6},5));
		System.out.println("\t{1,4,1,4,5,6},6 :: " 
				+ isPairedN(new int[] {1,4,1,4,5,6},6));
		System.out.println("\t{0,1,2,3,4,5,6,7,8,},6 :: " 
				+ isPairedN(new int[] {0,1,2,3,4,5,6,7,8,},6));
		System.out.println("\t{1,4,1},5 :: " 
				+ isPairedN(new int[] {1,4,1},5));
		System.out.println("\t{8,8,8,8,7,7,7},15 :: " 
				+ isPairedN(new int[] {8,8,8,8,7,7,7},15));
		System.out.println("\t{8,-8,8,8,7,7,-7},-15 :: " 
				+ isPairedN(new int[] {8,-8,8,8,7,7,-7},-15));
		System.out.println("\t{3},3 :: " 
				+ isPairedN(new int[] {3},3));
		System.out.println("\t{},0 :: " 
				+ isPairedN(new int[] {},0));
		System.out.println("\t{25,75,25,75},100 :: " 
				+ isPairedN(new int[] {25,75,25,75},100));
		System.out.println("\t{10000,1000,3,2},5 :: " 
				+ isPairedN(new int[] {10000,1000,3,2},5));
		
		
		System.out.println("\n\n\n");
		System.out.println("\tisSelfReferential ::");
		System.out.println("\t{1,2,1,0} :: " 
		+ isSelfReferential(new int[] {1,2,1,0}));
		System.out.println("\t{2,0,0} :: " 
		+ isSelfReferential(new int[] {2,0,0}));
		System.out.println("\t{0} :: " 
		+ isSelfReferential(new int[] {0}));
		System.out.println("\t{1} :: " 
		+ isSelfReferential(new int[] {1}));
		System.out.println("\t{2,0,2,0} :: " 
		+ isSelfReferential(new int[] {2,0,2,0}));
		System.out.println("\t{2,1,2,0,0} :: " 
		+ isSelfReferential(new int[] {2,1,2,0,0}));
		System.out.println("\t{3,2,1,1,0,0,0} :: " 
		+ isSelfReferential(new int[] {3,2,1,1,0,0,0}));
		System.out.println("\t{4,2,1,0,1,0,0,0} :: " 
		+ isSelfReferential(new int[] {4,2,1,0,1,0,0,0}));
		System.out.println("\t{5,2,1,0,0,1,0,0,0} :: " 
		+ isSelfReferential(new int[] {5,2,1,0,0,1,0,0,0}));
		System.out.println("\t{6,2,1,0,0,0,1,0,0,0} :: " 
		+ isSelfReferential(new int[] {6,2,1,0,0,0,1,0,0,0}));
	}

static int isMartian(int[] a) {
		
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(i < a.length - 1 && a[i] == a[i+1]) {
				return 0;
			}
			if(a[i] == 1) {
				count1++;
			} else if (a[i] == 2) {
				count2++;
			}
		}
		
		if(count1 > count2) {
			return 1;
		}
		
		return 0;
	}

static int isPairedN(int[] a, int n) {
	if(n < 0) {
		return 0;
	}
	if(((a.length-1)+(a.length-2)) < n) {
		return 0;
	}
	for(int i = 0; i < a.length; i++) {
		for(int j = i+1; j < a.length; j++) {
			if((i + j == n)&&(a[i] + a[j] == n)) {
				return 1;
			}
		}
	}
	return 0;
}




static int isSelfReferential(int[] a) {
	for(int i = 0; i < a.length; i++) {
		int count = 0;
		for(int j = 0; j < a.length; j++) {
			if(a[j] == i) {
				count++;
			}
		}
		if(count != a[i]) {
			return 0;
		}
	}
	return 1;
}





}
