package io.nimbus.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
 */
public class BinaryTreePostorderTraversal {

    // didn't get this on my own. Found on https://kkjavatutorials.com/postorder-traversal-of-binary-tree-implementation-in-java/
    // the algorithm is difficult to follow.
    public List<Integer> postorderTraversal_iterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode previous = null;
            while (!stack.isEmpty()) {
                TreeNode current = stack.peek();
                if (previous == null || previous.left == current || previous.right == current) {
                 		/*traverse from top to bottom and if
				 curr has left child or right child then
				 push into the stack otherwise pop out*/
                    if (current.left != null)
                        stack.push(current.left);
                    else if (current.right != null)
                        stack.push(current.right);
                } else if (current.left == previous) {
                    if (current.right != null)
                        stack.push(current.right);
                } else {
                    stack.pop();
                    list.add(current.val);
                }
                previous = current;
            }
        }

        return list;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode n, List<Integer> list) {
        if (n == null)
            return;
        postorderTraversal(n.left, list);
        postorderTraversal(n.right, list);
        list.add(n.val);
    }

}
