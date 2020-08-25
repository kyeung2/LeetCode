package io.nimbus.leetcode.queueandstack.stackanddfs;


import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
 */
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return clone_recurse(node, new HashMap<>());
    }

    // recursive, call-stack implementation.
    public Node clone_recurse(Node n, Map<Integer, Node> cloned) {

        if (cloned.containsKey(n.val))
            return cloned.get(n.val);

        Node clone = new Node(n.val);
        cloned.put(clone.val, clone);

        for (Node neighbor : n.neighbors) {
            clone.neighbors.add(clone_recurse(neighbor, cloned));
        }

        return clone;
    }


    // my first attempt. works but a little all over the place.
    // the need to have the Set<Integer> visited is ugly.
    public Node cloneGraph_stack(Node node) {

        if (node == null)
            return null;

        // using a stack rather than the call stack using recursion.
        Deque<Node> stack = new ArrayDeque<>();
        Map<Integer, Node> cloned = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            visited.add(n.val);
            Node clone = clone_single(n, cloned);

            for (Node neighbor : n.neighbors) {
                clone.neighbors.add(clone_single(neighbor, cloned));

                if (!visited.contains(neighbor.val))
                    stack.push(neighbor);
            }
        }

        return cloned.get(node.val);
    }

    public Node clone_single(Node n, Map<Integer, Node> cloned) {

        if (cloned.containsKey(n.val))
            return cloned.get(n.val);

        Node clone = new Node(n.val);
        cloned.put(clone.val, clone);
        return clone;
    }
}
