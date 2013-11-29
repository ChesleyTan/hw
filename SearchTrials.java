// Chesley Tan
// pd9
// HW35
// 2013-11-29

/*
Note 1: LinSearch vs BinSearch is largely dependent on the target item's position within the search space
If the target is near the beginning, LinSearch will be faster than BinSearch, even for fairly large arrays
If the target is near the end, BinSearch may be faster than LinSearch.
Tests were done with target numbers nearest to the 3/4 length of the array * 2
Note 2: Target values were chosen such that their index was closest to the 3/4 of the length of the array
Note 3: LinSearch on an item not in the array takes longer than LinSearch on an item in the array. This is due to the fact that for the general purpose LinSearch, we don't know if the array is sorted.
Note 4: System.nanoTime() was used over System.currentTimeMillis() to differentiate small differences in execution time
Finding 1: For an array of length 10 , BinSearch is slightly faster for a target not in the array, but LinSearch is slightly faster for a target in the array.
Finding 2: For an array of length 100 , BinSearch is slightly faster for a target not in the array, but LinSearch is consistently faster for a target in the array.
Finding 3: For an array of length 1,000 , LinSearch is consistently faster than binSearch for both an item in the array and an item not in the array.
Finding 4: For an array of length 10,000 , LinSearch is consistently faster than binSearch for both an item in the array and an item not in the array.
Finding 5: For an array of length 100,000 , LinSearch for an item not in the array is faster than BinSearch is, but LinSearch for an item in the array is as fast as BinSearch, if not slightly faster. It is important to note that the times for these two searches fluctuates and some of the time LinSearch is faster, but sometimes BinSearch is faster.
Finding 6: For an array of length 1,000,000 , LinSearch is consistently faster than binSearch for both an item in the array and and item not in the array.
Finding 7: For an array of length 10,000,000 , LinSearch is consistently faster than binSearch for both an item in the array and and item not in the array.
Finding 8: Similar results were obtained for both recursive and iterative methods of binSearch.

Summary: LinSearch showed to be faster than BinSearch for both small and large arrays, and BinSearch was only faster for small arrays in the case of a target not in the array.
*/
public class SearchTrials{
	public static Comparable[] evenArr(int length){
		Comparable[] retArr = new Comparable[length];
		int i = 0;
		while (i < length){
			retArr[i] = i * 2;
			i++;
		}
		return retArr;
	}
	public static void main(String[] args){
		Comparable[] iArr = evenArr(10000);
		//System.out.print("iArr: ");
		//LinSearch.printArray(iArr);
		System.out.println("iArr length: " + iArr.length);
		
		long t = System.nanoTime();
		System.out.println("linSearch on iArr for 15001: " + LinSearch.linSearch(iArr, 15001));
		System.out.println("Time for search (ns): " + (System.nanoTime() - t));
		
		t = System.nanoTime();
		System.out.println("linSearch on iArr for 15000: " + LinSearch.linSearch(iArr, 15000));
		System.out.println("Time for search (ns): " + (System.nanoTime() - t));
		
		t = System.nanoTime();
		System.out.println("binSearch on iArr for 15001: " + BinSearch2.binSearch(iArr, 15001));
		System.out.println("Time for search (ns): " + (System.nanoTime() - t));
		
		t = System.nanoTime();
		System.out.println("binSearch on iArr for 15000: " + BinSearch2.binSearch(iArr, 15000));
		System.out.println("Time for search (ns): " + (System.nanoTime() - t));
		
	}

}
