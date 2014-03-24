public class MyLinkedList {
    private Node head;  
    private Node tail;

    public MyLinkedList() {
        head = new Node("Dummy");
        tail = head;
    }

    public void add(String s) {
        Node tmp = new Node(s);
        tail.setNext(tmp);
        tail = tmp;
    }

    public void add(int i, String s) {
        int pos = 0;
        Node tmp = head.getNext();
        while (pos < i - 1) {
            tmp = tmp.getNext();
            pos++;
        }
        Node newNode = new Node(s);
        newNode.setNext(tmp.getNext());
        tmp.setNext(newNode);
    }

    public String get(int i) {
        int pos = 0;
        Node tmp = head.getNext();
        while (pos < i) {
            tmp = tmp.getNext();
            pos++;
        }
        return tmp.getData();
    }

    public String set(int i, String s) {
        int pos = 0;
        Node tmp = head.getNext();
        while (pos < i) {
            tmp = tmp.getNext();
            pos++;
        }
        String old = tmp.getData();
        tmp.setData(s);
        return old;
    }

    public String remove(int i) {
        int pos = 0;
        Node tmp = head;
        while (pos < i) {
            tmp = tmp.getNext();
            pos++;
        }
        String old = tmp.getNext().getData();
        tmp.setNext(tmp.getNext().getNext());
        return old;
    }

    public int find(String s) {
        int pos = 0;
        Node tmp = head.getNext();
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
        Node tmp = head.getNext();
        while (tmp != null) {
            tmp = tmp.getNext();
            pos++;
        }
        return pos;
    }

    public String toString() {
        String retStr = "\n";
        Node tmp = head.getNext();
        while (tmp != null) {
            retStr += tmp + "\n";
            tmp = tmp.getNext();
        }
        return retStr; 
    }

}
