//Chesley Tan
//pd 9
//HW31
//2013-11-22
public class LinSearch {
    

    /*==================================================
      int frequency(int[],int) -- uses FOR loop to search int array for target
      post: returns num of times target occurs in array
      ==================================================*/
    public static int frequency( int[] a, int target ) {

		int freq = 0;

		for( int i : a ) 
		    if ( i == target )
			freq++;

		return freq;
    }


    /*==================================================
      int linSearch(Comparable[],Comparable) -- searches an array 
      of Objects of same type for target
      post: returns index of first occurrence of target, or
            returns -1 if target not found
      ==================================================*/
    public static int linSearch ( Comparable[] a, Comparable target ) {
		int tPos = -1;
		int i = 0;
		while ( i < a.length ) {
			if ( a[i].equals( target ) ) {
				tPos = i;
				break;
			}
		i++;
		}
		return tPos;
	}



    // utility/helper fxn to display contents of an array of Objects
	public static void printArray( Object[] arr ) {
		String output = "[ "; 

		for( Object o : arr )
		    output += o + ", ";

		output = output.substring( 0, output.length()-2 ) + " ]";

		System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on int array...");

	//declare and initialize an array of ints
	Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };

	printArray( iArr );

	//search for 6 in array 
	System.out.println( linSearch(iArr,6) );

	//search for 43 in array 
	System.out.println( linSearch(iArr,43) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on String array...");

	//declare and initialize an array of Strings
	Comparable[] y = { "kiwi", "watermelon", "orange", "apple", 
		       "peach", "watermelon" };

	printArray( y );

	//search for "watermelon" in array y
	System.out.println( linSearch(y,"watermelon") );

	//search for "lychee" in array y
	System.out.println( linSearch(y,"lychee") );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on Binary array...");

	//declare Binary array
	Comparable[] bArr = new Binary[10];

	printArray( bArr ); //should show array of nulls

	//initialize Binary array
	//Q: Why would a FOREACH loop not do the job here?
	//A FOREACH loop would throw an error when used on a null value
	for( int i = 0; i < bArr.length; i++ ) {
	    bArr[i] = new Binary( (int)(100 * Math.random()) );
	}

	printArray( bArr ); //should now show Binary numbers

	//search for the value in slot 3 in array
	System.out.println( "Searching for " + bArr[3] + "..." );
	System.out.println( linSearch(bArr, bArr[3] ) );

	//search for 101 in array
	System.out.println( linSearch(bArr, new Binary(5) ) );

	//search for 100000000 in array
	System.out.println( linSearch(bArr, new Binary(256)) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on Hexadecimal array...");

	//declare Hexadecimal array
	Comparable[] hArr = new Hexadecimal[10];

	printArray( hArr ); //should show array of nulls

	//initialize Hexadecimal array
	//Q: Why would a FOREACH loop not do the job here?
	//A FOREACH loop would throw an error when used on a null value
	for( int i = 0; i < hArr.length; i++ ) {
	    hArr[i] = new Hexadecimal( (int)(100 * Math.random()) );
	}

	printArray( hArr ); //should now show Hexadecimal numbers

	//search for the value in slot 3 in array
	System.out.println( "Searching for " + hArr[3] + "..." );
	System.out.println( linSearch(hArr, hArr[3] ) );

	//search for 5 in array
	System.out.println( linSearch(hArr, new Hexadecimal(5) ) );

	//search for 100 in array
	System.out.println( linSearch(hArr, new Hexadecimal(256)) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on Comparable array...");
	Comparable[] cArr = new Comparable[10];
	cArr[0] = (int) (5 * Math.random());
	cArr[1] = (int) (1000 * Math.random());
	cArr[2] = "Time for the rationals, the binaries";
	cArr[3] = "and the hexadecimals";
	cArr[4] = new Rational((int) (5 * Math.random()), (int) (3 * Math.random()) + 1);
	cArr[5] = new Rational((int) (5 * Math.random()), (int) (3 * Math.random()) + 1);
	cArr[6] = new Binary((int) (5 * Math.random() + 1));
	cArr[7] = new Binary((int) (1000 * Math.random() + 1));
	cArr[8] = new Hexadecimal((int) (5 * Math.random() + 1));
	cArr[9] = new Hexadecimal((int) (1000 * Math.random() + 1));

	printArray( cArr ); //should now show array containing ints, Strings, Binaries, and Hexadecimals

	System.out.println( "Searching for " + cArr[3] + "..." );
	System.out.println( linSearch(cArr, cArr[3] ) );

	System.out.println( "Searching for " + cArr[9] + "..." );
	System.out.println( linSearch(cArr, cArr[9] ) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    }//end main()

}//end class Searching
