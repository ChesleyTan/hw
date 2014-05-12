public class DoubleLL<E> {
    
    private class Node<E> {
        E data;
        Node<E> next,prev;
        public Node(E d) {
            this.data = d;
        }
        public String toString() {
            return ""+data;
        }
        public void setData(E d) {
            data = d;
        }
        public E getData() {
            return data;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setPrev(Node<E> p) {
            prev = p;
        }
        public Node<E> getPrev() {
            return prev;
        }
    }

        private Node<E> current;
        private Node<E> head;

        public void insert(E d) {
            Node<E> n = new Node<E>(d);
            if (current == null) {
                current = n;
                head = n;
                current.setPrev(n);
                current.setNext(n);
            }
            else {
                n.setPrev(current);
                n.setNext(current.getNext());
                current.setNext(n);
                current = n;
            }
        }

        public E getCurrent() {
            return current.getData();
        }

        public void forward() {
            if (current.getNext() != null) {
                current = current.getNext();
            }
        }

        public void back() {
            if (current.getPrev() != null) {
                current = current.getPrev();
            }
        }

        public String toString() {
            if (current == null) {
                return "";
            }
            String s = head.getData().toString();
            Node<E> tmp = head.getNext();
            while (tmp != head) {
                s += tmp.getData();
                tmp = tmp.getNext();
            }
            return s;
        }

        public E remove() {
            E data = current.getData();
            if (current.getNext() == current.getPrev()) {
                current.setNext(null);
                current.setPrev(null);
                current = null;
                return data;
            }
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());
            current = current.getNext();
            return data;
        }

        public void find(E data) {
            if (current == null) {
                return;
            }
            Node<E> tmp = head.getNext();
            while (tmp != head) {
                if (tmp.getData().equals(data)) {
                    current = tmp;
                }
                tmp = tmp.getNext();
            }
        }

        public static void main(String[] args) {
            DoubleLL<String> L = new DoubleLL<String>();
            System.out.println(L);
            System.out.println("Adding 'hello'...");
            L.insert("hello");
            System.out.println(L);
            System.out.println("Adding 'world'...");
            L.insert("world");
            System.out.println(L);
            System.out.println("Adding 'three'...");
            L.insert("three");
            System.out.println(L);

            System.out.println("Current: " + L.getCurrent());
            System.out.println("Moving forward 1...");
            L.forward();
            System.out.println("Current: " + L.getCurrent());
            System.out.println("Adding 'inserted'...");
            L.insert("inserted");
            System.out.println(L);
            System.out.println("Finding 'inserted'...");
            L.find("inserted");
            System.out.println("Current: " + L.getCurrent());
            System.out.println("Removing current");
            L.remove();
            System.out.println(L);
        }
}
