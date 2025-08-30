package leetCode.AlgorithmIdea.dynamicProgramming.splitInteger;

/**
 * 动态规划：分割整数
 * leetcode:https://leetcode-cn.com/problems/unique-paths/
 * 问题描述： 整数拆分
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * dp[i - j], j * (j - i)));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
