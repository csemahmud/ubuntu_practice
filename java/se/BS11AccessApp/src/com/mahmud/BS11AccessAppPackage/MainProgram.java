/**
 * 
 */
package com.mahmud.BS11AccessAppPackage;

import com.mahmud.BS11AccessAppPackage.classes.Derived1;
import com.mahmud.BS11AccessAppPackage.classes.Derived2;
import com.mahmud.BS11AccessAppPackage.classes.Parent;
import com.mahmud.BS11AccessAppPackage.classes.ViewPackage;
import com.mahmud.BS11AccessAppPackage.classes.outSide.DerivedOut;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class MainProgram {
	
	private final Parent parent;
	private final Derived1 derived1;
	private final Derived2 derived2;
	private final DerivedOut derivedOut;
	private final ViewPackage viewPackage;

	/**
	 * 
	 */
	public MainProgram() {
		// TODO Auto-generated constructor stub
		
		parent = new Parent(10, 20, 30);
		derived1 = new Derived1(parent);
		derived2 = new Derived2(derived1);
		derivedOut = new DerivedOut(derived2);
		viewPackage = new ViewPackage(parent, derived1, 
				derived2, derivedOut);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainProgram x = new MainProgram();
		System.out.println("\n\n\n\tInside Main .....");
		System.out.println(x.generateString(x.parent));
		System.out.println();
		System.out.println(x.generateString(x.derived1));
		System.out.println();
		System.out.println(x.generateString(x.derived2));
		System.out.println();
		System.out.println(x.generateString(x.derivedOut));
		
		System.out.println("\n\n\n\tEntering ViewPackage .....");
		System.out.println(x.viewPackage.getParentStr());
		System.out.println();
		System.out.println(x.viewPackage.getDerived1Str());
		System.out.println();
		System.out.println(x.viewPackage.getDerived2Str());
		System.out.println();
		System.out.println(x.viewPackage.getDerivedOutStr());

	}
	
	private String generateString(Parent parent) {
		
		return new StringBuilder().append("\tObject = ").append(parent)
				.append("\n\tgetX() = ").append(parent.getX()).toString();
		
	}

}
