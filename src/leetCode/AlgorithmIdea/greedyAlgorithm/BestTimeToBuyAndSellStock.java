package leetCode.AlgorithmIdea.greedyAlgorithm;

/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 买卖股票的最佳时期
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        if (n == 0) {
            return 0;
        }
        int min = prices[0];
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = max > (prices[i] - min) ? max : (prices[i] - min);
            }
        }
        return max;
    }

    /**
     * main()测试
     */
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bttbass = new BestTimeToBuyAndSellStock();
        int[] p = {2, 3, 12, 1, 3, 4};
        int output = bttbass.maxProfit(p);
        System.out.println("最大的收益利润：" + output);
    }
}
