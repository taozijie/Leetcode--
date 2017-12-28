package com.apptao.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by a on 2017-12-28.
 *
 * 给定一个二叉树，假设你站在右侧，打印出你能看到的路径内的节点。
 * 右侧节点
 * * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 *       /
  *     6
 * return [1, 3, 4].
 */
public class BinaryTreeRightSideView {

    private int maxHeigh = Integer.MIN_VALUE;
    List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {

        BinaryTreeRightSideView averageOfLevelsInBinaryTree = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.leftChild = node1;
        root.rightChild = node2;
        root.leftChild.rightChild = node3;
        root.rightChild.rightChild = node4;
        root.rightChild.rightChild.leftChild = node6;
//        root.rightChild.rightChild.rightChild = node7;


        List<Integer> integers = averageOfLevelsInBinaryTree.rightSideView(root);

        System.out.println(integers.toString());

        List<Integer> integers1 = averageOfLevelsInBinaryTree.rightSideViewWihle(root);

        System.out.println(integers1.toString());


    }




    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return list;
        dfs(root, 0);
        return list;
    }


    /**
     * 方案一：递归，
     *
     * @param node
     * @param height
     */
    private void dfs(TreeNode node, int height) {
        if (node != null) {
            if (height > maxHeigh) {
                list.add(node.val);
                maxHeigh = height;
            }
            dfs(node.rightChild, height + 1);
            dfs(node.leftChild, height + 1);
        }
    }

    public List<Integer> rightSideViewWihle(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();

            if (node == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                // add the rightest to the answer
                if (queue.peek() == null) {
                    ans.add(node.val);
                }

                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }
            }
        }

        return ans;
    }

}
