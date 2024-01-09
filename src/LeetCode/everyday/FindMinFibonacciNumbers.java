package LeetCode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 *
 * @author Ernest
 * @version 1.0, 5/3/2021
 * @since 1.0.0
 */
public class FindMinFibonacciNumbers {
    /**
     * 和为 K 的最少斐波那契数字数目
     *
     * @param k 和
     * @return 和为k的数字数目
     */
    public int findMinFibonacciNumbers(int k) {
        int a = 1,b = 1;
        List<Integer> fb = new ArrayList<>(Arrays.asList(a, b));
        while (a + b <= k) {
            fb.add(a + b);
            int c = a + b;
            a = b;
            b = c;
        }
        int res = 0;
        for (int i = fb.size() - 1; i > 0; i--) {
            if (k >= fb.get(i)) {
                k -= fb.get(i);
                res++;
            }
        }
        return res;
    }
}
