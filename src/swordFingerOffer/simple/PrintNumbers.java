package swordFingerOffer.simple;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 *
 * @author Ernest
 * @version 1.0, 10/3/2021
 * @since 1.0.0
 */
public class PrintNumbers {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
     *
     * @param n 初始数
     * @return 所有数的数组
     */
    public int[] printNumbers(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }
        int[] res = new int[max-1];
        for (int i = 1; i < max; i++) {
            res[i-1] = i;
        }
        return res;
    }
}
