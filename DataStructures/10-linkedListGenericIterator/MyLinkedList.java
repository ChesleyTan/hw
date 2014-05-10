import java.util.*;
import java.io.*;
public class MyLinkedList<E> {
    private Node<E> head;  
    private Node<E> tail;

    public MyLinkedList() {
        head = new Node("Dummy");
        tail = head;
    }

    public void add(E s) {
        Node<E> tmp = new Node(s);
        tail.setNext(tmp);
        tail = tmp;
    }

    public void add(int i, E s) {
        int pos = 0;
        Node<E> tmp = head.getNext();
        while (pos < i - 1) {
            tmp = tmp.getNext();
            pos++;
        }
        Node<E> newNode = new Node(s);
        newNode.setNext(tmp.getNext());
        tmp.setNext(newNode);
    }

    public E get(int i) {
        int pos = 0;
        Node<E> tmp = head.getNext();
        while (pos < i) {
            tmp = tmp.getNext();
            pos++;
        }
        return tmp.getData();
    }

    public E set(int i, E s) {
        int pos = 0;
        Node<E> tmp = head.getNext();
        while (pos < i) {
            tmp = tmp.getNext();
            pos++;
        }
        E old = tmp.getData();
        tmp.setData(s);
        return old;
    }

    public E remove(int i) {
        int pos = 0;
        Node<E> tmp = head;
        while (pos < i) {
            tmp = tmp.getNext();
            pos++;
        }
        E old = tmp.getNext().getData();
        tmp.setNext(tmp.getNext().getNext());
        return old;
    }

    public int find(E s) {
        int pos = 0;
        Node<E> tmp = head.getNext();
        while (tmp != null) {
            if (tmp.getData().equals(s)) {
                return pos;
            }
            tmp = tmp.getNext();
            pos++;
        }
        return -1;
    }
    
    public int size() {
        int pos = 0;
        Node<E> tmp = head.getNext();
        while (tmp != null) {
            tmp = tmp.getNext();
            pos++;
        }
        return pos;
    }

    public String toString() {
        String retStr = "\n";
        Node<E> tmp = head.getNext();
        while (tmp != null) {
            retStr += tmp.toString() + "\n";
            tmp = tmp.getNext();
        }
        return retStr; 
    }

    public Iterator<E> iterator() {
        return new MyLLIterator(head);
    }

}
