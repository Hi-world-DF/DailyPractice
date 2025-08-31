package leetCode.AlgorithmIdea.DataStructure.Tree.Traversal;

import swordFingerOffer.simple.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 数据结构：树【遍历】
 * leetcode:https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 题目描述：二叉树的后序遍历
 * */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return resultList;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null) {
                continue;
            }
            resultList.add(node.value);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(resultList);
        return resultList;
    }
}
