package src.leetCode.AlgorithmIdea.DataStructure.Tree.BST;

/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 * 题目描述：修剪二叉搜索树
 * */

public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val > R) return trimBST(root.left,L,R);
        if(root.val < L) return trimBST(root.right,L,R);
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }
}
