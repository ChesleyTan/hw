import java.util.ArrayList;
public class MaxHeap {
    private ArrayList<Integer> heap;
    
    public MaxHeap() {
        heap = new ArrayList<Integer>();
        heap.add(Integer.MIN_VALUE);
    }
    
    public int get() {
        return heap.get(1);
    }

    public void insert(int n) {
        heap.add(n);
        siftUp(heap.size() - 1);
    }

    private void siftUp(int n) {
        int parent = n / 2;
        int thisNode = heap.get(n);
        while (n > 1 && heap.get(parent) < thisNode) {
            heap.set(n, heap.set(parent, thisNode));
            n = parent;
            parent = parent / 2;
        }
    }

    private void siftDown(int n) {
        while (n * 2 <= heap.size() - 1) { // continue until the end of the heap
            int largerChild = n * 2;
            // locate the larger of two possible child nodes
            if (largerChild + 1 <= heap.size() - 1 && heap.get(largerChild) < heap.get(largerChild + 1)) {
                largerChild++;
            }
            // swap if child is larger
            if (heap.get(n) < heap.get(largerChild)) {
                heap.set(n, heap.set(largerChild, heap.get(n)));
                n = largerChild; // loop again starting at the new position
            }
            else {
                return;
            }
        }

    }

    public int remove() {
        int ret = heap.get(1);
        if (heap.size() > 2) {
            heap.set(1, heap.remove(heap.size() - 1));
        }
        else {
            heap.remove(1);
        }
        siftDown(1);
        return ret;
    }

    public int size() {
        return heap.size() - 1;
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        mh.insert(10);
        mh.insert(40);
        mh.insert(50000);
        mh.insert(5);
        System.out.println(mh.remove());
        System.out.println(mh.remove());
        System.out.println(mh.remove());
        System.out.println(mh.remove());
    }
}
