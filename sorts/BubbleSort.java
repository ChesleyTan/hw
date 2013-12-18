// Chesley Tan
// pd9
// HW#45
// 2013-12-18
/*======================================
  class BubbleSort -- implements bubblesort algorithm
  ======================================*/

import java.util.ArrayList;

public class BubbleSort {

    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
	public static ArrayList populate( int size, int lo, int hi ) {
        ArrayList<Integer> retAL = new ArrayList<Integer>();

		for (int i = 0;i<size;i++){ // Repeat until the retAL is filled up
			retAL.add(((int) ((hi + 1 - lo) * Math.random()) + lo)); // Add one to make range inclusive
		}
        return retAL;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
		int randIndex1 = (int) (al.size() * Math.random());
		int randIndex2 = (int) (al.size() * Math.random());
		for (int i = 0;i<al.size();i++){ // Repeat for more entropy
			al.set(randIndex1,al.set(randIndex2,al.get(randIndex1))); // Swap values at the two random indices
    	}
	}


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
		for (int passNumber = 0;passNumber < data.size() - 1;passNumber++){ // Iterates until data.size() - 1 passes have occurred (everything is sorted)
			for (int i = data.size() - 1;i > 0;i--){ // Start at the end of the data and traverse backwards
				if (data.get(i).compareTo(data.get(i-1)) < 0){
					data.set(i-1,data.set(i,data.get(i-1))); // Swap the two elements
				}
			}
		}

    }//end bubbleSortV -- O(?)


    // ArrayList-returning bubbleSort
    // postcondition: order of data's elements unchanged
    //                Returns sorted copy of data.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
        //declare and initialize empty ArrayList for copying
        ArrayList<Comparable> data = new ArrayList<Comparable>();
		for (int i = 0;i<input.size();i++){ // Initially fill the new ArrayList data with the elements of input
			data.add(input.get(i));
		}
		for (int passNumber = 0;passNumber<data.size()-1;passNumber++){ // Run sort algorithm
			for (int i = data.size() - 1;i > 0;i--){
				if (data.get(i).compareTo(data.get(i-1)) < 0){
					data.set(i-1,data.set(i,data.get(i-1)));
				}
			}
		}

        return data;
    }//end bubbleSort -- O(?)


    public static void main(String [] args){

        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println("========================= Using bubbleSortV() =========================");
		System.out.println( "ArrayList glen before sorting:\n" + glen );
        bubbleSortV(glen);
        System.out.println( "ArrayList glen after sorting:\n" + glen );

        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        bubbleSortV(coco);
        System.out.println( "ArrayList coco after sorting:\n" + coco );

        System.out.println("========================= Using bubbleSort() =========================");
		ArrayList glen2 = new ArrayList<Integer>();
        glen2.add(7);
        glen2.add(1);
        glen2.add(5);
        glen2.add(12);
        glen2.add(3);
        System.out.println( "ArrayList glen2 before sorting:\n" + glen2 );
        ArrayList glen2Sorted = bubbleSort( glen2 );
        System.out.println( "sorted version of ArrayList glen2:\n" 
                            + glen2Sorted );
        System.out.println( "ArrayList glen2 after sorting:\n" + glen2 );

	  	ArrayList coco2 = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco2 before sorting:\n" + coco2 );
        ArrayList coco2Sorted = bubbleSort( coco2 );
        System.out.println( "sorted version of ArrayList coco2:\n" 
                            + coco2Sorted );
        System.out.println( "ArrayList coco2 after sorting:\n" + coco2 );

    }//end main
}
