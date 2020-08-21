package io.nimbus.leetcode.binarytree.conclusion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/1016/
 */
public class PopulatingNextRightPointersInEachNode2 {

    // previous solution for PopulatingNextRightPointersInEachNode was nearly identical barring the if (n.right != null)
    // check
    public Node connect(Node root) {

        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int currentLevelSize = queue.size();
            Node previous = null;
            for (int i = 0; i < currentLevelSize; i++) {

                Node n = queue.remove();
                if (previous != null) {
                    previous.next = n;
                }
                previous = n;

                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
            }
        }

        return root;
    }


    // happy that I remembered that BFS uses a queue. and the trick to remember the level is the state of the queue at
    // each iteration. But the time complexity can be improved.
    public Node connect_works(Node root) {

        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int currentLevelSize = queue.size();
            List<Node> nodesOfLevel = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {

                Node n = queue.poll();
                nodesOfLevel.add(n);
                if (n.left != null)
                    queue.offer(n.left);
                if (n.right != null)
                    queue.offer(n.right);
            }

            for (int i = 1; i < nodesOfLevel.size(); i++) {
                Node node = nodesOfLevel.get(i - 1);
                node.next = nodesOfLevel.get(i);
            }
        }

        return root;
    }

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

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        System.out.println(new PopulatingNextRightPointersInEachNode2().connect(n1));
    }


}
