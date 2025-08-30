package leetCode.AlgorithmIdea.dynamicProgramming.splitInteger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 动态规划：分割整数
 * leetcode:https://leetcode-cn.com/problems/perfect-squares/
 * 问题描述： 整数拆分
 */
public class PerfectSquares {
    //方法1：动态规划
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_num[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_num[i] = i * i;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j < max_square_index; ++j) {
                if (i < square_num[j]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - square_num[j]] + 1);
            }
        }
        return dp[n];
    }
    //方法2：贪心枚举

    Set<Integer> square_nums = new HashSet<>();

    protected boolean is_divided_by(int n, int count) {
        if (count == 1) {
            return square_nums.contains(n);
        }
        for (Integer square : square_nums) {
            if (is_divided_by(n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }

    public int numSquares2(int n) {
        this.square_nums.clear();
        for (int i = 1; i * i <= n; ++i) {
            this.square_nums.add(i * i);
        }
        int count = 1;
        for (; count <= n; ++count) {
            if (is_divided_by(n, count)) {
                return count;
            }
        }
        return count;
    }
}
