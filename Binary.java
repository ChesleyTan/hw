//Chesley Tan
//pd 9
//HW29
//2013-11-20

public class Binary {

    private int _decNum;
    private String _binNum;

    /*=====================================
      default constructor
      precondition:  
      postcondition: 
      =====================================*/
    public Binary() { 
		_decNum = 0;
		_binNum = "0";
    }


    /*=====================================
      overloaded constructor
      precondition:  n >= 0
      postcondition: 
      =====================================*/
    public Binary( int n ) {
    	_decNum = n;
		_binNum = this.decToBin(_decNum);
	}


    /*=====================================
      String toString() -- returns String representation of this Object
      precondition:  
      postcondition: 
      =====================================*/
    public String toString() { 
		return _binNum;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      precondition:  n >= 0
      postcondition: return String of bits
      eg  decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
		String retStr = Integer.toString(n % 2);
		while (n > 0){
			retStr = Integer.toString( (n = (n / 2)) % 2)  + retStr;
		}	
		return retStr.substring(1);// Removes extra 0 added from last iteration of the while loop
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      precondition:  n >= 0
      postcondition: returns String of bits
      eg  decToBin(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) { 
		return n == 0 ? "" : decToBin(n / 2) + (n % 2);
	}
	
	public String getBin(){
		return _binNum;
	}
	public int getDec(){
		return _decNum;
	}
	public boolean equals(Object n){
		return (n instanceof Binary && _binNum.equals( ((Binary) n).getBin()) ); 
	}
	public int compareTo(Object n){
		return !(n instanceof Binary) ? -2 
				: ((Binary) n).getDec() > _decNum ? -1 
				: ((Binary) n).getDec() == _decNum ? 0 
				: 1; 
	}

    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println("decToBin(14): " + decToBin(14));
	System.out.println("decToBin(5): " + decToBin(5));
	System.out.println("decToBinR(14): " + decToBinR(14));
	System.out.println("decToBinR(5): " + decToBinR(5));
	System.out.println("decToBin(1122): " + decToBin(1122));
	System.out.println("decToBinR(1122): " + decToBinR(1122));
	

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	System.out.println("b1: " + b1);
	System.out.println("b2: " + b2);
	System.out.println("b3: " + b3);       
	System.out.println(b1 == b2); 
	System.out.println("b1 == b2: false because b1, b2 not aliases");
	System.out.println(b1 == b3);
	System.out.println("b1 == b3: true because b1, b3 are aliases");
	System.out.println(b1.equals(b2));
	System.out.println("b1.equals(b2): true because binary values of b1 and b2 are equal");
	
	Binary a1 = new Binary(10);
	Binary a2 = new Binary(5);
	Binary a3 = new Binary(10);
	System.out.println("a1: " + a1);
	System.out.println("a2: " + a2);
	System.out.println("a3: " + a3);       
	System.out.println("a1.compareTo(a2)): " + a1.compareTo(a2));
	System.out.println("a2.compareTo(a1)): " + a2.compareTo(a1));
	System.out.println("a1.compareTo(a3)): " + a1.compareTo(a3));

    }//end main()

} //end class
