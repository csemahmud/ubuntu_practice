/**
 * 
 */
package com.mahmud.BS12InitializeAppPackage;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class MainProgram {

	/**
		 * @author MAHMUDUL HASAN KHAN CSE
		 *
		 */
	private static class StaticInitialize {
		
		private static final int staticInt1 = 10;		
		private static final int staticInt2;
		private final int integer = 100;
		private final int integer2;
		private final int integer3;
		
		static {
			
			staticInt2 = 20;
			System.out.println("\tInitializing staticInt2 = "
					+ staticInt2);
			
		}

		/**
		 * @param integer3
		 */
		public StaticInitialize(int integer3) {
			super();
			this.integer3 = integer3;
			System.out.println("\tInitializing integer3 = "
					+ integer3);
		}

		/**
		 * 
		 */
		public StaticInitialize() {
			// TODO Auto-generated constructor stub
			
			this(300);
		}
		
		{
			integer2 = 200;
			System.out.println("\tInitializing integer2 = "
					+ integer2);
		}

		/**
		 * @return the staticint1
		 */
		public static synchronized final int getStaticint1() {
			return staticInt1;
		}

		/**
		 * @return the staticint2
		 */
		public static synchronized final int getStaticint2() {
			return staticInt2;
		}

		/**
		 * @return the integer
		 */
		public synchronized final int getInteger() {
			return integer;
		}

		/**
		 * @return the integer2
		 */
		public synchronized final int getInteger2() {
			return integer2;
		}

		/**
		 * @return the integer3
		 */
		public synchronized final int getInteger3() {
			return integer3;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("StaticInitialize [getInteger()=").append(getInteger()).append(", getInteger2()=")
					.append(getInteger2()).append(", getInteger3()=").append(getInteger3()).append("]")
					.append("\n\t").append(toStaticString());
			return builder.toString();
		}

		public static String toStaticString() {
			StringBuilder builder = new StringBuilder();
			builder.append("StaticInitialize [getStaticint1()=").append(getStaticint1()).append(", getStaticint2()=")
					.append(getStaticint2()).append("]");
			return builder.toString();
		}

	}

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
		
		System.out.println("\n\n");
		System.out.println("\t" + StaticInitialize.toStaticString());
		System.out.println();
		System.out.println("\t" + new StaticInitialize());

	}

}
