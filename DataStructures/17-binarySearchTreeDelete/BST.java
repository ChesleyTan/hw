public class BST {
    private Node root;

    public Node search(int x) {
        Node tmp = root;
        while (tmp != null && tmp.getData() != x) {
            if (tmp.getData() < x) {
                tmp = tmp.getLeft();
            }
            else {
                tmp = tmp.getRight();
            }
        }
        return tmp;
    }

    public Node search2(int x) {
        return search2(root, x);
    }
    public Node search2(Node c, int x) {
        if (c == null || c.getData() == x) {
            return c;
        }
        if (c.getData() < x) {
            return search2(c.getLeft(), x);
        }
        else {
            return search2(c.getRight(), x);
        }
    }

    public void insert(int x) {
        Node newNode = new Node(x);
        if (root == null) {
            root = newNode;
            return;
        }
        Node prev = null;
        Node curr = root;
        while (curr != null) {
            prev = curr;
            if (curr.getData() < x) {
                curr = curr.getLeft();
            }
            else {
                curr = curr.getRight();
            }
        }
        if (prev.getData() < x) {
            prev.setLeft(newNode);
        }
        else {
            prev.setRight(newNode);
        }
    }

    public Node delete(int x) {
        Node tmp = root;
        Node prev = null;
        while (tmp != null && tmp.getData() != x) {
            if (tmp.getData() < x) {
                prev = tmp;
                tmp = tmp.getLeft();
            }
            else {
                prev = tmp;
                tmp = tmp.getRight();
            }
        }
        if (tmp == null) {
            return null;
        }
        int countChildren = 0;
        if (tmp.getLeft() != null) {
            countChildren++;
        }
        if (tmp.getRight() != null) {
            countChildren++;
        }
        if (countChildren <= 1) {
            if (prev.getLeft() == tmp) {
                if (tmp.getLeft() != null) {
                    prev.setLeft(tmp.getLeft());
                }
                else {
                    prev.setLeft(tmp.getRight());
                }
            }
            else {
                if (tmp.getLeft() != null) {
                    prev.setRight(tmp.getLeft());
                }
                else {
                    prev.setRight(tmp.getRight());
                }
            }
        }
        if (countChildren == 2) {
            Node greatestOnLeft = tmp.getLeft();
            Node tmpLeft = tmp.getLeft();
            Node tmpRight = null;
            while (tmpLeft.getLeft() != null && tmpLeft.getRight() == null) {
                tmpLeft = tmpLeft.getLeft();
            }
            if (tmpLeft.getRight() != null) {
                tmpRight = tmpLeft.getRight();
                while (tmpRight.getRight() != null) {
                    tmpRight = tmpRight.getRight();
                }
                greatestOnLeft = tmpRight;
            }
            Node tmp2 = new Node(greatestOnLeft.getData());
            delete(greatestOnLeft.getData());
            tmp2.setLeft(tmp.getLeft());
            tmp2.setRight(tmp.getRight());
            if (prev == null) { // Special case: deleting root
                root = tmp2;
                return tmp;
            }
            if (prev.getLeft() == tmp) {
                prev.setLeft(tmp2);
            }
            else {
                prev.setRight(tmp2);
            }
        }
        return tmp;
    }
}
