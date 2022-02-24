/**
 * 
 */
package com.mahmud.BS11AccessAppPackage.classes;

import com.mahmud.BS11AccessAppPackage.classes.outSide.DerivedOut;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class ViewPackage {
	
	private final Parent parent;
	private final Derived1 derived1;
	private final Derived2 derived2;
	private final DerivedOut derivedOut;

	/**
	 * @param parent
	 * @param derived1
	 * @param derived2
	 * @param derivedOut
	 */
	public ViewPackage(Parent parent, Derived1 derived1, Derived2 derived2, DerivedOut derivedOut) {
		super();
		this.parent = parent;
		this.derived1 = derived1;
		this.derived2 = derived2;
		this.derivedOut = derivedOut;
	}

	/**
	 * 
	 */
	public ViewPackage() {
		// TODO Auto-generated constructor stub
		
		this(new Parent(), new Derived1(), new Derived2(), new DerivedOut());
	}
	
	private String generateString(Parent parent) {
		
		return new StringBuilder().append("\tObject = ").append(parent)
				.append("\n\tgetX() = ").append(parent.getX())
				.append("\n\tgetY() = ").append(parent.getY())
				.append("\n\tgetZ() = ").append(parent.getZ()).toString();
		
	}
	
	public String getParentStr() {
		
		return generateString(parent);
		
	}
	
	public String getDerived1Str() {
		
		return generateString(derived1);
		
	}
	
	public String getDerived2Str() {
		
		return generateString(derived2);
		
	}
	
	public String getDerivedOutStr() {
		
//		System.out.println(derivedOut.getZ());
		// Compiler error
		// The method getZ() from the type Parent is not visible
		
		return generateString(derivedOut);
		
	}

}
