package everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author Ernest
 * @version 1.0, 20/2/2021
 * @since 1.0.0
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        int tempN = n;
        int tempK = k;
        int top = 1;
        int down = 1;
        for (int i = 0; i < k; i++) {
            top *= n--;
            down *= k--;
        }
        int sum = top / down;
        for (int i = 0; i < sum; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < tempN; j++) {
                for (int l = 0; l < tempK; l++) {

                }
            }
        }
        return lists;
    }
}
