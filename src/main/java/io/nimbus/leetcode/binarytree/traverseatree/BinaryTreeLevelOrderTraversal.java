package io.nimbus.leetcode.binarytree.traverseatree;

import io.nimbus.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
 */
public class BinaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // the intuition of this solution is that at any one time, the queue only contains the elements of
            // the current level. So get the size, set in stone, then process up to that point, i.e. up to that level.
            // then if there is another level repeat in the next iteration of the while loop.
            int levelSize = queue.size();
            List<Integer> levelData = new ArrayList<>();
            res.add(levelData);
            for (int i = 0; i < levelSize; i++) {
                TreeNode n = queue.poll();
                levelData.add(n.val);
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
        }

        return res;
    }


    public List<List<Integer>> levelOrder_level_queue(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        // The idea of the levelQueue was from https://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-java/
        // the intuition was to add a level queue as well. I got most of the algorithm correct
        // but couldn't think of how to retain the knowledge/"state" of the level. That should have been a  clue.
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        queue.offer(root);
        levelQueue.offer(1);

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            int level = levelQueue.poll();

            if (res.size() < level)
                res.add(new ArrayList<>());

            res.get(level - 1).add(n.val);
            if (n.left != null) {
                queue.offer(n.left);
                levelQueue.offer(level + 1);
            }
            if (n.right != null) {
                queue.offer(n.right);
                levelQueue.offer(level + 1);
            }
        }

        return res;
    }
}
