package LeetCode.AlgorithmIdea.dynamicProgramming.fibonacciSequence;
/**
 * 动态规划：斐波那契数列
 * leetcode:https://leetcode-cn.com/problems/climbing-stairs/
 * 问题描述：爬楼梯
 * */
public class ClimbingStairs {
    //方法1：递归会超出时间限制
    public int climbStairs(int n) {
        if(n <= 2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
    //方法2：斐波那契
    public int climbStairs1(int n) {
        if (n <= 2) return n;
        int f = 1,b =2;
        for (int i = 2; i < n; i++) {
            int cur = f+b;
            f = b;
            b = cur;
        }
        return b;
    }

}
