package src.leetCode.AlgorithmIdea.dynamicProgramming.arrayInterval;
/**
 * 动态规划：数组区间
 * leetcode:https://leetcode-cn.com/problems/arithmetic-slices/
 * 问题描述： 等差数列划分
 * */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length==0) return 0;
        int n = A.length;
        //定义一个n的dp数组
        int[] dp = new int[n];
        //如果是等差，则可以得到dp[] = {0,0,1,2,3,..,n-2}
        for (int i = 2; i < n; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp[i] = dp[i-1] +1;
            }
        }
        int result = 0;
        //做累加
        for (int cnt:dp) {
            result += cnt;
        }
        return result;
    }
}
