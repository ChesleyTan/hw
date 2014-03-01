public class MergeSort {
    public static int[] merge(int[] a, int[] b) {
        int length_a = a.length;
        int length_b = b.length;
        int[] longer, shorter;
        int length_longer, length_shorter;
        if (length_a > length_b) {
            longer = a;
            length_longer = length_a;
            shorter = b;
            length_shorter = length_b;
        }
        else {
            longer = b;
            length_longer = length_b;
            shorter = a;
            length_shorter = length_a;
        }
        int[] retArr = new int[length_shorter + length_longer];
        int shorter_index = 0; // counter to iterate through shorter array
        int longer_index = 0; // counter to iterate through larger array
        while (shorter_index < length_shorter && longer_index < length_longer) { 
            if (shorter[shorter_index] > longer[longer_index]) {
                retArr[shorter_index + longer_index] = longer[longer_index];
                longer_index++;
            } 
            else {
                retArr[shorter_index + longer_index] = shorter[shorter_index];
                shorter_index++;
            }
        }
        // If the lists are not the same length, this
        // adds all the remaining elements of the list
        // to the retArr. This works for the case in
        // which the difference in lengths is not 1.
        if (longer_index != length_longer) {
            for (;longer_index < length_longer;longer_index++) {
                retArr[longer_index + shorter_index] = longer[longer_index];
            }
        }
        else if (shorter_index != length_shorter) {
            for (;shorter_index < length_shorter;shorter_index++) {
                retArr[longer_index + shorter_index] = shorter[shorter_index];
            }    
        }
        return retArr;
    }

    public static int[] sort(int[] a) {
        int length_a = a.length;
        if (length_a <= 1) {
            return a;
        }
        int length_longer = length_a / 2;
        int length_shorter = length_a / 2;
        if (length_a % 2 == 1) {
            length_longer += 1;
        }
        int[] longer = new int[length_longer];
        int[] shorter = new int[length_shorter];
        int a_index = 0;
        int i = 0;
        while (i < length_longer) {
            longer[i] = a[a_index];
            i++;
            a_index++;
        }
        i = 0;
        while (i < length_shorter) {
            shorter[i] = a[a_index];
            i++;
            a_index++;
        }
        return merge(sort(shorter), sort(longer));
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

        // Fill random array
        int[] a = new int[length];
        for (int i = 0;i < length;i++) {
            a[i] = (int) (entropy * Math.random());
        }

        long startTime = System.currentTimeMillis();
        int[] ret = MergeSort.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted random array of length " + length + " in " + (endTime - startTime) + " ms."); 
        System.out.print("Unsorted: ");
        for (int i : a) {
            System.out.print(Integer.toString(i) + " ");
        }
        System.out.println();
        System.out.print("Sorted:   ");
        for (int i : ret) {
            System.out.print(Integer.toString(i) + " ");
        }
        System.out.println();

    }
}
