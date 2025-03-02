package src.leetCode.AlgorithmIdea.DataStructure.Tree.Recursive;

import src.swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/path-sum/
 * 题目描述：路径总和
 * */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.right == null && root.left == null && root.value == sum){
            return true;
        }
        if(hasPathSum(root.left,sum-root.value)  || hasPathSum(root.right,sum-root.value)){
            return true;
        }
        return false;
    }
}
