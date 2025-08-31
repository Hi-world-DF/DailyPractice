package leetCode.AlgorithmIdea.DataStructure.Tree.BST;

import swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 题目描述：二叉树的最近公共祖先
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        return root;
    }
}
