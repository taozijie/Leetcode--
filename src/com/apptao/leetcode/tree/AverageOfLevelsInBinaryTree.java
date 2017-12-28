package com.apptao.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by a on 2017-12-28.
 *
 * 给出一个二叉树，求出每一层的 数据和 平均数，
 * 例如：
 * Input:
 3
 / \
 9  20
 /  \
 15   7
 Output: [3, 14.5, 11]
 第一层级 为 3/1=3
 第二层级 为 29/2=14.5
 第三层级 为 22/2=11
 *
 *
 * 构建TreeNode  com.apptao.leetcode.tree.TreeNode;
 */
public class AverageOfLevelsInBinaryTree {

    /**
     * 统计同一层级的节点。
     */
    class LevelNode {
        int level;
        TreeNode node;
        LevelNode(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }

    public static void main(String[] args) {

        AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = new AverageOfLevelsInBinaryTree();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.rightChild = node1;
        root.leftChild = node2;
        root.rightChild.leftChild = node3;
        root.leftChild.rightChild = node4;


        List<Double> doubles = averageOfLevelsInBinaryTree.averageOfLevels(root);

        System.out.println(doubles.toString());


    }


    /**
     * 主要算法，隊列存取。
     * @param root treeNode
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<LevelNode> queue = new ArrayDeque<>();
        LevelNode node = new LevelNode(0, root);
        queue.offer(node);
        int curLevel = 0, count = 0;
        long sum = 0L;
        List<Double> result = new ArrayList<>();
        while(!queue.isEmpty()){
            LevelNode first = queue.poll();
            if(first.level == curLevel){
                sum += first.node.val;
                count++;
            } else{
                result.add((double)sum/count);
                sum = first.node.val;
                count = 1;
                curLevel++;
            }
            if(first.node.leftChild != null){
                queue.offer(new LevelNode(curLevel + 1, first.node.leftChild));
            } if(first.node.rightChild != null){
                queue.offer(new LevelNode(curLevel + 1, first.node.rightChild));
            }
        }
        result.add((double)sum/count);
        return result;
    }




}
