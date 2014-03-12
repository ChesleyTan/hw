import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class QuickSort {
    public Integer[] sort(Integer[] a) {
        if (a.length <= 1)
            return a;
        else {
            int pivotIndex = (int) (a.length * Math.random());
            int pivot = a[pivotIndex];
            ArrayList<Integer> lower = new ArrayList<Integer>();
            ArrayList<Integer> higher = new ArrayList<Integer>();
            for (int i = 0;i < pivotIndex;i++) {
                if (a[i] > pivot) {
                    higher.add(a[i]);
                }
                else {
                    lower.add(a[i]);
                }
            }
            for (int i = pivotIndex + 1;i < a.length;i++) {
                if (a[i] > pivot) {
                    higher.add(a[i]);
                }
                else {
                    lower.add(a[i]);
                }
            }
            Integer[] lowerArr = lower.toArray(new Integer[]{});
            Integer[] higherArr = higher.toArray(new Integer[]{});
            Integer[] r1 = sort(lowerArr);
            Integer[] r2 = sort(higherArr);
            for (int i = 0;i < r1.length;i++) {
                a[i] = r1[i];
            }
            a[r1.length] = pivot;
            for (int i = 0;i < r2.length;i++) {
                a[i + r1.length + 1] = r2[i];
            }
        }
        return a;
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


        QuickSort qs = new QuickSort();
        Random rand = new Random();
        Integer[] a = new Integer[length];
        for (int i = 0;i < length;i++) {
            a[i] = new Integer(rand.nextInt(entropy));
        }
        long startTime = System.currentTimeMillis();
        Integer[] sorted = qs.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(sorted));
        System.out.println("Sorted array of length " + length + " in " + (endTime - startTime) + " ms.");
    }
}
