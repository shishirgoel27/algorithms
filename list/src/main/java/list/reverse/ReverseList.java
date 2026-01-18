package list.reverse;

import java.util.List;

public class ReverseList {

    public static class Node {
        private final int data;
        private Node next;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node reverseList(Node root) {
        if(root==null || root.next == null) {
            return root;
        }
        Node reverseListHead = reverseList(root.next);
        root.next.next = root;
        root.next = null;
        return reverseListHead;
    }

    public Node iterativeReverse(Node root) {
        Node current = root, prev = null, next;
        while(current != null) {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
        }
        return prev;
    }

    public Node buildList(List<Integer> values) {
        Node root = new Node(values.getFirst(), null);
        var subValues = values.subList(1, values.size());
        return subValues.stream()
                .map(value -> new Node(value, null))
                .reduce(root, (a, b) -> {
                    Node current = a;
                    while(current.next != null) {
                        current = current.next;
                    }
                    current.next = b;
                    return a;
                });
    }

    public void printList(Node root) {
        Node current = root;
        while(current != null) {
            System.out.print(current.data+"-->");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ReverseList rl = new ReverseList();
        Node node = rl.buildList(List.of(1,2,3,4));
        rl.printList(node);
        System.out.println("\n-----------------------------");
//        node = rl.reverseList(node);
        node = rl.iterativeReverse(node);
        rl.printList(node);
    }
}
