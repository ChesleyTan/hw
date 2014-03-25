import java.util.*;
import java.io.*;
public class MyLLIterator<E> implements Iterator<E> {
    private Node<E> currentNode;
    public MyLLIterator(Node<E> n) {
        currentNode = n;
    }
    public boolean hasNext() {
        return (currentNode.getNext() != null);
    }
    public E next() {
        currentNode = currentNode.getNext();
        return currentNode.getData();
    }
    public void remove() {
    
    }
}
