package leetCode.everyday;

/**
 * 456. 132模式
 *
 * @author Ernest
 * @version 1.0, 24/3/2021
 * @since 1.0.0
 */
public class Find132pattern {
    /**
     * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 
     * 被定义为：当 i < j < k 时，ai < ak < aj。
     * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
     *
     * @param nums 初始数组
     * @return 返回是否包含132的子序列
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int l = 0, r = n - 1;
        find132(nums, l, r);
        return false;
    }

    private boolean find132(int[] nums, int l, int r) {
        if (nums[l] < nums[r]) {
            for (int j = l; j < r; j++) {
                if (nums[j] > nums[r]) {
                    return true;
                }
            }
        }
        if (l < r) {
            return find132(nums, l, r-1) || find132(nums, l+1, r);
        }
        return false;
    }
}
