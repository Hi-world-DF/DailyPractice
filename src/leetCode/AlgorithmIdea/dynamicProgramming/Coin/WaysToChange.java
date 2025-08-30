package leetCode.AlgorithmIdea.dynamicProgramming.Coin;

/**
 * 面试题 08.11. 硬币
 *
 * @author Ernest
 * @version 1.0, 12/3/2021
 * @since 1.0.0
 */
public class WaysToChange {

    /**
     * 给定数量不限的硬币，币值为25分、10分、5分和1分，
     * 编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
     *
     * @param n n分钱的有几种表示法
     * @return
     */
    static final int mod = 1000000007;
    int[] coins = {25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % mod;
            }
        }
        return dp[n];
    }
}
