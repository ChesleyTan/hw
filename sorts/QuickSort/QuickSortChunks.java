import java.util.Arrays;
import java.util.Random;
/* Fastest when there are many duplicates, slowest when there are none */
public class QuickSortChunks {
    public int[] sort(int[] a, int low, int high) {
        if (low < high) {
            int[] pivotIndices = partition(a, low, high);
            sort(a, low, pivotIndices[0] - 1);
            sort(a, pivotIndices[1] + 1, high);
        }
        return a;
    }
    public int[] partition(int[] a, int low, int high) {
        int pivotIndex = (int) ((high - low + 1) * Math.random() + low);
        int pivot = a[pivotIndex];
        a[pivotIndex] = a[high];
        a[high] = pivot;
        int wall = low; // Wall keeps track of where the pivot should be
        int wallValue;
        for (;low < high;low++) { // Iterates through array, swapping values > pivot in front of the wall
            if (a[low] < pivot) {
                wallValue = a[wall];
                a[wall] = a[low];
                a[low] = wallValue;
                wall++;
            }
        }
        int dupesWall = wall; // After the normal partition is done, we iterate through the array again, placing all duplicates of the pivot at the front
        for (int i = wall;i <= high;i++) {
            if (a[i] == pivot) {
                a[i] = a[dupesWall]; // The value at the dupesWall will be inserted elsewhere in the array
                a[dupesWall] = pivot; // and pivot will be added to the chunk of duplicates
                dupesWall++;
            }
        }
        return new int[] {wall, --dupesWall}; // returns int[] containing 2 ints representing the bounds of the duplicates chunk
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


        QuickSortChunks qs = new QuickSortChunks();
        Random rand = new Random();
        int[] a = new int[length];
        for (int i = 0;i < length;i++) {
            a[i] = rand.nextInt(entropy);
        }
        System.out.println("Starting sort...");
        long startTime = System.currentTimeMillis();
        qs.sort(a, 0, a.length - 1);
        long endTime = System.currentTimeMillis();
        //System.out.println(Arrays.toString(a));
        System.out.println("Sorted array of length " + length + " in " + (endTime - startTime) + " ms.");
    }
}
