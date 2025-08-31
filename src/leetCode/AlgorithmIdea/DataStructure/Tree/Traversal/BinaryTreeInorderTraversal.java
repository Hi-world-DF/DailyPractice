package leetCode.AlgorithmIdea.DataStructure.Tree.Traversal;

import swordFingerOffer.simple.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数据结构：树【遍历】
 * leetcode:https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 题目描述：二叉树的中序遍历
 * */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return resultList;
        }
        TreeNode currentNode = root;
        while(currentNode != null || !stack.isEmpty()){
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode node = stack.pop();
            resultList.add(node.value);
            currentNode = node.right;
        }
        return resultList;
    }
}
