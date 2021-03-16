package everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author Ernest
 * @version 1.0, 15/3/2021
 * @since 1.0.0
 */
public class ThreeSum {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * @param nums 初始数组
     * @return 和为 0 且不重复的三元组的list
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (nums == null || n < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int k = n-1;
            int target = -nums[i];

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }

                if (j == k) {
                    break;
                }

                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[k]);
                    list.add(nums[j]);
                    res.add(list);
                }
            }
        }

        return res;
    }
}
