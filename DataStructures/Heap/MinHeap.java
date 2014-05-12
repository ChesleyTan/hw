import java.util.ArrayList;
public class MinHeap {
    private ArrayList<Integer> heap;
    
    public MinHeap() {
        heap = new ArrayList<Integer>();
        heap.add(Integer.MAX_VALUE);
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
        while (n > 1 && heap.get(parent) > thisNode) {
            heap.set(n, heap.set(parent, thisNode));
            n = parent;
            parent = parent / 2;
        }
    }

    private void siftDown(int n) {
        while (n * 2 <= heap.size() - 1) { // continue until the end of the heap
            int smallerChild = n * 2;
            // locate the smaller of two possible child nodes
            if (smallerChild + 1 <= heap.size() - 1 && heap.get(smallerChild) > heap.get(smallerChild + 1)) {
                smallerChild++;
            }
            // swap if child is smaller
            if (heap.get(n) > heap.get(smallerChild)) {
                heap.set(n, heap.set(smallerChild, heap.get(n)));
                n = smallerChild; // loop again starting at the new position
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
        MinHeap mh = new MinHeap();
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
