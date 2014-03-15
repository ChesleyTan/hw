// Chesley Tan
// pd9
// HW39
// 2013-12-06
/*==================================================
  class SuperArray version 5.0
  Wrapper class for array. Facilitates 
  *  resizing 
  *  expansion 
  *  read/write capability on elements
  *  adding an element to end of array
  *  adding an element at specified index
  *  removing an element at specified index
  ...and now SuperArray complies with the specifications of the 
  List interface. (List.java must be in same dir as this file)
  ==================================================*/

public class SuperArray<T> implements List<T> {

    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values


    //default constructor
    //initializes 10-item array
    public SuperArray() { 
	_data = new Object[10];//Even if we declared _data as a T[] or typecasted Object[] _data to T[], it will still be considered an Object[] so a typecast would be superfluous.  Also, using a T[] to store _data would cause problems when _data is called in a static method such as main because it would then have to be typecasted to an Object[] for the call to work.  For example, if we declared T[] data, we would later on have to do ((Object[]) curtis._data).length to obtain the length.
	_lastPos = 0;
	_size = 0;	
    }

    public String toString() { 
		String foo = "[";
		for( int i = 0; i < _size; i++ ) {
			foo += _data[i] + ",";
		}
		if ( foo.length() > 1 )
			//shave off trailing comma
			foo = foo.substring( 0, foo.length()-1 );
		foo += "]";
		return foo;
    }

    //double capacity of this instance of SuperArray 
	private void expand() { 
		Object[] temp = new Object[ _data.length * 2 ];
		for( int i = 0; i < _data.length; i++ )
			temp[i] = (T) _data[i];
		_data = temp;
    }

    //accessor method -- return value at specified index
    public T get( int index ) {
		return (T) _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public T set( int index, T newVal ) {
		T temp = (T) _data[index];
		_data[index] = newVal;
		_size = index + 1;
		_lastPos = index;
		return temp;
    }


    //adds an item after the last item
    public boolean add( T newVal ) { 
		if (_data.length <= _size){
			expand();
		}
		if (_lastPos == 0 && _size == 0)
			_lastPos = -1;
		_data[_lastPos + 1] = newVal;
		_lastPos++;
		_size++;
		return true;
    }


    //inserts an item at index    
    public void add( int index, T newVal ) { 
    	while (_data.length == _lastPos - 1 || index > _data.length - 1){
			expand();
		}
		for (int i = _lastPos + 1;i>index;i--){
			_data[i] = _data[i-1];
		}
		_data[index] = newVal;
		_size++;
		_lastPos++;
	}


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public T remove( int index ) { 
    	T temp = (T) _data[index];
		for (int i = index;i<_lastPos;i++){
			_data[i] = _data[i+1];
		}
		_data[_size-1] = null;//Necessary because add allows for insertion of data at index beyond the range of the current array length.  This would make everything before the inserted element meaningful and thus any junk values as well
		_size--;
		_lastPos--;
		return temp;
	}


    //return number of meaningful items in _data
    public int size() {
    	return _size;
	}

    public static void main( String[] args ) {

	SuperArray<Integer> curtis = new SuperArray<Integer>();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	}
	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	    System.out.println("new length of underlying array: " 
			       + curtis._data.length);
	}
	
	SuperArray<Integer> mayfield = new SuperArray<Integer>();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
    }//end main()

}//end class SuperArray
