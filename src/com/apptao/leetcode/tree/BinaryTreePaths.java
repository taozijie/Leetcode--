package com.apptao.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个算法，得出二叉树所有根节点到叶子节点的路径
 * Created by a on 2017-12-28.
 * <p>
 * 例如：
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * 结果:
 * <p>
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 创建一棵二叉树
     * <pre>
     *          1
     *     2         3
     *  4    5            6
     *  </pre>
     */
    public TreeNode createBinTree() {
        TreeNode root = new TreeNode(1);
        TreeNode newNode2 = new TreeNode(2);
        TreeNode newNode3 = new TreeNode(3);
        TreeNode newNode4 = new TreeNode(4);
        TreeNode newNode5 = new TreeNode(5);
        TreeNode newNode6 = new TreeNode(6);
        root.leftChild = newNode2;
        root.rightChild = newNode3;
        root.leftChild.leftChild = newNode4;
        root.leftChild.rightChild = newNode5;
        root.rightChild.rightChild = newNode6;
        return root;
    }

    public static void main(String[] args) {

        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();

        List<String> strings = binaryTreePaths.binaryTreePaths(binaryTreePaths.createBinTree());

        System.out.println(strings.toString());
    }

    /**
     * 接收数据进行处理，求二叉树的路径
     * @param root TreeNode
     * @return list
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        new BinaryTreePaths().inorder(root, result, "");
        return result;
    }

    /**
     * 递归路径，添加到list
     * @param node TreeNode
     * @param list List<String>
     * @param path String
     */
    private void inorder(TreeNode node, List<String> list, String path) {
        if (node != null) {
            if (node.leftChild == null && node.rightChild == null) {
                list.add(path + node.val);
            } else {
                inorder(node.leftChild, list, path + node.val + "->");
                inorder(node.rightChild, list, path + node.val + "->");
            }
        }
    }


}
