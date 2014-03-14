// Chesley Tan
// pd9
// HW#46
// 2013-12-19
/*======================================
  class SelectionSort -- implements SelectionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class SelectionSort {

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


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
    	int indexOfMin = 0; 
		Comparable valueOfMin = data.get(indexOfMin);// Set an initial value for minimum that is used for comparison
		int finalAt = -1;// Keeps track of the index of the last element in the AL that is in its final sorted position
		for (int passCounter = 0;passCounter<data.size() - 1;passCounter++){
			indexOfMin = finalAt + 1;
			valueOfMin = data.get(indexOfMin);// Set a new initial value of minimum using the first non final-position element (finalAt + 1)
			for (int i = finalAt + 1;i<data.size();i++){// Iterate through the elements after the last final position element searching for the minimum
				if (data.get(i).compareTo(valueOfMin) < 0){ // Checks if new minimum
					valueOfMin = data.get(i);
					indexOfMin = i;
				}
			}
			finalAt++;// Increments the index of the last element in the AL that is in its final sorted position
			data.set(finalAt,data.set(indexOfMin,data.get(finalAt)));// Swaps the element already occupying the new finalAt index with the new minimum value
		}
	}//end selectionSortV -- O(n^2)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
	public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) {
    	ArrayList<Comparable> retAL = new ArrayList<Comparable>();
		for (int i = 0;i<input.size();i++){ // Fill up new retAL with the elements of input
			retAL.add(input.get(i));
		}
		selectionSortV(retAL); // Sort retAL
		return retAL; // return sorted retAL 
	}//end selectionSort, O(n^2)

    public static void main( String [] args ) {

        /*===============for VOID methods=============
        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        selectionSortV(glen);
        System.out.println( "ArrayList glen after sorting:\n" + glen );

        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        selectionSortV(coco);
        System.out.println( "ArrayList coco after sorting:\n" + coco );
          ============================================*/

		ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        ArrayList glenSorted = selectionSort( glen );
        System.out.println( "sorted version of ArrayList glen:\n" 
                            + glenSorted );
        System.out.println( "ArrayList glen after sorting:\n" + glen );

	  	ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        ArrayList cocoSorted = selectionSort( coco );
        System.out.println( "sorted version of ArrayList coco:\n" 
                            + cocoSorted );
        System.out.println( "ArrayList coco after sorting:\n" + coco );
        /*==========for AL-returning methods==========
          ============================================*/

    }//end main
}
