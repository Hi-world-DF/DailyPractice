package src.leetCode.AlgorithmIdea.DataStructure.Tree.Recursive;

import src.swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * 题目描述：二叉树中第二小的节点
 * */

public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        if(root.left == null && root.right == null) return -1;
        int lv = root.left.value;
        int rv = root.right.value;
        if(lv == root.value) lv = findSecondMinimumValue(root.left);
        if(rv == root.value) rv = findSecondMinimumValue(root.right);
        if(lv != -1 && rv != -1) return Math.min(lv,rv);
        if(lv != -1) return lv;
        if(rv != -1) return rv;
        return -1;
    }
}
