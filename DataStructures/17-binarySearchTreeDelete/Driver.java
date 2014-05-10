public class Driver {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(8);
        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(9);
        bst.insert(10);
        bst.insert(1);
        System.out.println(bst.search(1));
        bst.delete(1);
        System.out.println(bst.search(1));
        System.out.println(bst.search(8));
        bst.delete(8);
        System.out.println(bst.search(8));
        System.out.println(bst.search(6));
        System.out.println(bst.search(4));
        System.out.println(bst.search(3));
        System.out.println(bst.search(9));
        System.out.println(bst.search(10));
    }
}
