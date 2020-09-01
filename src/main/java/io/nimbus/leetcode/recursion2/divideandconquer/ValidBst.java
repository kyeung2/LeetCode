package io.nimbus.leetcode.recursion2.divideandconquer;

import io.nimbus.leetcode.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/
 */
public class ValidBst {


    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        // base case
        if (node == null) return true;

        // validate current against the limits, NOT just the immediate children.
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        // divide
        if (!helper(node.left, lower, val)) return false;
        return helper(node.right, val, upper);
    }

    static class InorderDfs {
        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            double value = -Double.MAX_VALUE;

            TreeNode current = root;
            //left-visit-right
            while (!stack.isEmpty() || current != null) {

                // left
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                // visit
                current = stack.pop();
                if (current.val <= value) return false;

                // record for next iteration
                value = current.val;
                // right
                current = current.right;
            }
            return true;
        }

    }

    static class Naive {

        // my solution doesn't work. It is naive in that it looks only locally at the
        // immediate left and right children.
        public boolean isValidBST(TreeNode root) {

            // base case
            if (root == null || (root.left == null && root.right == null))
                return true;

            // valid current node.
            if (root.left != null && root.left.val >= root.val)
                return false;
            if (root.right != null && root.right.val <= root.val)
                return false;

            // divide
            boolean leftValid = isValidBST(root.left);
            boolean rightValid = isValidBST(root.right);

            // conquer
            return leftValid && rightValid;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(1);
        root.left = l;

        ValidBst v = new ValidBst();

        System.out.println(v.isValidBST(root));

    }
}
