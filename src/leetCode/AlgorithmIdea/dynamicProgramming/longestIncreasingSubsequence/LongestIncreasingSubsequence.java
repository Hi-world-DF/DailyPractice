package src.leetCode.AlgorithmIdea.dynamicProgramming.longestIncreasingSubsequence;
/**
 * 动态规划：最长递增子序列
 * leetcode:https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 问题描述：最长上升子序列
 * */
public class LongestIncreasingSubsequence {
    //方法1：双循环+dp
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i] = max;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result,dp[i]);
        }
        return result;
    }
    //方法2：优化，可以使用二分查找将时间复杂度降低为 O(NlogN)
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int num) {
        int l = 0, h = len;
        while(l < h){
            int mid = l + (h-l)/2;
            if (num == tails[mid]){
                return mid;
            }else if(num > tails[mid]){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        return l;
    }
}
