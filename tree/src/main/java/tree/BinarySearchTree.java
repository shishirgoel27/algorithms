package tree;

public class BinarySearchTree {

    private static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    void insert(int[] input) {
        for (int j : input) {
            Node newNode = new Node(j);
            if (root == null) {
                root = newNode;
            } else {
                Node current = root, parent = null;
                while (current != null) {
                    parent = current;
                    if (current.data < j) {
                        current = current.right;
                    } else {
                        current = current.left;
                    }
                }
                if (parent.data < j) {
                    parent.right = newNode;
                } else {
                    parent.left = newNode;
                }
            }
        }
    }

    void print() {
        inorder(root);
    }

    void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(new int[]{6,4,9,5,3,2,7,1});
        bst.print();
    }
}
