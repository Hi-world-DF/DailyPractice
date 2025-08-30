package swordFingerOffer.simple;

import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class MajorityElement {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     * @param nums 初始数组
     * @return 返回超过一半次数的数
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
