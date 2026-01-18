package tree;

/**
 * Given a binary tree, the task is to find the maximum depth of the tree
 */
public class BinaryTreeUtility {

    public static void main(String[] args) {
        BinaryTreeUtility binaryTreeUtility = new BinaryTreeUtility();
        BinaryTree tree = binaryTreeUtility.buildTree();
        System.out.println(tree.height());

        BinaryTree tree2 = binaryTreeUtility.buildTree();
        System.out.println(binaryTreeUtility.isSymmetric(tree.root(), tree2.root()));
    }

    private BinaryTree buildTree() {
        BinaryTree.Node root = new BinaryTree.Node(1);
        BinaryTree.Node leftChild = new BinaryTree.Node(2);
        BinaryTree.Node rightChild = new BinaryTree.Node(3);
        BinaryTree.Node leftLeftChild = new BinaryTree.Node(4);
        BinaryTree.Node leftRightChild = new BinaryTree.Node(5);
        BinaryTree.Node leftLeftLeftChild = new BinaryTree.Node(6);
        root.left = leftChild;
        root.right = rightChild;
        leftChild.left = leftLeftChild;
        leftChild.right = leftRightChild;
        leftLeftChild.left = leftLeftLeftChild;
        return new BinaryTree(root);
    }

    private boolean isSymmetric(BinaryTree.Node root1, BinaryTree.Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        return root1.equals(root2) &&
                isSymmetric(root1.left, root2.left) &&
                isSymmetric(root1.right, root2.right);

    }

    private record BinaryTree(Node root) {
        public int height() {
            return height(root);
        }

        private int height(Node root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(height(root.left), height(root.right));
        }

        private static class Node {
            Node left = null, right = null;
            int data;

            Node(int data) {
                this.data = data;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Node node) {
                    return data == node.data;
                }
                return false;
            }
        }

    }
}
