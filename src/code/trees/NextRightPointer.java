package code.trees;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointer {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;
        NextRightPointer nrp = new NextRightPointer();
        nrp.connect(root);
        System.out.println(node2.right.val);
        System.out.println(node3.right.val);


    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (i == size - 1) {
                    temp.next = null;
                } else {
                    temp.next = q.peek();
                }
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);

            }
        }
        return root;
    }


}
