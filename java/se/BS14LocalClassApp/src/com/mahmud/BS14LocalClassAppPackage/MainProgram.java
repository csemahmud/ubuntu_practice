/**
 * 
 */
package com.mahmud.BS14LocalClassAppPackage;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class MainProgram {

	private static final String regularExpression
	 = "[^0-9]";
	
	/**
		 * @author MAHMUDUL HASAN KHAN CSE
		 *
		 */
	private interface IPhoneNumber {
		String getNumber();
		void printOriginalNumbers();
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
		validatePhoneNumber("123-456-7890", "456-7890");

	}

	/**
	 * @param phoneNumber1
	 * @param phoneNumber2
	 */
	private static void validatePhoneNumber(String phoneNumber1, 
			String phoneNumber2) {
		// TODO Auto-generated method stub
		
		// final int numberLength = 10;
		
		// valid in JDK 8 and later
		
		int numberLength = 10;
		
		//Local class ise defined inside a method
		
//		/**
//		 * @author MAHMUDUL HASAN KHAN CSE
//		 *
//		 */
//		private interface IPhoneNumber {
//			String getNumber();
//			void printOriginalNumbers();
//		}
		
		// Compiler Error
		// The member interface IPhoneNumber can only be 
		// defined inside a top-level class or interface 
		// or in a static 

		/**
			 * @author MAHMUDUL HASAN KHAN CSE
			 *
			 */
		final class PhoneNumber implements IPhoneNumber {

			String formattedPhoneNumber = null;
			
			/**
			 * @param phoneNumber
			 */
			public PhoneNumber(String phoneNumber) {
				// TODO Auto-generated constructor stub
				
				String currentNumber = phoneNumber.replaceAll(
						regularExpression, "");
				if(currentNumber.length() == numberLength) {
					formattedPhoneNumber = currentNumber;
				} else {
					formattedPhoneNumber = null;
				}
			}

			/* (non-Javadoc)
			 * @see com.mahmud.BS14LocalClassAppPackage.MainProgram.IPhoneNumber#getNumber()
			 */
			@Override
			public String getNumber() {
				// TODO Auto-generated method stub
				return formattedPhoneNumber;
			}

			/* (non-Javadoc)
			 * @see com.mahmud.BS14LocalClassAppPackage.MainProgram.IPhoneNumber#printOriginalNumbers()
			 */
			@Override
			public void printOriginalNumbers() {
				// TODO Auto-generated method stub

				System.out.println("\tOriginal numbers are : "
						+ phoneNumber1 +" and " + phoneNumber2);
			}

		}
		
		// Object of Local Class
		
		IPhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
		IPhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);
		
		// // valid in JDK 8 and later
		
		myNumber1.printOriginalNumbers();
		
		if(myNumber1.getNumber() == null) {
			System.out.println("\tFirst number is invalid .");
		} else {
			System.out.println("\tFirst number is : "
					+ myNumber1.getNumber());
		}
		
		if(myNumber2.getNumber() == null) {
			System.out.println("\tSecond number is invalid .");
		} else {
			System.out.println("\tSecond number is : "
					+ myNumber2.getNumber());
		}
	}

}
