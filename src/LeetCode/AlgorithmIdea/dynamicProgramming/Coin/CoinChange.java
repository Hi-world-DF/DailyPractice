package LeetCode.AlgorithmIdea.dynamicProgramming.Coin;

/**
 * leetcode 322. 零钱兑换
 *
 * @author Ernest
 * @version 1.0, 12/3/2021
 * @since 1.0.0
 */
public class CoinChange {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * @param coins 硬币面值数组
     * @param amount 总金额
     * @return 最少硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp  = new int[amount + 1];
        int n = coins.length;
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
     }
}
