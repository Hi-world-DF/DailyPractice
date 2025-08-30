package leetCode.AlgorithmIdea.math;

import java.util.Arrays;

/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * 问题描述： 乘积最大的三个数
 */
public class MaximumProductOfThreeNumbers {
    //方法1：先排序，最大的乘积，如果有负数，则要判定，前两个负数和最大正数和三个最大正数乘积比较
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int max = nums[l - 1] * nums[l - 2] * nums[l - 3];
        if (nums[0] < 0 && nums[1] < 0) {
            int max2 = nums[l - 1] * nums[0] * nums[1];
            max = Math.max(max2, max);
        }
        return max;
    }
}
