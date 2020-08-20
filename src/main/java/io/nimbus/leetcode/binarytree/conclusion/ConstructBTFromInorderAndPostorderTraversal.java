package io.nimbus.leetcode.binarytree.conclusion;

import io.nimbus.leetcode.binarytree.TreeNode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
 * <p>
 * inorder: is the BST order
 * postorder: last is always the root
 */
public class ConstructBTFromInorderAndPostorderTraversal {

    // no where close to this one. Got the basic idea from a sight and still got the implementation wrong and had to take
    // solution from https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/discuss/758391/2-Solution-or-Detailed-Explanation-and-Code
    // did less new array creation and copying by clever use of 3 pointers. I understand but getting the solution solo
    // is above my level at the moment.
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTreeFromInPost(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode constructTreeFromInPost(int[] inorder, int[] postorder, int start, int end, int postRootIndex) {
        if (start > end) return null;

        int rootValue = postorder[postRootIndex];
        TreeNode root = new TreeNode(rootValue);

        int inRootIndex = start;
        while(rootValue != inorder[inRootIndex]) inRootIndex++;


        // postorder  [left tree][right tree][root], therefore [right tree] =  [left-tree-R][right-tree-R][root-R], i.e. root-R == index-1
        root.right = constructTreeFromInPost(inorder, postorder, inRootIndex + 1, end, postRootIndex - 1);
        root.left = constructTreeFromInPost(inorder, postorder, start, inRootIndex - 1, postRootIndex - (end - inRootIndex) - 1);

        return root;
    }


    // took the idea from an explanation i found but it turns out my implementation doesn't work anyway for all the test
    // cases. Due to a lack of error output difficult to know why it's going wrong so giving up.
    public  static TreeNode buildTree_my_attempt(int[] inorder, int[] postorder) {

        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        if (postorder.length > 1) {
            int[][] splits = splitOn(inorder, rootValue);
            int[] leftInorder = splits[0];
            int[] rightInorder = splits[1];
            int[] leftPostorder = getPostorder(leftInorder, postorder);
            int[] rightPostorder = getPostorder(rightInorder, postorder);

            root.left = buildTree_my_attempt(leftInorder, leftPostorder);
            root.right = buildTree_my_attempt(rightInorder, rightPostorder);
        }

        return root;
    }

    public static int[][] splitOn(int[] inorder, int value) {

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value) {
                int[] leftInorder = new int[i];
                int rightLength = inorder.length - (i + 1);
                int[] rightInorder = new int[rightLength];
                System.arraycopy(inorder, 0, leftInorder, 0, i);
                System.arraycopy(inorder, i + 1, rightInorder, 0, rightLength);

                return new int[][]{leftInorder, rightInorder};
            }
        }

        throw new IllegalStateException("couldn't find the specified value");
    }


    public static int[] getPostorder(int[] subset, int[] postorder) {

        Set<Integer> unique = Arrays.stream(subset).boxed().collect(Collectors.toSet());
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < postorder.length; i++) {

            if (startIndex == -1) {
                if (unique.contains(postorder[i])) {
                    startIndex = i;
                }
            } else if (!unique.contains(postorder[i])) {
                endIndex = i - 1;
                break;
            }
        }

        int size = endIndex - startIndex + 1;
        int[] res = new int[size];

        System.arraycopy(postorder, startIndex, res, 0, size);
        return res;
    }


    public static void main(String[] args) {

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};


        TreeNode treeNode = new ConstructBTFromInorderAndPostorderTraversal().buildTree(inorder, postorder);

        System.out.println(treeNode);
    }


}
