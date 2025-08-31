package leetCode.AlgorithmIdea.DataStructure.Tree.Recursive;

import swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/symmetric-tree/
 * 题目描述：对称二叉树
 * */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode l,TreeNode r){
        if(l == null && r == null) {
            return true;
        }
        if(l == null || r == null) {
            return false;
        }
        if(l.value != r.value) {
            return false;
        }
        return isSymmetric(l.left,r.right) && isSymmetric(l.right,r.left);
    }
}
