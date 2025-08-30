package swordFingerOffer.simple;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 *
 * @author Ernest
 * @version 1.0, 18/3/2021
 * @since 1.0.0
 */
public class LastRemaining {
    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，
     * 每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
     * 求出这个圆圈里剩下的最后一个数字。
     *
     * @param n 从 0~n-1个数
     * @param m 删除第几个元素
     * @return
     */
    public int lastRemaining(int n, int m) {
        return fun (n, m);
    }

    private int fun(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = fun(n-1, m);
        return (m + x) % n;
    }
}
