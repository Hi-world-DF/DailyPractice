package src.leetCode.AlgorithmIdea.DataStructure.Tree.Recursive;

import src.swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/path-sum-iii/
 * 题目描述：路径总和 3
 * */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int result =pathSumStartRoot(root,sum)+ pathSum(root.left,sum)+pathSum(root.right,sum);
        return result;
    }

    private int pathSumStartRoot(TreeNode root, int sum) {
        if(root == null) return 0;
        int result = 0;
        if(root.value == sum) result++;
        result += pathSumStartRoot(root.left,sum-root.value)+pathSumStartRoot(root.right,sum-root.value);
        return result;
    }
}
