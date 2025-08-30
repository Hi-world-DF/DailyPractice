package leetCode.everyday;

/**
 * 202. 快乐数
 *
 * @author Ernest
 * @version 1.0, 12/4/2021
 * @since 1.0.0
 */
public class IsHappy {

    private int getNext(int n) {
        int cur = 0;
        while (n > 0) {
            int bit = n % 10;
            cur += bit * bit;
            n = n / 10;
        }
        return cur;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

}
