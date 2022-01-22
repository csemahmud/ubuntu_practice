/**
 * 
 */
package com.mahmud.BS11AccessAppPackage.classes;

/**
 * @author csema_000
 *
 */
public class Derived2 extends Derived1 {
	
	private final int derived2X = 50;

	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Derived2(int x, int y, int z) {
		super(x, y, z);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param derived1
	 */
	public Derived2(Derived1 derived1) {
		super(derived1.getX(), derived1.getY(), derived1.getZ());
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public Derived2() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the sum
	 */
	private synchronized final int getSum() {
		return getX() + getY() + getZ() + derived2X;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Derived2 [getSum()=").append(getSum()).append(", getX()=").append(getX()).append(", getY()=")
				.append(getY()).append(", getZ()=").append(getZ()).append("]");
		return builder.toString();
	}
	
}
