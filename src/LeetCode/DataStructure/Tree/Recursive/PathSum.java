package LeetCode.DataStructure.Tree.Recursive;

import swordFingerOffer.simple.TreeNode;

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
        if(root.right == null && root.left == null && root.val == sum){
            return true;
        }
        if(hasPathSum(root.left,sum-root.val)  || hasPathSum(root.right,sum-root.val)){
            return true;
        }
        return false;
    }
}
