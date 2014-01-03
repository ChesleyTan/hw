// Chesley Tan
// pd9
// HW#47
// 2014-01-02
// Q1: Is more work done toward beginning or end of insertion sort?
// A: More work is done toward the end because the linear or binary search/insertion on the sorted partition will take longer on a larger data set
// Q2: For n items, # passes necessary to sort?
// A: n-1 passes necessary to sort
// Q3: What do we know after pass p?
// A: After pass p, we know that p elements are sorted relative to each other
// Q4: What is the runtime classification of this sort?
// A: O(n^2)

/*======================================
  class InsertionSort -- implements InsertionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class InsertionSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
        ArrayList<Integer> retAL = new ArrayList<Integer>();
        while( size > 0 ) {
            //     offset + rand int on interval [lo,hi]
            retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
            size--;
        }
        return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
        int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
            //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
            //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSortV( ArrayList<Comparable> data ) {
    	for (int i = 0;i < data.size() - 1;i++){
    		for (int u = 0;u < i + 1;u++){
				if (data.get(i+1).compareTo(data.get(u)) < 0){
    				data.add(u,data.get(i+1)); // Move the element to its sorted position
    				data.remove(i+2); // Remove the old element
    			}
    			// Note that: if the value at data.get(i+1) is greater than any value in the sorted partition, it will be left in its original position, which is also its sorted position
    		}
    	}
	}//end insertionSortV -- O(n^2)


    // ArrayList-returning insertionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
	public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input ) {
    	ArrayList<Comparable> retAL = new ArrayList<Comparable>();
		for (int i = 0;i<input.size();i++){ // Fill up new retAL with the elements of input
			retAL.add(input.get(i));
		}
		insertionSortV(retAL); // Sort retAL
		return retAL; // return sorted retAL 
	}//end insertionSort, O(n^2)

    public static void main( String [] args ) {

        /*===============for VOID methods=============
        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        insertionSortV(glen);
        System.out.println( "ArrayList glen after sorting:\n" + glen );

        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        insertionSortV(coco);
        System.out.println( "ArrayList coco after sorting:\n" + coco );
          ============================================*/

		ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        ArrayList glenSorted = insertionSort( glen );
        System.out.println( "sorted version of ArrayList glen:\n" 
                            + glenSorted );
        System.out.println( "ArrayList glen after sorting:\n" + glen );

	  	ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        ArrayList cocoSorted = insertionSort( coco );
        System.out.println( "sorted version of ArrayList coco:\n" 
                            + cocoSorted );
        System.out.println( "ArrayList coco after sorting:\n" + coco );
        /*==========for AL-returning methods==========
          ============================================*/

    }//end main
}
