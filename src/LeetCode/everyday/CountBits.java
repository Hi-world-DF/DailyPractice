package everyday;

/**
 * 比特位计数:给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ;
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * @author Ernest
 * @version 1.0, 3/3/2021
 * @since 1.0.0
 */
public class CountBits {
    /**
     * 计算其二进制数中的 1 的数目
     *
     * @param num 非负整数
     * @return 1的个数的数组
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = count(i);
        }
        return res;
    }

    private int count(int i) {
        int count = 0;
        while (i > 0) {
            int r = i & 1;
            if (r == 1) {
              count++;
            }
            i >>= 1;
        }
        return count;
    }
}
