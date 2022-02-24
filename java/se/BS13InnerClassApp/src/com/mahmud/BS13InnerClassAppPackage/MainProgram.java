/**
 * 
 */
package com.mahmud.BS13InnerClassAppPackage;

import java.util.Iterator;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class MainProgram {

	private final int[] arrayOfInts = new int[20];
	private final int[] arrayOfInts2 = new int[15];

	/**
	 * 
	 */
	public MainProgram() {
		// TODO Auto-generated constructor stub
		
		for(int i = 0; i < arrayOfInts.length; i++) {
			arrayOfInts[i] = i;
		}
		
		for(int i = 0; i < arrayOfInts2.length; i++) {
			arrayOfInts2[i] = i*i;
		}
	}

	/**
		 * @author MAHMUDUL HASAN KHAN CSE
		 *
		 */
	public interface IntegerIterator extends Iterator<Integer> {
		
		public void setArrayOfIts(int[] arrayOfInts);
		
	}
	
	/**
		 * @author MAHMUDUL HASAN KHAN CSE
		 *
		 */
	private class EvenIterator implements IntegerIterator {
		
		private int nextIndex;
		private int[] arrayOfInts;

		/**
		 * @param arrayOfInts
		 */
		public EvenIterator(int[] arrayOfInts) {
			super();
			this.arrayOfInts = arrayOfInts;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return (nextIndex < arrayOfInts.length - 2);
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			
			int returnValue = arrayOfInts[nextIndex];
			
			nextIndex += 2;
			
			return returnValue;
		}

		/* (non-Javadoc)
		 * @see com.mahmud.BS13InnerClassAppPackage.MainProgram.IntegerIterator#setArrayOfIts(int[][])
		 */
		@Override
		public void setArrayOfIts(int[] arrayOfInts) {
			// TODO Auto-generated method stub

			this.arrayOfInts = arrayOfInts;
			nextIndex = 0;
		}

	}
	
	public void printEven() {
		
		IntegerIterator iterator = new EvenIterator(arrayOfInts);
		printIterator(iterator);
		System.out.print("\t");
		iterator.setArrayOfIts(arrayOfInts2);
		printIterator(iterator);
	}
	
	public void printIterator(IntegerIterator iterator) {
		
		while (iterator.hasNext()) {
			
			System.out.print(iterator.next() + ", ");
			
		}
		System.out.println(iterator.next());
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\n\n");
		System.out.print("\t");
		MainProgram x = new MainProgram();
		x.printEven();
	}

}
