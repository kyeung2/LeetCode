package io.nimbus.leetcode.recursion1.conclusion;

import io.nimbus.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2384/
 */
public class UniqueBst2 {

    // had no idea how to do this one. in discussion section.

    // more reading, without prior knowledge of these techniques, very hard.
    // https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
    // https://www.geeksforgeeks.org/program-nth-catalan-number/
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return recurse(1, n);
    }

    private List<TreeNode> recurse(int lo, int hi) {
        List<TreeNode> ret = new ArrayList<>();
        if(lo > hi) {
            ret.add(null);
            return ret;
        }
        for(int i = lo; i <= hi; ++i) {

            for(TreeNode l : recurse(lo, i-1)) {
                for(TreeNode r : recurse(i+1, hi)) {
                    ret.add(new TreeNode(i, l, r));
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {

        UniqueBst2 uniqueBst2 = new UniqueBst2();
        System.out.println(uniqueBst2.generateTrees(1));
        System.out.println(uniqueBst2.generateTrees(2));
    }


}

