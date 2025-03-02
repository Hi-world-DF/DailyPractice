package src.swordFingerOffer.simple;

/**
 * 剑指 Offer 14- I. 剪绳子
 *
 * @author Ernest
 * @version 1.0, 23/3/2021
 * @since 1.0.0
 */
public class CuttingRope {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     *
     * @param n 绳子长度
     * @return 返回最大的面积
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int cur = Math.max(j * dp[i - j], (i - j) * j);
                max = Math.max(cur, max);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
