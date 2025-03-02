package src.leetCode.AlgorithmIdea.searchAlgorithm.DFS;

import java.util.ArrayList;
import java.util.List;


/**
 * 组合：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author Ernest
 * @version 1.0, 20/2/2021
 * @since 1.0.0
 */


public class Combine {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return lists;
    }

    private void dfs(int i, int n, int k) {
        if(list.size() + (n - i + 1) < k) {
            return;
        }
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(i);
        dfs(i + 1, n, k);
        list.remove(list.size() - 1);
        dfs(i + 1, n, k);
    }
}
