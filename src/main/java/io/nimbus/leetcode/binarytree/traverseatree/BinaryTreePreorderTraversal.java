package io.nimbus.leetcode.binarytree.traverseatree;

import io.nimbus.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal_iterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode n = stack.pop();
                list.add(n.val);

                // pre-order IS visit-left-right BUT a stack is FILO so to process left first in the next
                // iteration of this while loop, we add the right in first to bury it at the bottom.
                if (n.right != null)
                    stack.push(n.right);
                if (n.left != null)
                    stack.push(n.left);
            }
        }

        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode n, List<Integer> list) {
        if (n == null)
            return;
        list.add(n.val);
        preorderTraversal(n.left, list);
        preorderTraversal(n.right, list);
    }

}
