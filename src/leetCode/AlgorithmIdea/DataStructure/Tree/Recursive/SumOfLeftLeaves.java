package leetCode.AlgorithmIdea.DataStructure.Tree.Recursive;

import swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 题目描述：左叶子之和
 */

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (isLeave(root.left)) {
            return root.left.value + sumOfLeftLeaves(root.right);
        }
        sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        return sum;
    }

    private boolean isLeave(TreeNode left) {
        if (left == null) {
            return false;
        }
        return (left.left == null && left.right == null);
    }
}
