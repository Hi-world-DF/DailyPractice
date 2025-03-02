package src.leetCode.AlgorithmIdea.math;
/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * 问题描述： 阶乘后的零
 * */
public class FactorialTrailingZeroes {
    /**
     * 方法1：不能满足所有用例
     * */
    public int trailingZeroes(int n) {
        int result = 0;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *=i;
        }
        while(factorial % 10 == 0){
            result++;
            factorial /= 10;
        }
        return result;
    }
    //方法2：相当于求5的个数，因为有5就会产生一个0；5出现2绝对比5出现次数多
    public int trailingZeroes1(int n) {
        return n == 0?0:(n / 5) + trailingZeroes(n/5);
    }
}
