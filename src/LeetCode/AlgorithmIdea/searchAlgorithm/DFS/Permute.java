package AlgorithmIdea.searchAlgorithm.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 数组的全排列
 *
 * @author Ernest
 * @version 1.0, 25/2/2021
 * @since 1.0.0
 */
public class Permute {
    /**
     * 求数组元素的全部排列组合
     *
     * @param nums
     * @return 全排列列表
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        //栈用来保存路径上的数
        Deque<Integer> path = new ArrayDeque<>();
        //used数组用来标记该数是否使用过
        boolean[] used = new boolean[len];
        //深度优先搜索
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        //如果深度达到了数组长度，说明每个元素都出现过，即为一种组合，则把这个path加入到结果列表
        if (depth == len) {
            res.add(new ArrayList<>(path));
        }
        //遍历数组元素
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
