package src.leetCode.AlgorithmIdea.dynamicProgramming.longestIncreasingSubsequence;
/**
 * 动态规划：最长递增子序列
 * leetcode:https://leetcode-cn.com/problems/maximum-length-of-pair-chain/
 * 问题描述：最长数对链
 * */
import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1]){
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
}
