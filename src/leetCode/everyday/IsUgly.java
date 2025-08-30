package leetCode.everyday;

/**
 * 263. 丑数
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class IsUgly {

    /**
     *丑数就是只包含质因数 2, 3, 5 的正整数。
     *
     * @param n 初始整数
     * @return 是否为丑数
     */
    public boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            }else if (n % 5 == 0) {
                n /= 5;
            } else {
                break;
            }
        }
        return n == 1;
    }
}
