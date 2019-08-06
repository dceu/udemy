public class Primitives {
	public static void main(String[] args) {
	/*public method primitives(){
		System.out.println("\n\nInside primitives ...");
		// literals demo
		int intHex = 0x0041;
		System.out.println("intHex: " + intHex);
		int intBinary = 0b01000001;
		System.out.println("intBinary: " + intBinary);
		int intChar = 'A'; //holds decimal equivalent, which is 65
		System.out.println("intChar: " + intChar);
		int intUnderscore = 1_123_456;
		System.out.println("intUnderscore: " + intUnderscore);

		char charA = 'A';
		System.out.println("charA: " + charA);
		char charInt = 65;
		System.out.println("charInt: " + charInt);
		char charUnicode = '\u0041'; //
		System.out.println("charUnicode: " + charUnicode);
		char charHex = 0x41 ;
		System.out.println("charHex: " + charHex);
		char charBinary = 0b01000001;
		System.out.println("charBinary: " + charBinary);
	}*/

		boolean isInsured= true;

		double coverageByInsurance = 0.8;
		double billAmount = 1000.0;

		double amountPaidByInsurance = 0.0;
		double amountPaidByPatient = billAmount;

		if (isInsured) {
			amountPaidByInsurance = billAmount * coverageByInsurance; 
			amountPaidByPatient = billAmount - amountPaidByInsurance;
		}

		System.out.println("ByInsurance: " + amountPaidByInsurance);
		System.out.println("ByPatient: " + amountPaidByPatient);
	}
}	
