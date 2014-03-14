import java.util.ArrayList;
public class MergeSortComparable {
    public static ArrayList<Comparable> merge(ArrayList<Comparable> a, ArrayList<Comparable> b) {
        int length_a = a.size();
        int length_b = b.size();
        ArrayList<Comparable> longer, shorter;
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
        ArrayList<Comparable> retArr = new ArrayList<Comparable>();
        int shorter_index = 0; // counter to iterate through shorter array
        int longer_index = 0; // counter to iterate through larger array
        while (shorter_index < length_shorter && longer_index < length_longer) { 
            if (shorter.get(shorter_index).compareTo(longer.get(longer_index)) > 0) {
                retArr.add(longer.get(longer_index));
                longer_index++;
            } 
            else {
                retArr.add(shorter.get(shorter_index));
                shorter_index++;
            }
        }
        // If the lists are not the same length, this
        // adds all the remaining elements of the list
        // to the retArr. This works for the case in
        // which the difference in lengths is not 1.
        if (longer_index != length_longer) {
            for (;longer_index < length_longer;longer_index++) {
                retArr.add(longer.get(longer_index));
            }
        }
        else if (shorter_index != length_shorter) {
            for (;shorter_index < length_shorter;shorter_index++) {
                retArr.add(shorter.get(shorter_index));
            }    
        }
        return retArr;
    }

    public static ArrayList<Comparable> sort(ArrayList<Comparable> a) {
        int length_a = a.size();
        if (length_a <= 1) {
            return a;
        }
        int length_longer = length_a / 2;
        int length_shorter = length_a / 2;
        if (length_a % 2 == 1) {
            length_longer += 1;
        }
        ArrayList<Comparable> longer = new ArrayList<Comparable>();
        ArrayList<Comparable> shorter = new ArrayList<Comparable>();
        int a_index = 0;
        int i = 0;
        while (i < length_longer) {
            longer.add(a.get(a_index));
            i++;
            a_index++;
        }
        i = 0;
        while (i < length_shorter) {
            shorter.add(a.get(a_index));
            i++;
            a_index++;
        }
        return merge(sort(shorter), sort(longer));
    }

    public static void main(String[] args) {
        int length = 10;
        int entropy = 20;
        int strLength = 10;
        if (args.length > 0) {
            try {
                length = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {
                System.err.print(e.getMessage());
            }
        }
        else {
            System.out.println("(!) No Array length argument provided. Using default length of " + length + ".");
        }
        if (args.length > 1) {
            try {
                strLength = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e) {
                System.err.print(e.getMessage());
            }
        }
        else {
            System.out.println("(!) No String length argument provided. Using default length of " + length + ".");
        }
        if (args.length > 2) {
            try {
                entropy = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException e) {
                System.err.print(e.getMessage());
            }
        }
        else {
            System.out.println("(!) No entropy argument provided. Using default entropy of " + entropy + ".");
        }
        if (entropy > 51) {
            System.out.println("(!) Entropy provided exceeded maximum value of 51. Using fallback value of 51.");
            entropy = 51;
        }

        /* Implementation with Strings
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Comparable> a = new ArrayList<Comparable>();
        for (int i = 0;i < length;i++) {
            String s = "";
            for (int u = 0;u < strLength;u++) {
                s += Character.toString(letters.charAt((int) (entropy * Math.random())));
            }
            a.add(s);
        }
        
        long startTime = System.currentTimeMillis();
        ArrayList<Comparable> ret = sort(a);
        long endTime = System.currentTimeMillis();
        System.out.print("Unsorted: ");
        System.out.println(a);
        System.out.println();
        System.out.print("Sorted:   ");
        System.out.println(ret);
        System.out.println();
        System.out.println("Sorted random array of length " + length + " in " + (endTime - startTime) + " ms."); 
        */

        /* Implementation with ints 
        ArrayList<Comparable> a = new ArrayList<Comparable>();
        for (int i = 0;i < length;i++) {
            a.add((int) (entropy * Math.random()));
        }

        long startTime = System.currentTimeMillis();
        ArrayList<Comparable> ret = sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted random array of length " + length + " in " + (endTime - startTime) + " ms."); 
        System.out.print("Unsorted: ");
        System.out.println(a);
        System.out.print("Sorted:   ");
        System.out.println(ret);
        */

        // Implementation with Person
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Comparable> a = new ArrayList<Comparable>();
        for (int i = 0;i < length;i++) {
            String name = "";
            int age = 0;
            for (int u = 0;u < strLength;u++) {
                name += Character.toString(letters.charAt((int) (entropy * Math.random())));
                age = (int) (entropy * Math.random());
            }
            a.add(new Person(name, age));
        }
        long startTime = System.currentTimeMillis();
        ArrayList<Comparable> ret = sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted random array of length " + length + " in " + (endTime - startTime) + " ms."); 
        System.out.print("Unsorted: ");
        System.out.println(a);
        System.out.println("\n\n\n\n\n\n\n");
        System.out.print("Sorted:   ");
        System.out.println(ret);
    }
}
