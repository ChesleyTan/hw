// Chesley Tan
// pd9
// HW40
// 2013-12-09

/*============================================
   class OrderedArrayList
   Wrapper class for ArrayList.
   Imposes the restriction that stored items 
   must remain sorted in ascending order
   ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
    	_data = new ArrayList<Comparable>();
	}

    public String toString() { 
		return _data.toString();
    }


    public Comparable remove( int index ) { 
    	Comparable temp = _data.get(index);
		_data.remove(index);
		return temp;
	}


    public int size() { 
    	return _data.size();
	}

    
    public Comparable get( int index ) { 
    	return _data.get(index);
	}


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear(Comparable newVal) { 
		for (int i = 0;i<_data.size();i++){
			if (_data.get(i).compareTo(newVal) >= 0){
				_data.add(i,newVal);
				return;
			}
		}
		_data.add(newVal);
	}


    // addBinary takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a binary search to find appropriate index
    public void addBinary(Comparable newVal) { 
		int lower = 0;
		int upper = _data.size() - 1;    	
		while (lower <= upper){	
			if (_data.get((upper + lower) / 2).compareTo(newVal) == 0){
				break;
			}
			else if (_data.get((upper + lower) / 2).compareTo(newVal) > 0)
				upper = (lower + upper) / 2 - 1;
			else if (_data.get((upper + lower) / 2).compareTo(newVal) < 0)
				lower = (lower + upper) / 2 + 1;
		}
		/*================= For Debugging =====================
		System.out.println("Value: " + newVal + " Upper: " + upper + " Lower: " + lower + "\t" + _data);
		=====================================================*/
		_data.add((upper + lower + 1) / 2, newVal);//1 is add inside the paratheses to account for integer truncation.  For example, when the lower bound is 1 and the upper bound is 2, the newVal should be inserted AFTER 1, but if we were to simply find the average of the upper and lower bounds, it would be inserted BEFORE/IN PLACE OF 1.
	}	


    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.addLinear( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	// testing binary search
	Franz = new OrderedArrayList();
	for( int i = 0; i < 15; i++ )
	    Franz.addBinary( (int)( 50 * Math.random() ) );
	System.out.println( Franz );
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
