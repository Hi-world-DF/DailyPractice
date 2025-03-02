package src.leetCode.AlgorithmIdea.DataStructure.Tree.Traversal;

import src.swordFingerOffer.simple.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数据结构：树【遍历】
 * leetcode:https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 题目描述：二叉树的前序遍历
 * */

public class BinaryTreePreOrderTraversal {
    /**递归*/
    /** void dfs(TreeNode root) {
        visit(root);
        dfs(root.left);
        dfs(root.right);
    }*/
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return resultList;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null) continue;
            resultList.add(node.value);
            stack.push(node.right);
            stack.push(node.left);
        }
        return resultList;
    }
}
