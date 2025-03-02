package src.leetCode.AlgorithmIdea.dynamicProgramming.matrixPath;
/**
 * 动态规划：矩阵路径
 * leetcode:https://leetcode-cn.com/problems/unique-paths/
 * 问题描述： 不同路径
 * */
public class UniquePaths {
    //方法1：动态规划
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        //第一列都为1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一行都为1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //中间的移动方法有上面的+左边的移方法数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    //方法2：数学解法
    public int uniquePaths2(int m, int n) {
        int S = m + n - 2;  // 总共的移动次数
        int D = m - 1;      // 向下的移动次数
        long ret = 1;
        for (int i = 1; i <= D; i++) {
            ret = ret * (S - D + i) / i;
        }
        return (int) ret;
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths2(10,10);
        System.out.println(result);
    }
}
