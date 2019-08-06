public class TypeCasting {
public static void main(String[] args){
	System.out.println("\nInside typeCasting ...");
	//Explicit casting
	long y= 42;
	int x = (int) y; 
	//int x = (int) y;
	
	//Information loss due to out-of-range assignment
	byte narrowdByte = (byte) 123456 ;
	System.out.println("narrowdByte: " + narrowdByte);

	//Truncation
	int iTruncated = (int)0.99;
	System.out.println("iTruncate: " + iTruncated);

	//Implicit cast (int to long)
	y = x;	
	System.out.println("int-to-long: " + y);

	//Implicit cast (char to int)
	char cChar = 'A';
	int iInt = cChar;
	System.out.println("iInt: " + iInt);

	//byte to char using an explicit cast


	}

}
