package LeetCode.AlgorithmIdea.dynamicProgramming.splitInteger;
/**
 * 动态规划：分割整数
 * leetcode:https://leetcode-cn.com/problems/decode-ways/
 * 问题描述： 解码方法
 * */
public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if(s == null || n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < n+1; i++) {
            int num1 = Integer.valueOf(s.substring(i-1,i));
            if(num1 != 0)
                dp[i] += dp[i-1];
            if(s.charAt(i-2) == '0')
                continue;
            int num2 = Integer.valueOf(s.substring(i-2,i));
            if(num2 <= 26)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
