package leetCode.AlgorithmIdea.DataStructure.Tree.Recursive;

import src.swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/invert-binary-tree/
 * 题目描述：翻转二叉树
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //先保存右子树的指针，然后让root右指针指向左子树，左指针指向右子树指针
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }
}
