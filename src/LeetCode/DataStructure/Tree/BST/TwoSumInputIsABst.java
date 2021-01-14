package DataStructure.Tree.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * 题目描述：两数之和 IV - 输入 BST
 * */
public class TwoSumInputIsABst {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root,nums);
        int i = 0,j = nums.size() -1;
        while(i < j) {
            int sum = nums.get(i) + nums.get(j);
            if(sum == k) return true;
            if(sum > k) j--;
            if(sum < k) i++;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if(root == null) return;
        inOrder(root.left,nums);
        nums.add(root.val);
        inOrder(root.right,nums);
    }
}
