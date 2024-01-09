package LeetCode.everyday;

/**
 * 两数相除：给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * @author Ernest
 * @version 1.0, 22/2/2021
 * @since 1.0.0
 */
public class Divide {

    /**
     * 两数相除
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return 结果 int
     */
    public int divide(int dividend, int divisor) {
        long result = Integer.MIN_VALUE;
        boolean flag = false;
        if (dividend < 0 && divisor > 0) {
            flag = true;
        }
        if (dividend > 0 && divisor < 0) {
            flag = true;
        }

        int div = Math.abs(divisor);
        int dived = Math.abs(dividend);
        while (dived >= div) {
            dived -= div;
            result++;
        }
        if (flag) {
            return (int) (0 - result);
        }
        return (int) result;

    }
}
