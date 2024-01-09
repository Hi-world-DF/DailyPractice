package LeetCode.DataStructure.Tree.BST;

import swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 题目描述：把二叉搜索树转换为累加树
 * */
public class ConvertBstToGreaterTree {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    private void traver(TreeNode node) {
        if(node == null) return;
        traver(node.right);
        sum += node.val;
        node.val = sum;
        traver(node.left);
    }
}
