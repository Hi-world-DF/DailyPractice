package AlgorithmIdea.dynamicProgramming.fibonacciSequence;
/**
 * 动态规划：斐波那契数列
 * leetcode:https://leetcode-cn.com/problems/house-robber-ii/
 * 问题描述：打家劫舍2
 * */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        return Math.max(rob(nums,0,l-2),rob(nums,1,l-1));
    }
    private int rob(int[] nums , int first, int last){
        int pre1 = 0;
        int pre2 = 0;
        for (int i = first; i <= last; i++) {
            int cur = Math.max(pre1 , pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
