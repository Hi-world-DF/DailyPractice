package SwordFingerOffer.simple;

/**
 * 剑指 Offer 57. 和为s的两个数字
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class TwoSum {
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
     * 如果有多对数字的和等于s，则输出任意一对即可。
     *
     * @param nums 初始数组
     * @param target 目标和
     * @return 两个数
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{nums[i], nums[j]};
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }
}
