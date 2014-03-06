import java.util.ArrayList;
public class Sorts {
    public static int[] newRandArr(int length, int entropy) {
        int[] a = new int[length];
        for (int i = 0;i < length;i++) {
            a[i] = (int) (entropy * Math.random());
        }
        return a;
    }
    public static ArrayList<Comparable> newRandArrList(int length, int entropy) {
        ArrayList<Comparable> a = new ArrayList<Comparable>();
        for (int i = 0;i < length;i++) {
            a.add((int) (entropy * Math.random()));
        }
        return a;
    }
    public static void print(int[] a) {
        for (int z : a) {
            System.out.print(Integer.toString(z) + " ");
        }
        System.out.println();
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

        int[] a = newRandArr(length, entropy); 
        long startTime = System.currentTimeMillis();
        int[] ret = MergeSort.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("MergeSort: Sorted random array of length " + length + " in " + (endTime - startTime) + " ms."); 
        System.out.println();

        ArrayList<Comparable> b = newRandArrList(length, entropy); 
        startTime = System.currentTimeMillis();
        ArrayList<Comparable> retb = BubbleSort.bubbleSort(b);
        endTime = System.currentTimeMillis();
        System.out.println("BubbleSort: Sorted random array of length " + length + " in " + (endTime - startTime) + " ms."); 
        System.out.println();

        startTime = System.currentTimeMillis();
        retb = SelectionSort.selectionSort(b);
        endTime = System.currentTimeMillis();
        System.out.println("SelectionSort: Sorted random array of length " + length + " in " + (endTime - startTime) + " ms."); 
        System.out.println();

        startTime = System.currentTimeMillis();
        retb = InsertionSort.insertionSort(b);
        endTime = System.currentTimeMillis();
        System.out.println("InsertionSort: Sorted random array of length " + length + " in " + (endTime - startTime) + " ms."); 
        System.out.println();


    }
}
