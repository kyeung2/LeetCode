package io.nimbus.leetcode.binarytree.conclusion;

import io.nimbus.leetcode.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
 * <p>
 * inorder: is the BST order
 * postorder: last is always the root
 */
public class ConstructBTFromPreorderAndInorderTraversal {

    // I got this on my own, by using the logic from the ConstructBTFromInorderAndPostorderTraversal solution. The insight
    // or algorithm is nearly identical but rather than using a post order, where the root is always at the end. the
    // preorder means that the root is always in front.

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderValueToIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inorderValueToIndexMap.put(inorder[i], i);

        return constructTreeFromInPost(inorderValueToIndexMap, preorder, 0, inorder.length - 1, 0);
    }

    private TreeNode constructTreeFromInPost(Map<Integer, Integer> inorderValueToIndexMap, int[] preorder, int start, int end, int preRootIndex) {
        if (start > end) return null;

        int rootValue = preorder[preRootIndex];
        TreeNode root = new TreeNode(rootValue);
        int inRootIndex = inorderValueToIndexMap.get(rootValue);

        // preorder  [root][left][right], therefore
        // [left] =  [root-L][left-L][right-L], i.e. root-L == root + 1
        // [right] =  [left][root-R][left-R][right-R], i.e. root-R == (left).length + 1
        root.right = constructTreeFromInPost(inorderValueToIndexMap, preorder, inRootIndex + 1, end, preRootIndex + (inRootIndex - start) + 1);
        root.left = constructTreeFromInPost(inorderValueToIndexMap, preorder, start, inRootIndex - 1, preRootIndex + 1);

        return root;
    }

    public static void main(String[] args) {

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode treeNode = new ConstructBTFromPreorderAndInorderTraversal().buildTree(preorder, inorder);

        System.out.println(treeNode);
    }


}
