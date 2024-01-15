package LeetCode.DataStructure.Tree.Recursive;

import swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/house-robber-iii/
 * 题目描述：间隔遍历（打家劫舍 III）
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val1 = root.value;
        if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }
}
