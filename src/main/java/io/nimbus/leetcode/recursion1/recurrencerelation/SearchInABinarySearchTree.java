package io.nimbus.leetcode.recursion1.recurrencerelation;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/
 */
public class SearchInABinarySearchTree {


    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    // this was incredibly easy. Is it that some are harder than other by that much or
    // do I get stuck for other reasons?
    public TreeNode searchBST(TreeNode n, int val) {

        if (n == null) return null;
        if (n.val == val) return n;

        return searchBST(val < n.val ? n.left : n.right, val);
    }


    public static void main(String[] args) {

        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n4.left = n2;
        n4.right = n7;
        n2.left = n1;
        n2.right = n3;


        System.out.println(new SearchInABinarySearchTree().searchBST(n4, 2));
    }

}
