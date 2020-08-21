package io.nimbus.leetcode.binarytree.conclusion;

import io.nimbus.leetcode.binarytree.TreeNode;

import java.util.*;

import static java.util.stream.Collectors.joining;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
 */
public class SerializeAndDeserializeBT {

    // similar to a method used by another user.
    public String serialize(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dftValues(root, values);
        return values.stream().map(x -> x == null ? "N" : x.toString()).collect(joining(","));
    }

    private void dftValues(TreeNode node, List<Integer> values) {
        if (node == null) {
            values.add(null);
        } else {
            values.add(node.val);
            dftValues(node.left, values);
            dftValues(node.right, values);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if (val.equals("N")) return null;
        else {
            TreeNode n = new TreeNode(Integer.parseInt(val));
            n.left = buildTree(nodes);
            n.right = buildTree(nodes);
            return n;
        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;


        SerializeAndDeserializeBT x = new SerializeAndDeserializeBT();
        String serialize = x.serialize(n3);
        TreeNode deserialize = x.deserialize(serialize);
        System.out.println(serialize);
        System.out.println(deserialize);
    }


}
