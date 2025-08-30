package leetCode.AlgorithmIdea.DataStructure.Tree.BST;

import src.swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 题目描述：二叉搜索树中第K小的元素
 */

public class KthSmallestElementInABst {
    //方法一：中序遍历
    private int count = 0;
    private int value;

    public int kthSmallest(TreeNode root, int k) {
        inOder(root, k);
        return value;
    }

    private void inOder(TreeNode root, int k) {
        if (root == null) return;
        inOder(root.left, k);
        count++;
        if (count == k) {
            value = root.value;
            return;
        }
        inOder(root.right, k);
    }

    //方法二：递归解法
    public int kthSmallest2(TreeNode root, int k) {
        int leftCurrent = minCount(root.left);
        if (leftCurrent == k - 1) return root.value;
        if (leftCurrent > k - 1) return kthSmallest2(root.left, k);
        return kthSmallest2(root.right, k - leftCurrent - 1);
    }

    private int minCount(TreeNode node) {
        if (node == null) return 0;
        return 1 + minCount(node.left) + minCount(node.right);
    }

}
