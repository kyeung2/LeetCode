package io.nimbus.leetcode.binarytree.conclusion;

import io.nimbus.leetcode.binarytree.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/
 */
public class LowestCommonAncestorOfABT {


    // didn't get this solution on my own. The intuition is to create a map of child-parent while searching for
    // p and q. once found, you can create a set of all ancestors of p, then look for the first common from q.
    // this was the most intuitive for me. I didn't think to create the map. I thought to find p and q using DFS
    // but didn't know how to traverse back up. the map was the key to this solution.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }

    public static void main(String[] args) {


        System.out.println(new LowestCommonAncestorOfABT());
    }


}
