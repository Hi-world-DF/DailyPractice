package LeetCode.everyday;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 *
 * @author Ernest
 * @version 1.0, 4/3/2021
 * @since 1.0.0
 */
public class MaxSlidingWindow {
    /**
     * 返回每次滑动窗口中的最大值
     *
     * @param nums 初始数组
     * @param k 滑动窗口大小
     * @return 每次滑动窗口的最大值组成的数组
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return nums;
        }
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len- k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(nums[j],max);
            }
            res[i] = max;
        }
        return res;
    }
}
