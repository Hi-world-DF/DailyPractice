package AlgorithmIdea.greedyAlgorithm;
/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 买卖股票的最佳时期2
 * */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int n = prices.length;
        for(int i = 1; i < n;i++){
            if(prices[i]>prices[i-1]){
                maxP += prices[i] -prices[i-1];
            }
        }
        return maxP;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        int[] p = {1,2,7,3,5,2,6,7};
        BestTimeToBuyAndSellStock2 bttbass = new BestTimeToBuyAndSellStock2();
        int result = bttbass.maxProfit(p);
        System.out.println("最大的收益："+result);
    }

}
