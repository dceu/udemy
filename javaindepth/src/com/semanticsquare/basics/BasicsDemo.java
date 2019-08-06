package com.semanticsquare.basics ;
class BasicsDemo{
	// 1. Naming rules for classes/methods/variables
	// a) First char: letter, underscore, or $
	// 	Remaining: letter, underscore, $, numbers
	// b) No reserved keywords (See resources section)
	
	int id1 = 0;

	// 2. **Java is case-sensitive
	
	int id = 0;
	int Id = 0;
	int ID = 0;
	
	void foo() {}
	void Foo() {}
	// 3. Printing to console
	// Adapted from http://www.ntu.edu.sg/home/ehchua/programming/java/Jla_Introduction.htp



	static void print() {
		System.out.println("\n\nInside print ...");
		System.out.println("Hello, world!!"); //Advance cursor to beginning of next line
		System.out.println();
		System.out.print("Hello, world!!"); //Cursor stayed after the printed string
		System.out.println("Hello, ");
		System.out.print(" ");
		System.out.print("world!!");
	}	

	static void primitives() {
		int i = 6;
	int j = 2;
	System.out.println(i + j);
	System.out.println(i - j);
	System.out.println(i * j);
	System.out.println(i / j);
	System.out.println(i % j);
	
		
	}

	static void arrays() {
		System.out.println("\nInside arrays..");
		int[] myArray= new int[] {9,11,2,5,4,4,6};
		System.out.println("myArray.length: " + myArray.length);
		System.out.println("myArray[1]: " + myArray[1]);
	}

	public static void main(String[] args) {
		//print();
		arrays();
	
	


}
	// 4. Comments or Disabling Code
	// double-slash for single-line comments 
	// asterisk-slash and slash-asterisk for blockquotes
	// 5. Arithmetic Operations
	
}
