package swordFingerOffer.simple;

/**
 * 剑指 Offer 15. 二进制中1的个数
 *
 * @author Ernest
 * @version 1.0, 10/3/2021
 * @since 1.0.0
 */
public class HammingWeight {
    /**
     * 输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
     *
     * @param n 整数
     * @return 二进制数中1的个数
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 方法2：
     *
     * @param n 整数
     * @return 二进制数中1的个数
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
