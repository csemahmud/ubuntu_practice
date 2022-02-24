/**
 * 
 */
package com.mahmud.BS11AccessAppPackage.classes;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class Derived1 extends Parent {
	
	private final int derived1X = 40;

	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Derived1(int x, int y, int z) {
		super(x, y, z);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param parent
	 */
	public Derived1(Parent parent) {
		super(parent.getX(), parent.getY(), parent.getZ());
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public Derived1() {
		// TODO Auto-generated constructor stub
	}

//	/**
//	 * @return the x
//	 */
//	public synchronized final int getX() {
//		return 10;
//	}
	
	// Compilation error
	// Cannot override the final method from Parent

	/**
	 * @return the sum
	 */
	private synchronized final int getSum() {
		return getX() + getY() + getZ() + derived1X;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Derived1 [getSum()=").append(getSum()).append(", getX()=").append(getX()).append(", getY()=")
				.append(getY()).append(", getZ()=").append(getZ()).append("]");
		return builder.toString();
	}

}
