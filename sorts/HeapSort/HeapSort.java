public class HeapSort {
    public int[] sort(int[] a) {
        int endOfArray = a.length - 1;
        while (endOfArray > 1) { // first value of heap array is empty
            // swap highest value with the last value
            int tmp = a[endOfArray];
            a[endOfArray] = a[1];
            a[1] = tmp;
            // increase size of the sorted section of the array
            endOfArray--;
            siftDown(a, 1, endOfArray);
        }
        return a;
    }

    public void siftDown(int[] a, int node, int endOfArray) {
        while (node * 2 <= endOfArray) { // continue until the end of the heap
            int largerChild = node * 2;
            // locate the larger of two possible child nodes
            if (largerChild + 1 <= endOfArray && a[largerChild] < a[largerChild + 1]) {
                largerChild++;
            }
            // swap if child is larger
            if (a[node] < a[largerChild]) {
                int tmp = a[node];
                a[node] = a[largerChild];
                a[largerChild] = tmp;
                node = largerChild; // loop again starting at the new position
            }
            else {
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] heap = new int[] { Integer.MAX_VALUE, 100, 50, 30, 40, 45, 15, 10, 5, 1 }; // heap[0] is a trivial value
        heap = hs.sort(heap);
        for (int i = 1;i < heap.length; i++) {
            System.out.println(heap[i] + " ");
        }
    }
}
