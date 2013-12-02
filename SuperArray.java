/*==================================================
  class SuperArray
  Wrapper class for array. Facilitates resizing, 
  getting and setting element values.
  ==================================================*/

public class SuperArray {

    private int[] _data;
    private int _lastPos;
    private int _size;


    //default constructor
    //initializes 10-item array
    public SuperArray() { 
		_data = new int[10];
		_size = 10;
		_lastPos = 9;
    }


    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() { 
		String retStr = "[";
    	for (int n:_data){
			retStr += n + ",";
		}
		retStr = retStr.substring(0,retStr.length() - 1) + "]";
		return retStr;
	}


    //double capacity of this instance of SuperArray 
    private void expand() { 
    	int[] newdata = new int[_data.length * 2];
		for (int i = 0;i < _data.length-1;i++){
			newdata[i] = _data[i];
		}
		_data = newdata;
		_size = _data.length;
		_lastPos = _size - 1;
	}


    //accessor method -- return value at specified index
    public int get( int index ) {
		return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) {
    	int oldVal = _data[index];
		_data[index] = newVal;
		return oldVal;
	}

    //main method for testing
    public static void main( String[] args ) {
		SuperArray curtis = new SuperArray();
		System.out.println( "Printing empty SuperArray curtis..." );
		System.out.println( curtis );

		for( int i = 0; i < curtis._size; i++ ) {
			curtis.set( i, i * 2 );
		}

		System.out.println("Printing populated SuperArray curtis...");
		System.out.println(curtis);

		SuperArray mayfield = new SuperArray();
		for( int i = 0; i < mayfield._size; i++ ) {
			mayfield.set( i, i * 2 );
		}
		System.out.println("Printing populated SuperArray mayfield...");
		System.out.println(mayfield);
		mayfield.expand();
		for( int i = 0; i < mayfield._size; i++ ) {
			mayfield.set( i, i * 2 );
		}
		System.out.println("Printing expanded and populated SuperArray mayfield...");
		System.out.println(mayfield);
    }

}//end class SuperArray
