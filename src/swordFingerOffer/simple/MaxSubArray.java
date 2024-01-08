package SwordFingerOffer.simple;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class MaxSubArray {
    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     *
     * @param nums 初始数组
     * @return 返回子数组和最大值
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }
        int max = nums[0];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(nums[i], nums[i] + cur);
            max = Math.max(cur, max);
        }
        return max;
    }
}
