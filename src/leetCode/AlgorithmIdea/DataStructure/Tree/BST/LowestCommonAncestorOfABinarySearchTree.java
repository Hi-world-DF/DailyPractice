package leetCode.AlgorithmIdea.DataStructure.Tree.BST;

import src.swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 题目描述：二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.value > p.value && root.value > q.value) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.value < p.value && root.value < q.value) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
