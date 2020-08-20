package io.nimbus.leetcode.binarytree.solvetreeproblemsrecursively;

import io.nimbus.leetcode.binarytree.TreeNode;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
 */
public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
