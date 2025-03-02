package src.leetCode.AlgorithmIdea.dynamicProgramming.fibonacciSequence;
/**
 * 动态规划：斐波那契数列
 * leetcode:https://leetcode-cn.com/problems/house-robber/
 * 问题描述：打家劫舍
 * */
public class HouseRobber {
    //方法1：动态规划
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = nums.length;
        if(l == 1) return nums[0];
        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < l; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[l-1];
    }
}
