// Chesley Tan
// pd9
// HW35
// 2013-11-29

/*
Note 1: If the isSorted() check is not removed from the BinSearch method, the LinSearch method will be faster for most cases (when array length > 10).
Note 2: Target values were chosen such that their index was closest to the 3/4 of the length of the array
Note 3: LinSearch on an item not in the array takes longer than LinSearch on an item in the array. This is due to the fact that for the general purpose LinSearch, we don't know if the array is sorted.
Note 4: System.nanoTime() was used over System.currentTimeMillis() to differentiate small differences in execution time
Finding 1: For an array of length 3 , BinSearch is slightly faster than LinSearch for a target not in the array, and about as fast for a target in the array.
Finding 1: For an array of length 5 , BinSearch is slightly faster than LinSearch for a target in the array, and about as fast for a target not in the array.
Finding 1: For an array of length 10 , BinSearch is slightly faster than LinSearch for both a target in the array and a target not in the array.
Finding 2: For an array of length 100 , BinSearch is faster than LinSearch in both cases.
Finding 3: For an array of length 1,000 , BinSearch is much faster than LinSearch in both cases. 

Summary: BinSearch showed to be faster than LinSearch for a target in the array for an array of length greater than 5. BinSearch also showed to be faster than LinSearch for a target not in the array.
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
		Comparable[] iArr = evenArr(1000);
		//System.out.print("iArr: ");
		//LinSearch.printArray(iArr);
		System.out.println("iArr length: " + iArr.length);
		
		long t = System.nanoTime();
		System.out.println("linSearch on iArr for 1500: " + LinSearch.linSearch(iArr, 1500));
		System.out.println("Time for search (ns): " + (System.nanoTime() - t));
		
		t = System.nanoTime();
		System.out.println("linSearch on iArr for 1501: " + LinSearch.linSearch(iArr, 1501));
		System.out.println("Time for search (ns): " + (System.nanoTime() - t));
		
		t = System.nanoTime();
		System.out.println("binSearch on iArr for 1500: " + BinSearch2.binSearch(iArr, 1500));
		System.out.println("Time for search (ns): " + (System.nanoTime() - t));
		
		t = System.nanoTime();
		System.out.println("binSearch on iArr for 1501: " + BinSearch2.binSearch(iArr, 1501));
		System.out.println("Time for search (ns): " + (System.nanoTime() - t));
		
	}

}
