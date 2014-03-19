public class LLDriver {
    public static void main(String[] args) {
        MyLinkedList L = new MyLinkedList();
        System.out.println("Adding four nodes...");
        L.add("Sully");
        L.add("Mike");
        L.add("Randall");
        L.add("Boo");
        System.out.println(L);
        System.out.println();
        System.out.println("Adding new node at 1...");
        L.add(1, "New Node");
        System.out.println(L);
        System.out.println("Adding another new node at 3...");
        L.add(3, "Another New Node");
        System.out.println(L);
        System.out.println();
        System.out.println("Node at index 3: " + L.get(3));
        System.out.println();
        System.out.println("Replacing index 3 with a replacement node");
        L.set(3, "A Replacement Node");
        System.out.println(L);
        System.out.println();
        System.out.println("Removing node at 3...");
        L.remove(3);
        System.out.println(L);
        System.out.println();
        System.out.println("Finding " + L.get(3) + " : " + L.find(L.get(3))); 
        System.out.println();
        System.out.println("Total length of linked list: " + L.length());
    }
}
