/**
 * 
 */
package com.mahmud.BS11AccessAppPackage.classes.outSide;

import com.mahmud.BS11AccessAppPackage.classes.Parent;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class DerivedOut extends Parent {

	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public DerivedOut(int x, int y, int z) {
		super(x, y, z);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public DerivedOut() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param parent
	 */
	public DerivedOut(Parent parent) {
		super(parent.getX(), 0, 0);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DerivedOut [getX()=").append(getX()).append(", getY()=").append(getY()).append("]");
		return builder.toString();
	}

}
