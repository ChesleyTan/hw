import java.util.Arrays;
import java.util.Random;
public class QuickSortDuplicates {
    public int[] sort(int[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high);
            sort(a, low, pivotIndex - 1);
            sort(a, pivotIndex + 1, high);
        }
        return a;
    }
    public int partition(int[] a, int low, int high) {
        int pivotIndex = (int) ((high - low + 1) * Math.random() + low);
        int pivot = a[pivotIndex];
        a[pivotIndex] = a[high];
        a[high] = pivot;
        int wall = low;
        int wallValue;
        for (;low < high;low++) {
            if (a[low] < pivot) {
                wallValue = a[wall];
                a[wall] = a[low];
                a[low] = wallValue;
                wall++;
            }
        }
        int dupesWall = wall;
        for (int i = wall;i <= high;i++) {
            if (a[i] == pivot) {
                a[i] = a[dupesWall];
                a[dupesWall] = pivot;
                dupesWall++;
            }
        }
        return (wall + dupesWall) / 2;
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


        QuickSortDuplicates qs = new QuickSortDuplicates();
        Random rand = new Random();
        int[] a = new int[length];
        for (int i = 0;i < length;i++) {
            a[i] = rand.nextInt(entropy);
        }
        System.out.println("Starting sort...");
        long startTime = System.currentTimeMillis();
        //int[] sorted = qs.sort(a, 0, a.length - 1);
        qs.sort(a, 0, a.length - 1);

        long endTime = System.currentTimeMillis();
        //System.out.println(Arrays.toString(sorted));
        System.out.println("Sorted array of length " + length + " in " + (endTime - startTime) + " ms.");
    }
}
