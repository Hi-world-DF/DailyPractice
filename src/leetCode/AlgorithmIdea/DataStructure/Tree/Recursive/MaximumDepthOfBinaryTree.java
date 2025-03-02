package src.leetCode.AlgorithmIdea.DataStructure.Tree.Recursive;

import src.swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 题目描述：二叉树的最大深度
 * */

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l,r)+1;
    }
}
