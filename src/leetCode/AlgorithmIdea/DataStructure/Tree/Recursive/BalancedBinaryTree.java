package leetCode.AlgorithmIdea.DataStructure.Tree.Recursive;

import swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/balanced-binary-tree/
 * 题目描述：平衡二叉树判断
 * */
public class BalancedBinaryTree {
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }
    private int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l-r)> 1){
            result = false;
        }
        return 1 + Math.max(l,r);
    }
}
