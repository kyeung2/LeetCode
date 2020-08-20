package io.nimbus.leetcode.binarytree.solvetreeproblemsrecursively;

import io.nimbus.leetcode.binarytree.TreeNode;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 */
public class SymmetricTree {



    // didn't get this on my own at all. the intuition here is that is 2 trees a mirror of each other.
    // very pretty algorithm.
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
