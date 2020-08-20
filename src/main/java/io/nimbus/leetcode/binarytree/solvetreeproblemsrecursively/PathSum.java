package io.nimbus.leetcode.binarytree.solvetreeproblemsrecursively;

import io.nimbus.leetcode.binarytree.TreeNode;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
 */
public class PathSum {

    // pretty proud of this one, took a couple of goes but intuitively understood the algorithm.
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return hasPathSum(root, sum, root.val);
    }

    private boolean hasPathSum(TreeNode n, int sum, int accumulator) {

        if (n.left == null && n.right == null) {
            return sum == accumulator;
        }
        return (n.left != null && hasPathSum(n.left, sum, accumulator + n.left.val)) ||
                (n.right != null && hasPathSum(n.right, sum, accumulator + n.right.val));
    }
}
