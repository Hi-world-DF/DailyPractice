package LeetCode.AlgorithmIdea.dynamicProgramming.longestIncreasingSubsequence;
/**
 * 动态规划：最长递增子序列
 * leetcode:https://leetcode-cn.com/problems/wiggle-subsequence/
 * 问题描述：摆动序列
 * */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]){
                up = down + 1;
            }else if(nums[i] < nums[i-1]){
                down = up + 1;
            }
        }
        return Math.max(up,down);
    }

}
