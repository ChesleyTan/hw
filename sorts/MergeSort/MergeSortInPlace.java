/* Faster than regular MergeSort for small datasets (approx. < 15000) and has a logarithmic space complexity */
public class MergeSortInPlace {
    public static int[] sort(int[] a, int left, int right) {
        if (left < right) {
            sort(a, left, (left + right) / 2);
            sort(a, (left + right) / 2 + 1, right);
            merge(a, left, (left + right) / 2, right);
        }
        return a;
    }
    public static int[] sort(int[] a) {
        return sort(a, 0, a.length - 1);
    }
    public static void merge(int[] a, int left, int middle, int right) {
        int l = left; // l is the cursor for values in the left partition
        int m = middle + 1; // m is the cursor for values in the right partition
        int temp;
        if (a[m - 1] <= a[m]){ // If no merging is needed, then return
            return;
        }
        while (l <= middle && m <= right) { // All elements in range are sorted after completion of loop
            if (a[l] > a[m]) { // If right partition element is less than left partition element, then we need to merge
                temp = a[m]; // Store element that has to be merged into the left partition
                System.arraycopy(a, l, a, l + 1, m - l); // Move all elements in in left partition up 1
                a[l] = temp; // Insert element that needed to be merged
                l++;
                m++;
                middle++; // The point separating the two sorted partitions has now changed
            }
            else {
                l++; // No movement is necessary, check next value in the left partition
            }
        }
    }
    public static void main(String[] args) {
        int length = 10;
        int entropy = 20;
        if (args.length > 0) {
            try {
                length = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {
                System.err.print(e.getMessage());
            }
        }
        else {
            System.out.println("(!) No length argument provided. Using default length of " + length + ".");
        }
        if (args.length > 1) {
            try {
                entropy = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e) {
                System.err.print(e.getMessage());
            }
        }
        else {
            System.out.println("(!) No entropy argument provided. Using default entropy of " + entropy + ".");
        }

        // Fill random array
        int[] a = new int[length];
        for (int i = 0;i < length;i++) {
            a[i] = (int) (entropy * Math.random());
        }

        System.out.println("Starting sort...");
        long startTime = System.currentTimeMillis();
        int[] ret = MergeSortInPlace.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted random array of length " + length + " in " + (endTime - startTime) + " ms."); 
        //System.out.print("Unsorted: ");
        //for (int i : a) {
        //    System.out.print(Integer.toString(i) + " ");
        //}
        //System.out.println();
        //System.out.print("Sorted:   ");
        //for (int i : ret) {
        //    System.out.print(Integer.toString(i) + " ");
        //}
        //System.out.println();

    }
}
