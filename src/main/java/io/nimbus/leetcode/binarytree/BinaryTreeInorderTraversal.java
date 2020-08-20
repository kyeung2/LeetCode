package io.nimbus.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode n = root;
            while (!stack.isEmpty() || n != null) {
                if (n != null) {
                    stack.push(n);
                    n = n.left;
                }
                // this else block gets executed when there are "no more lefts"
                else {
                    // the node you are popping is the left, so left-visit-right
                    var c = stack.pop();
                    list.add(c.val);
                    n = c.right;
                }
            }
        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode n, List<Integer> list) {
        if (n == null)
            return;
        inorderTraversal(n.left, list);
        list.add(n.val);
        inorderTraversal(n.right, list);
    }

}
